🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🪜 Minecraft 26.1 — 即时满足：梯子速度 (Ladder Speed)

> 📌 **代码仓库来源免责声明**：本维基文档反映了**代码仓库中的当前源码状态**，可能包含领先于 CurseForge 和 Modrinth 平台公开发布版本的最新未发布提交或开发中功能。

---

## 📦 Version Specifications

| Specification | Target Value |
| :--- | :--- |
| **Minecraft Version** | `26.1` |
| **Mod Specification** | `1.0.0+26.1` |
| **Fabric Loader** | `>=0.16.9` |
| **DasikLibrary Bound** | `1.6.9+build.14 (*)` |
| **Java Toolchain** | JDK 25 |
| **Environment** | Sided (`*`: Client & Dedicated Server) |

---

## 📚 Technical Subsystems

1. [[26.1 梯子运动学与冲刺攀爬|zh_cn-26.1-Ladder-Kinematics-and-Sprint-Climbing]]
   - Physics scaling math, upward velocity formulas, sprint detection, and friction calculations.
2. [[26.1 快速下滑与滑动控制|zh_cn-26.1-Snap-Descend-and-Slide-Controls]]
   - Pitch angle trigger thresholds ($> 45^\circ$), snap slide speed ($-0.4\text{ b/t}$), and sneak anchoring safety.
3. [[26.1 配置与动态游戏规则|zh_cn-26.1-Configuration-and-GameRules]]
   - Complete reference table of all 4 GameRules under `ladderspeed:category`, bounds, and default values.
4. [[26.1 架构设计与 Mixin 解析|zh_cn-26.1-Architecture-and-Mixins]]
   - Bytecode injections in `LivingEntityMixin`, stateless helper separation in `ClimbingLogic`, and registration lifecycle.
5. [[26.1 开发者配置与构建|zh_cn-26.1-Developer-Setup-and-Building]]
   - Isolated Loom toolchain configuration, Gradle 9.3+ build instructions, and dev client testing.

---

## ⚡ Quick Survival Overview

- **Climb Faster**: Step onto any ladder and ascend normally.
- **Sprint Climb**: Hold your **Sprint** key while ascending to climb $1.5\times$ faster.
- **Snap Descend**: Look down past $45^\circ$ to rapidly slide down ladders at double speed.
- **Halt / Cling**: Hold **Sneak** (`Shift`) to instantly halt all downward sliding and cling safely to the ladder.

---

## 📜 作者与许可证

- **Author & Creator**: Dasik (Rifaditya)
- **License**: GNU General Public License v3.0 (GPLv3)
- **Project Collection**: Instant Gratification Collection
- **Repository**: [GitHub Source](https://github.com/Rifaditya/Instant-Gratification-ladder-speed)

> 📌 **代码仓库来源免责声明**：本维基文档反映了**代码仓库中的当前源码状态**，可能包含领先于 CurseForge 和 Modrinth 平台公开发布版本的最新未发布提交或开发中功能。
