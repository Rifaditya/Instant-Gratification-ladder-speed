🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🪜 Instant Gratification: Ladder Speed Wiki

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

Welcome to the official developer and player technical documentation for **Instant Gratification: Ladder Speed**, a high-performance, configurable traversal and movement physics mod for Minecraft Fabric.

---

## 🎯 Version Selector Portal

Select your target Minecraft version anchor below to access dedicated, isolated documentation:

| Target Minecraft Version | Mod Release Line | Fabric Loader Bound | DasikLibrary Bound | Java Toolchain | Dedicated Documentation |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Minecraft 26.1** | `1.0.0+26.1` | `>=0.16.9` | `1.6.9+build.14` (`*`) | JDK 25 | [[👉 Enter MC 26.1 Wiki|26.1-Home]] |
| **Minecraft 26.3** | `1.0.0+build.1+26.3` | `>=0.19.3` | `>=1.8.36` | JDK 25 | [[👉 Enter MC 26.3 Wiki|26.3-Home]] |

---

## ⚡ Core Philosophy & Feature Overview

Vanilla Minecraft ladder traversal has remained fundamentally stagnant: climbing occurs at a rigid, slow crawling velocity ($0.2\text{ b/t}$ or $4.0\text{ m/s}$) regardless of whether the player is casually exploring or sprinting in high-stakes combat. Descending shafts often involves slow, tedious friction.

**Ladder Speed** eliminates artificial vertical bottlenecks while preserving authentic sandbox freedom:
- **🏃 Sprint Climbing**: Holding your sprint key on any climbable block dynamically multiplies your upward ascent speed by $1.5\times$ ($150\%$) by default ($0.3\text{ b/t}$ or $6.0\text{ m/s}$).
- **⚙️ Configurable Velocity Scaling**: Dedicated integer percentage GameRules allow independent scaling of climb speed and descend speed from $10\%$ to $1000\%$.
- **⬇️ Snap Descend (Fast Slide)**: Tilting player pitch downward beyond $45^\circ$ triggers an immediate, smooth fast slide at $-0.4\text{ b/t}$ ($-8.0\text{ m/s}$) — double vanilla speed.
- **🛡️ Sneak Cling Safety**: Holding Sneak (`Shift`) reliably halts downward momentum and securely anchors the player in place at $0.0\text{ b/t}$, guaranteeing complete player control.
- **🌐 Dynamic GameRules**: Fully configurable in real time via vanilla `/gamerule` commands without requiring server restarts or client-side menu mods.

---

## 🧭 Universal Navigation

- [[Version Compatibility Matrix|Version-Compatibility]]: Detailed compatibility breakdown across 26.1 and 26.3 anchors.
- [[Troubleshooting & FAQ|Troubleshooting-and-FAQ]]: Common control inquiries, block tag compatibility, and server desync mitigation.
- [[Unified Developer Setup & Building|Developer-Setup-and-Building]]: JDK 25 prerequisites, Loom toolchain setup, and Gradle build commands.

---

## 📜 Licensing & Attribution

- **Author & Creator**: Dasik (Rifaditya)
- **License**: GNU General Public License v3.0 (GPLv3)
- **Project Collection**: Instant Gratification Collection
- **Repository**: [GitHub Source](https://github.com/Rifaditya/Instant-Gratification-ladder-speed)

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.
