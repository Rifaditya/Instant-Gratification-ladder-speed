🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🛠️ Environnement Développeur & Compilation (MC 26.1)

> 📌 **Avertissement relatif à la source du dépôt** : Cette documentation wiki reflète **l'état actuel du code source dans le dépôt**, qui peut inclure les derniers commits non publiés ou des fonctionnalités en cours de développement avant les versions publiques sur CurseForge et Modrinth.

This document provides exact toolchain requirements and build commands for compiling the **Minecraft 26.1** target of Ladder Speed.

---

## 💻 Prérequis de l'Environnement

| Tool | Specification |
| :--- | :--- |
| **Target Minecraft** | `26.1` |
| **Java JDK** | JDK 25 |
| **Gradle** | 9.3+ |
| **Fabric Loader** | `>=0.16.9` |
| **DasikLibrary** | `1.6.9+build.14 (*)` |

---

## 🔨 Compilation depuis les Sources

```bash
./gradlew build --no-daemon
```

### Target Output
The build produces the finalized production JAR:
`build/libs/ladder-speed-1.0.0+26.1.jar`

---

## 🧪 Tests & Exécution

Launch an isolated Fabric development client:
```bash
./gradlew runClient
```

---

## 📜 Auteur & Licence

- **Author & Creator**: Dasik (Rifaditya)
- **License**: GNU General Public License v3.0 (GPLv3)
- **Project Collection**: Instant Gratification Collection
- **Repository**: [GitHub Source](https://github.com/Rifaditya/Instant-Gratification-ladder-speed)

> 📌 **Avertissement relatif à la source du dépôt** : Cette documentation wiki reflète **l'état actuel du code source dans le dépôt**, qui peut inclure les derniers commits non publiés ou des fonctionnalités en cours de développement avant les versions publiques sur CurseForge et Modrinth.
