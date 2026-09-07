🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🪜 Minecraft 26.3 — 即時滿足：梯子速度 (Ladder Speed)

> 📌 **代碼倉庫來源免責聲明**：本維基文件反映了**代碼倉庫中的當前源碼狀態**，可能包含領先於 CurseForge 和 Modrinth 平台公開發布版本的最新未發布提交或開發中功能。

---

## 📦 Version Specifications

| Specification | Target Value |
| :--- | :--- |
| **Minecraft Version** | `26.3` |
| **Mod Specification** | `1.0.0+build.1+26.3` |
| **Fabric Loader** | `>=0.19.3` |
| **DasikLibrary Bound** | `>=1.8.36` |
| **Java Toolchain** | JDK 25 |
| **Environment** | Sided (`*`: Client & Dedicated Server) |

---

## 📚 Technical Subsystems

1. [[26.3 梯子運動學與衝刺攀爬|zh_tw-26.3-Ladder-Kinematics-and-Sprint-Climbing]]
   - Physics scaling math, upward velocity formulas, sprint detection, and friction calculations.
2. [[26.3 快速下滑與滑動控制|zh_tw-26.3-Snap-Descend-and-Slide-Controls]]
   - Pitch angle trigger thresholds ($> 45^\circ$), snap slide speed ($-0.4\text{ b/t}$), and sneak anchoring safety.
3. [[26.3 配置與動態遊戲規則|zh_tw-26.3-Configuration-and-GameRules]]
   - Complete reference table of all 4 GameRules under `ladderspeed:category`, bounds, and default values.
4. [[26.3 架構設計與 Mixin 解析|zh_tw-26.3-Architecture-and-Mixins]]
   - Bytecode injections in `LivingEntityMixin`, stateless helper separation in `ClimbingLogic`, and registration lifecycle.
5. [[26.3 開發者配置與構建|zh_tw-26.3-Developer-Setup-and-Building]]
   - Isolated Loom toolchain configuration, Gradle 9.3+ build instructions, and dev client testing.

---

## ⚡ Quick Survival Overview

- **Climb Faster**: Step onto any ladder and ascend normally.
- **Sprint Climb**: Hold your **Sprint** key while ascending to climb $1.5\times$ faster.
- **Snap Descend**: Look down past $45^\circ$ to rapidly slide down ladders at double speed.
- **Halt / Cling**: Hold **Sneak** (`Shift`) to instantly halt all downward sliding and cling safely to the ladder.

---

## 📜 作者與許可證

- **Author & Creator**: Dasik (Rifaditya)
- **License**: GNU General Public License v3.0 (GPLv3)
- **Project Collection**: Instant Gratification Collection
- **Repository**: [GitHub Source](https://github.com/Rifaditya/Instant-Gratification-ladder-speed)

> 📌 **代碼倉庫來源免責聲明**：本維基文件反映了**代碼倉庫中的當前源碼狀態**，可能包含領先於 CurseForge 和 Modrinth 平台公開發布版本的最新未發布提交或開發中功能。
