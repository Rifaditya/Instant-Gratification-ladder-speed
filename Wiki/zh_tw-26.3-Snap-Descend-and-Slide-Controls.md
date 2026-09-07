🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# ⬇️ 快速下滑與滑動控制 (MC 26.3)

> 📌 **代碼倉庫來源免責聲明**：本維基文件反映了**代碼倉庫中的當前源碼狀態**，可能包含領先於 CurseForge 和 Modrinth 平台公開發布版本的最新未發布提交或開發中功能。

This document details the mechanics, camera pitch trigger thresholds, vector transformations, and safety anchoring features of **Snap Descend** in Minecraft 26.3.

---

## 1. 官方技術資訊

| Parameter | Technical Details |
| :--- | :--- |
| **Target Version** | Minecraft `26.3` |
| **Java Implementation** | [`ClimbingLogic.java`](file:///src/main/java/net/instantgratification/ladderspeed/logic/ClimbingLogic.java) |
| **Bytecode Mixin Hook** | [`LivingEntityMixin.java`](file:///src/main/java/net/instantgratification/ladderspeed/mixin/LivingEntityMixin.java) |
| **Controlling GameRules** | `ladderspeed.snap_descend`, `ladderspeed.descend_speed` |
| **Pitch Activation Angle** | $\theta_{\text{pitch}} > 45.0^\circ$ (Looking downwards) |
| **Snap Slide Velocity** | $v_y = -0.4\text{ blocks/tick} \quad (-8.0\text{ m/s})$ |
| **Sneak Suppression Guard** | `!entity.isSuppressingSlidingDownLadder()` |
| **Fall Damage Risk** | Zero (reset on `#minecraft:climbable`) |

---

## 2. 生存操作流程與核心玩法

```
[ Player On Ladder ]
         |
         +---> Looking Straight / Up (Pitch <= 45.0 deg)
         |         |
         |         +---> Press Shift/Sneak ---> Complete Anchor (yd = 0.0 b/t)
         |         +---> Descending Down    ---> Standard Scaling: yd * (DESCEND_SPEED / 100)
         |
         +---> Tilt Camera Sharply Down (Pitch > 45.0 deg)
                   |
                   v
         [ Check Sneak Key Status ]
                   |
           [ NOT Sneaking ]
                   v
         [ SNAP DESCEND TRIGGERED ]
         yd = -0.4 blocks/tick (-8.0 m/s)
                   |
                   +---> Release Camera / Hold Shift ---> Immediate Safety Halt
                   +---> Reach Base Block           ---> Smooth Floor Transition
```

1. **Initiate Slide**: Look downwards toward the base of the ladder until your camera crosshair pitches past $45^\circ$ downward.
2. **High-Speed Descent**: Downward velocity is overridden to $-0.4\text{ b/t}$ ($-8.0\text{ m/s}$), allowing rapid clearance of vertical shafts.
3. **Emergency Stop (Cling)**: Press and hold `Shift` (Sneak) at any time during descent to instantly cancel the slide and anchor safely in place.
4. **Controlled Descent**: If you want to descend at a controlled pace, keep your pitch angle shallower than $45^\circ$; descent speed will then respect `ladderspeed.descend_speed`.

---

## 3. 數學公式與運動學模型

### Pitch Angle Condition
Player pitch in Minecraft is defined such that straight ahead is $0^\circ$, looking straight up is $-90^\circ$, and looking straight down is $+90^\circ$:

$$\text{Trigger Condition} \iff \theta_{\text{pitch}} > 45.0^\circ$$

### Downward Velocity Equations
In `ClimbingLogic.handleDescentMovement(LivingEntity entity, Vec3 motion)`:

$$v_y' = \begin{cases} 
-0.4 & \text{if } \text{snap\_descend} = \text{true} \land \theta_{\text{pitch}} > 45.0^\circ \land \neg \text{sneaking} \\
v_y \times \frac{\text{DESCEND\_SPEED}}{100} & \text{otherwise}
\end{cases}$$

---

## 4. 遊戲內命令與語法

```sql
# Disable snap descend
/gamerule ladderspeed.snap_descend false

# Re-enable snap descend
/gamerule ladderspeed.snap_descend true

# Double normal descent speed
/gamerule ladderspeed.descend_speed 200
```

---

## 🔗 Related Documentation
* [[返回 MC 26.3 門戶概覽|zh_tw-26.3-Home]]
* [[26.3 梯子運動學與衝刺攀爬|zh_tw-26.3-Ladder-Kinematics-and-Sprint-Climbing]]
* [[26.3 配置與動態遊戲規則|zh_tw-26.3-Configuration-and-GameRules]]
* [[26.3 架構設計與 Mixin 解析|zh_tw-26.3-Architecture-and-Mixins]]
* [[返回維基首頁|zh_tw-Home]]
