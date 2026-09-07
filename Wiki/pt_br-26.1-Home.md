🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🪜 Minecraft 26.1 — Velocidade em Escadas (Ladder Speed)

> 📌 **Aviso Legal da Fonte do Repositório**: Esta documentação wiki reflete o **estado atual do código-fonte no repositório**, podendo incluir os commits mais recentes não lançados ou recursos em desenvolvimento antes dos lançamentos públicos no CurseForge e Modrinth.

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

1. [[26.1 Cinemática de Escadas e Subida em Corrida|pt_br-26.1-Ladder-Kinematics-and-Sprint-Climbing]]
   - Physics scaling math, upward velocity formulas, sprint detection, and friction calculations.
2. [[26.1 Descida Rápida e Controle de Deslize|pt_br-26.1-Snap-Descend-and-Slide-Controls]]
   - Pitch angle trigger thresholds ($> 45^\circ$), snap slide speed ($-0.4\text{ b/t}$), and sneak anchoring safety.
3. [[26.1 Configuração e GameRules Dinâmicas|pt_br-26.1-Configuration-and-GameRules]]
   - Complete reference table of all 4 GameRules under `ladderspeed:category`, bounds, and default values.
4. [[26.1 Arquitetura e Análise de Mixins|pt_br-26.1-Architecture-and-Mixins]]
   - Bytecode injections in `LivingEntityMixin`, stateless helper separation in `ClimbingLogic`, and registration lifecycle.
5. [[26.1 Ambiente de Desenvolvimento e Toolchain|pt_br-26.1-Developer-Setup-and-Building]]
   - Isolated Loom toolchain configuration, Gradle 9.3+ build instructions, and dev client testing.

---

## ⚡ Quick Survival Overview

- **Climb Faster**: Step onto any ladder and ascend normally.
- **Sprint Climb**: Hold your **Sprint** key while ascending to climb $1.5\times$ faster.
- **Snap Descend**: Look down past $45^\circ$ to rapidly slide down ladders at double speed.
- **Halt / Cling**: Hold **Sneak** (`Shift`) to instantly halt all downward sliding and cling safely to the ladder.

---

## 📜 Autoria & Licença

- **Author & Creator**: Dasik (Rifaditya)
- **License**: GNU General Public License v3.0 (GPLv3)
- **Project Collection**: Instant Gratification Collection
- **Repository**: [GitHub Source](https://github.com/Rifaditya/Instant-Gratification-ladder-speed)

> 📌 **Aviso Legal da Fonte do Repositório**: Esta documentação wiki reflete o **estado atual do código-fonte no repositório**, podendo incluir os commits mais recentes não lançados ou recursos em desenvolvimento antes dos lançamentos públicos no CurseForge e Modrinth.
