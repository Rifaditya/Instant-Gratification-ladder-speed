🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🛠️ 开发者配置与构建 (MC 26.3)

> 📌 **代码仓库来源免责声明**：本维基文档反映了**代码仓库中的当前源码状态**，可能包含领先于 CurseForge 和 Modrinth 平台公开发布版本的最新未发布提交或开发中功能。

This document provides exact toolchain requirements and build commands for compiling the **Minecraft 26.3** target of Ladder Speed.

---

## 💻 开发环境先决条件

| Tool | Specification |
| :--- | :--- |
| **Target Minecraft** | `26.3` |
| **Java JDK** | JDK 25 |
| **Gradle** | 9.3+ |
| **Fabric Loader** | `>=0.19.3` |
| **DasikLibrary** | `>=1.8.36` |

---

## 🔨 源码编译命令

```bash
./gradlew build --no-daemon
```

### Target Output
The build produces the finalized production JAR:
`build/libs/ladder-speed-1.0.0+build.1+26.3.jar`

---

## 🧪 测试与执行

Launch an isolated Fabric development client:
```bash
./gradlew runClient
```

---

## 📜 作者与许可证

- **Author & Creator**: Dasik (Rifaditya)
- **License**: GNU General Public License v3.0 (GPLv3)
- **Project Collection**: Instant Gratification Collection
- **Repository**: [GitHub Source](https://github.com/Rifaditya/Instant-Gratification-ladder-speed)

> 📌 **代码仓库来源免责声明**：本维基文档反映了**代码仓库中的当前源码状态**，可能包含领先于 CurseForge 和 Modrinth 平台公开发布版本的最新未发布提交或开发中功能。
