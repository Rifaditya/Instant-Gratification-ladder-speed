🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🛠️ Entwickler-Setup & Kompilierung (MC 26.3)

> 📌 **Haftungsausschluss zur Repository-Quelle**: Diese Wiki-Dokumentation spiegelt den **aktuellen Quellcode-Zustand im Repository** wider, der möglicherweise die neuesten unveröffentlichten Commits oder in Entwicklung befindliche Funktionen vor den öffentlichen Versionen auf CurseForge und Modrinth enthält.

This document provides exact toolchain requirements and build commands for compiling the **Minecraft 26.3** target of Ladder Speed.

---

## 💻 Entwicklungsumgebungs-Voraussetzungen

| Tool | Specification |
| :--- | :--- |
| **Target Minecraft** | `26.3` |
| **Java JDK** | JDK 25 |
| **Gradle** | 9.3+ |
| **Fabric Loader** | `>=0.19.3` |
| **DasikLibrary** | `>=1.8.36` |

---

## 🔨 Kompilierung aus Quellcode

```bash
./gradlew build --no-daemon
```

### Target Output
The build produces the finalized production JAR:
`build/libs/ladder-speed-1.0.0+build.1+26.3.jar`

---

## 🧪 Testen & Ausführung

Launch an isolated Fabric development client:
```bash
./gradlew runClient
```

---

## 📜 Autor & Lizenz

- **Author & Creator**: Dasik (Rifaditya)
- **License**: GNU General Public License v3.0 (GPLv3)
- **Project Collection**: Instant Gratification Collection
- **Repository**: [GitHub Source](https://github.com/Rifaditya/Instant-Gratification-ladder-speed)

> 📌 **Haftungsausschluss zur Repository-Quelle**: Diese Wiki-Dokumentation spiegelt den **aktuellen Quellcode-Zustand im Repository** wider, der möglicherweise die neuesten unveröffentlichten Commits oder in Entwicklung befindliche Funktionen vor den öffentlichen Versionen auf CurseForge und Modrinth enthält.
