🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🛠️ 统一开发者环境配置与构建指南

> 📌 **代码仓库来源免责声明**：本维基文档反映了**代码仓库中的当前源码状态**，可能包含领先于 CurseForge 和 Modrinth 平台公开发布版本的最新未发布提交或开发中功能。

---

## 💻 开发环境先决条件

- **Java Development Kit (JDK)**: JDK 25 or newer is mandatory.
- **Gradle**: Gradle 9.3+ (invoked via bundled `./gradlew` wrapper).
- **Fabric Loom**: Pre-configured in `build.gradle` with Java compatibility suppression enabled.
- **Git**: Modern Git client with subproject / worktree support.

---

## 📥 代码仓库架构

```
Ladder Speed/
├── build.gradle                  # Loom build script for MC 26.1 anchor
├── gradle.properties             # Properties for MC 26.1 (1.0.0+26.1)
├── gradlew / gradlew.bat         # Gradle wrapper executables
├── src/                          # MC 26.1 source tree
│   └── main/
│       ├── java/net/instantgratification/ladderspeed/
│       │   ├── LadderSpeedFabric.java
│       │   ├── logic/ClimbingLogic.java
│       │   ├── mixin/LivingEntityMixin.java
│       │   └── reg/LadderSpeedRules.java
│       └── resources/
│           ├── fabric.mod.json
│           ├── ladderspeed.mixins.json
│           └── assets/ladderspeed/lang/en_us.json
└── Ladder Speed v26.3/
    └── Ladder Speed 26.3/        # Isolated MC 26.3 subproject
        ├── build.gradle          # Loom build script for MC 26.3
        ├── gradle.properties     # Properties for MC 26.3 (1.0.0+build.1+26.3)
        └── src/                  # MC 26.3 source tree
```

---

## 🔨 源码编译命令

### Building MC 26.1 (Root Project)
Open a terminal in the root repository directory and run:
```bash
./gradlew build --no-daemon
```
The compiled mod JAR will be output to:
`build/libs/ladder-speed-1.0.0+26.1.jar`

### Building MC 26.3 (Subproject)
Navigate into the 26.3 subproject directory:
```bash
cd "Ladder Speed v26.3/Ladder Speed 26.3"
./gradlew build --no-daemon
```
The compiled mod JAR will be output to:
`build/libs/ladder-speed-1.0.0+build.1+26.3.jar`

---

## 🧪 测试与执行

To launch a development client environment directly via Gradle Loom:
```bash
# MC 26.1 Development Client
./gradlew runClient

# MC 26.3 Development Client (from subproject directory)
./gradlew runClient
```

---

## 📜 作者与许可证

- **Author & Creator**: Dasik (Rifaditya)
- **License**: GNU General Public License v3.0 (GPLv3)
- **Project Collection**: Instant Gratification Collection
- **Repository**: [GitHub Source](https://github.com/Rifaditya/Instant-Gratification-ladder-speed)

> 📌 **代码仓库来源免责声明**：本维基文档反映了**代码仓库中的当前源码状态**，可能包含领先于 CurseForge 和 Modrinth 平台公开发布版本的最新未发布提交或开发中功能。
