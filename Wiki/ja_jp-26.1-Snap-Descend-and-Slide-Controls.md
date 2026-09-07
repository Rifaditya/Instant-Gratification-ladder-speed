🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# ⬇️ 急速降下とスライド操作 (MC 26.1)

> 📌 **リポジトリソースに関する免責事項**: このWikiドキュメントは**リポジトリ内の現在のソースコード状態**を反映しており、CurseForgeおよびModrinthでの公開リリース前の最新の未リリースコミットや開発中の機能が含まれている場合があります。

This document details the mechanics, camera pitch trigger thresholds, vector transformations, and safety anchoring features of **Snap Descend** in Minecraft 26.1.

---

## 1. 公式技術仕様

| Parameter | Technical Details |
| :--- | :--- |
| **Target Version** | Minecraft `26.1` |
| **Java Implementation** | [`ClimbingLogic.java`](file:///src/main/java/net/instantgratification/ladderspeed/logic/ClimbingLogic.java) |
| **Bytecode Mixin Hook** | [`LivingEntityMixin.java`](file:///src/main/java/net/instantgratification/ladderspeed/mixin/LivingEntityMixin.java) |
| **Controlling GameRules** | `ladderspeed.snap_descend`, `ladderspeed.descend_speed` |
| **Pitch Activation Angle** | $\theta_{\text{pitch}} > 45.0^\circ$ (Looking downwards) |
| **Snap Slide Velocity** | $v_y = -0.4\text{ blocks/tick} \quad (-8.0\text{ m/s})$ |
| **Sneak Suppression Guard** | `!entity.isSuppressingSlidingDownLadder()` |
| **Fall Damage Risk** | Zero (reset on `#minecraft:climbable`) |

---

## 2. サバイバルでの操作手順とゲームプレイ

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

## 3. 数学的運動力学とスケーリング計算式

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

## 4. ゲーム内コマンドと構文

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
* [[MC 26.1 概要に戻る|ja_jp-26.1-Home]]
* [[26.1 はしご運動力学とダッシュ登攀|ja_jp-26.1-Ladder-Kinematics-and-Sprint-Climbing]]
* [[26.1 設定と動的ゲームルール|ja_jp-26.1-Configuration-and-GameRules]]
* [[26.1 アーキテクチャ設計と Mixin 解析|ja_jp-26.1-Architecture-and-Mixins]]
* [[ホームに戻る|ja_jp-Home]]
