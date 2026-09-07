🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🪜 Minecraft 26.1 — 사다리 속도 (Ladder Speed)

> 📌 **저장소 소스 고지사항**: 본 위키 문서는 **저장소 내의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 이전의 최신 커밋 또는 개발 중인 기능이 포함될 수 있습니다.

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

1. [[26.1 사다리 운동역학 및 전력 질주 등반|ko_kr-26.1-Ladder-Kinematics-and-Sprint-Climbing]]
   - Physics scaling math, upward velocity formulas, sprint detection, and friction calculations.
2. [[26.1 고속 하강 및 슬라이드 조작|ko_kr-26.1-Snap-Descend-and-Slide-Controls]]
   - Pitch angle trigger thresholds ($> 45^\circ$), snap slide speed ($-0.4\text{ b/t}$), and sneak anchoring safety.
3. [[26.1 구성 및 동적 게임 규칙|ko_kr-26.1-Configuration-and-GameRules]]
   - Complete reference table of all 4 GameRules under `ladderspeed:category`, bounds, and default values.
4. [[26.1 아키텍처 및 믹스인(Mixins) 분석|ko_kr-26.1-Architecture-and-Mixins]]
   - Bytecode injections in `LivingEntityMixin`, stateless helper separation in `ClimbingLogic`, and registration lifecycle.
5. [[26.1 개발자 설정 및 툴체인|ko_kr-26.1-Developer-Setup-and-Building]]
   - Isolated Loom toolchain configuration, Gradle 9.3+ build instructions, and dev client testing.

---

## ⚡ Quick Survival Overview

- **Climb Faster**: Step onto any ladder and ascend normally.
- **Sprint Climb**: Hold your **Sprint** key while ascending to climb $1.5\times$ faster.
- **Snap Descend**: Look down past $45^\circ$ to rapidly slide down ladders at double speed.
- **Halt / Cling**: Hold **Sneak** (`Shift`) to instantly halt all downward sliding and cling safely to the ladder.

---

## 📜 작성자 및 라이선스

- **Author & Creator**: Dasik (Rifaditya)
- **License**: GNU General Public License v3.0 (GPLv3)
- **Project Collection**: Instant Gratification Collection
- **Repository**: [GitHub Source](https://github.com/Rifaditya/Instant-Gratification-ladder-speed)

> 📌 **저장소 소스 고지사항**: 본 위키 문서는 **저장소 내의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 이전의 최신 커밋 또는 개발 중인 기능이 포함될 수 있습니다.
