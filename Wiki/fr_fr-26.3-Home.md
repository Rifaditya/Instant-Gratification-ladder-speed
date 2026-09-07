🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🪜 Minecraft 26.3 — Vitesse sur Échelle (Ladder Speed)

> 📌 **Avertissement relatif à la source du dépôt** : Cette documentation wiki reflète **l'état actuel du code source dans le dépôt**, qui peut inclure les derniers commits non publiés ou des fonctionnalités en cours de développement avant les versions publiques sur CurseForge et Modrinth.

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

1. [[26.3 Cinématique d'Échelle & Escalade en Sprint|fr_fr-26.3-Ladder-Kinematics-and-Sprint-Climbing]]
   - Physics scaling math, upward velocity formulas, sprint detection, and friction calculations.
2. [[26.3 Descente Rapide & Contrôle de Glisse|fr_fr-26.3-Snap-Descend-and-Slide-Controls]]
   - Pitch angle trigger thresholds ($> 45^\circ$), snap slide speed ($-0.4\text{ b/t}$), and sneak anchoring safety.
3. [[26.3 Configuration & GameRules Dynamiques|fr_fr-26.3-Configuration-and-GameRules]]
   - Complete reference table of all 4 GameRules under `ladderspeed:category`, bounds, and default values.
4. [[26.3 Architecture & Analyse des Mixins|fr_fr-26.3-Architecture-and-Mixins]]
   - Bytecode injections in `LivingEntityMixin`, stateless helper separation in `ClimbingLogic`, and registration lifecycle.
5. [[26.3 Environnement Développeur & Outils|fr_fr-26.3-Developer-Setup-and-Building]]
   - Isolated Loom toolchain configuration, Gradle 9.3+ build instructions, and dev client testing.

---

## ⚡ Quick Survival Overview

- **Climb Faster**: Step onto any ladder and ascend normally.
- **Sprint Climb**: Hold your **Sprint** key while ascending to climb $1.5\times$ faster.
- **Snap Descend**: Look down past $45^\circ$ to rapidly slide down ladders at double speed.
- **Halt / Cling**: Hold **Sneak** (`Shift`) to instantly halt all downward sliding and cling safely to the ladder.

---

## 📜 Auteur & Licence

- **Author & Creator**: Dasik (Rifaditya)
- **License**: GNU General Public License v3.0 (GPLv3)
- **Project Collection**: Instant Gratification Collection
- **Repository**: [GitHub Source](https://github.com/Rifaditya/Instant-Gratification-ladder-speed)

> 📌 **Avertissement relatif à la source du dépôt** : Cette documentation wiki reflète **l'état actuel du code source dans le dépôt**, qui peut inclure les derniers commits non publiés ou des fonctionnalités en cours de développement avant les versions publiques sur CurseForge et Modrinth.
