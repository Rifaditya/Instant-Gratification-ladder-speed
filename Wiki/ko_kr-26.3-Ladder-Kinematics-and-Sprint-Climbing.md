🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🏃 사다리 운동역학 및 전력 질주 등반 (MC 26.3)

> 📌 **저장소 소스 고지사항**: 본 위키 문서는 **저장소 내의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 이전의 최신 커밋 또는 개발 중인 기능이 포함될 수 있습니다.

This document provides an exhaustive, encyclopedic breakdown of vertical movement kinematics, sprint acceleration algorithms, and vector transformations implemented in **Instant Gratification: Ladder Speed** for Minecraft 26.3.

---

## 1. 공식 기술 정보

| Parameter | Technical Details |
| :--- | :--- |
| **Target Version** | Minecraft `26.3` |
| **Java Implementation** | [`ClimbingLogic.java`](file:///src/main/java/net/instantgratification/ladderspeed/logic/ClimbingLogic.java) |
| **Bytecode Mixin Hook** | [`LivingEntityMixin.java`](file:///src/main/java/net/instantgratification/ladderspeed/mixin/LivingEntityMixin.java) |
| **Controlling GameRules** | `ladderspeed.climb_speed`, `ladderspeed.sprint_multiplier` |
| **Base Vanilla Climb Speed** | $v_y = 0.2\text{ blocks/tick} \quad (4.0\text{ m/s})$ |
| **Modded Default Sprint Speed** | $v_y' = 0.3\text{ blocks/tick} \quad (6.0\text{ m/s})$ |
| **Applicable Block Tag** | `#minecraft:climbable` |

---

## 2. 서바이벌 플레이어 진행 순서 및 조작

```
[ Approaching Ladder ]
         |
         v
[ Enter Climbable Bounding Box ] (entity.onClimbable() == true)
         |
         +---> Normal Ascent (Forward / Jump) ---> Base Multiplier: CLIMB_SPEED (100 = 1.0x)
         |
         +---> Sprint Key Engaged (entity.isSprinting() == true)
                   |
                   v
         [ Dynamic Multiplier Calculation ]
         M_climb = (CLIMB_SPEED / 100) * (SPRINT_MULTIPLIER / 100)
                   |
                   v
         [ Vector Injection ]
         yd' = 0.2 * M_climb (0.3 b/t at default 150%)
```

1. **Approach & Mount**: The player walks into the collision box of a ladder or climbable block, setting `entity.onClimbable()` to `true`.
2. **Standard Ascent**: Pressing `W` or holding `Space` applies standard upward velocity. If `ladderspeed.climb_speed` is modified, the base velocity scales proportionally.
3. **Sprint Engagement**: Pressing the sprint key (or double-tapping `W`) sets `entity.isSprinting() == true`.
4. **Velocity Boost**: The mod calculates the composite multiplier and multiplies the vertical component of the motion vector.
5. **Dismount**: As soon as the player's bounding box clears the climbable block, normal walking physics immediately resume without residual inertia.

---

## 3. 수학적 운동역학 및 스케일링 계산식

### Upward Boost Multiplier Formula
The composite multiplier $M_{\text{climb}}$ is calculated in `ClimbingLogic.getUpwardBoostMultiplier(LivingEntity entity)`:

$$M_{\text{climb}} = \frac{\text{CLIMB\_SPEED}}{100} \times \left(\text{if sprinting: } \frac{\text{SPRINT\_MULTIPLIER}}{100} \quad \text{else: } 1.0\right)$$

### Resulting Vertical Velocity Vector
With vanilla base climb velocity defined as $v_y = 0.2\text{ blocks/tick}$, the transformed velocity $v_y'$ is:

$$v_y' = 0.2 \times M_{\text{climb}} \quad (\text{blocks/tick})$$

### Velocity in Standard Units (Blocks / Second)
Converting from Minecraft ticks ($20\text{ ticks} = 1\text{ second}$):

$$S_y = v_y' \times 20.0 \quad (\text{blocks/second})$$

### Comparison Table: Vanilla vs. Modded Configurations

| Configuration State | `climb_speed` | `sprint_multiplier` | Velocity ($v_y$) | Speed ($S_y$) | Ratio vs. Vanilla |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Vanilla Minecraft** | N/A | N/A | $0.20\text{ b/t}$ | $4.00\text{ m/s}$ | $1.00\times$ |
| **Ladder Speed (Walking Default)** | $100$ | $150$ | $0.20\text{ b/t}$ | $4.00\text{ m/s}$ | $1.00\times$ |
| **Ladder Speed (Sprinting Default)** | $100$ | $150$ | **$0.30\text{ b/t}$** | **$6.00\text{ m/s}$** | **$1.50\times$** |
| **Modded Fast (150% Base + 150% Sprint)** | $150$ | $150$ | $0.45\text{ b/t}$ | $9.00\text{ m/s}$ | $2.25\times$ |
| **Extreme Velocity (200% Base + 200% Sprint)**| $200$ | $200$ | $0.80\text{ b/t}$ | $16.00\text{ m/s}$ | $4.00\times$ |

---

## 4. 비주얼 상태 머신 및 아키텍처 흐름도

```
                 +-----------------------+
                 | LivingEntity Movement |
                 +-----------------------+
                             |
                             v
                 +-----------------------+
                 | entity.onClimbable()? |
                 +-----------------------+
                    /                 \
            [ NO ] /                   \ [ YES ]
                  v                     v
          [ Vanilla Physics ]   +---------------------------+
                                | Check Movement Direction  |
                                +---------------------------+
                                      /               \
                             [ UP ]  /                 \ [ DOWN ]
                                    v                   v
                        +----------------------+    +-----------------------+
                        | isSprinting()?       |    | Check Look Angle      |
                        +----------------------+    +-----------------------+
                           /            \                     /            \
                   [ YES ]/              \[ NO ]      [ > 45 deg ]/          \[ <= 45 deg ]
                         v                v                  v                v
                 [ Apply Sprint ]  [ Apply Normal ]  [ Snap Descend ]  [ Normal Descend ]
                 yd = 0.2 * M      yd = 0.2          yd = -0.4 b/t     yd * (DESCEND/100)
```

---

## 5. 인게임 명령어 및 구문

```sql
# Double climbing speed
/gamerule ladderspeed.climb_speed 200

# Set sprint multiplier to 2.0x (300 total)
/gamerule ladderspeed.sprint_multiplier 200

# Query active speed
/gamerule ladderspeed.climb_speed
```

---

## 🔗 Related Documentation
* [[MC 26.3 개요로 이동|ko_kr-26.3-Home]]
* [[26.3 고속 하강 및 슬라이드 조작|ko_kr-26.3-Snap-Descend-and-Slide-Controls]]
* [[26.3 구성 및 동적 게임 규칙|ko_kr-26.3-Configuration-and-GameRules]]
* [[26.3 아키텍처 및 믹스인(Mixins) 분석|ko_kr-26.3-Architecture-and-Mixins]]
* [[위키 홈으로 이동|ko_kr-Home]]
