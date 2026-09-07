🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🛠️ Configuración de Desarrollador y Compilación (MC 26.3)

> 📌 **Descargo de responsabilidad de fuente de repositorio**: Esta documentación de wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes no publicadas o características en desarrollo antes de los lanzamientos públicos en CurseForge y Modrinth.

This document provides exact toolchain requirements and build commands for compiling the **Minecraft 26.3** target of Ladder Speed.

---

## 💻 Requisitos Previos del Entorno

| Tool | Specification |
| :--- | :--- |
| **Target Minecraft** | `26.3` |
| **Java JDK** | JDK 25 |
| **Gradle** | 9.3+ |
| **Fabric Loader** | `>=0.19.3` |
| **DasikLibrary** | `>=1.8.36` |

---

## 🔨 Compilación desde el Código Fuente

```bash
./gradlew build --no-daemon
```

### Target Output
The build produces the finalized production JAR:
`build/libs/ladder-speed-1.0.0+build.1+26.3.jar`

---

## 🧪 Pruebas y Ejecución

Launch an isolated Fabric development client:
```bash
./gradlew runClient
```

---

## 📜 Autoría y Licencia

- **Author & Creator**: Dasik (Rifaditya)
- **License**: GNU General Public License v3.0 (GPLv3)
- **Project Collection**: Instant Gratification Collection
- **Repository**: [GitHub Source](https://github.com/Rifaditya/Instant-Gratification-ladder-speed)

> 📌 **Descargo de responsabilidad de fuente de repositorio**: Esta documentación de wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes no publicadas o características en desarrollo antes de los lanzamientos públicos en CurseForge y Modrinth.
