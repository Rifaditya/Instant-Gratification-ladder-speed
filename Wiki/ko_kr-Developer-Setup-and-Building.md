🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🛠️ 통합 개발자 환경 설정 및 빌드 가이드

> 📌 **저장소 소스 고지사항**: 본 위키 문서는 **저장소 내의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 이전의 최신 커밋 또는 개발 중인 기능이 포함될 수 있습니다.

---

## 💻 개발 환경 필수 구성 요소

- **Java Development Kit (JDK)**: JDK 25 or newer is mandatory.
- **Gradle**: Gradle 9.3+ (invoked via bundled `./gradlew` wrapper).
- **Fabric Loom**: Pre-configured in `build.gradle` with Java compatibility suppression enabled.
- **Git**: Modern Git client with subproject / worktree support.

---

## 📥 저장소 디렉터리 구조

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

## 🔨 소스 코드 컴파일 빌드

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

## 🧪 테스트 및 실행

To launch a development client environment directly via Gradle Loom:
```bash
# MC 26.1 Development Client
./gradlew runClient

# MC 26.3 Development Client (from subproject directory)
./gradlew runClient
```

---

## 📜 작성자 및 라이선스

- **Author & Creator**: Dasik (Rifaditya)
- **License**: GNU General Public License v3.0 (GPLv3)
- **Project Collection**: Instant Gratification Collection
- **Repository**: [GitHub Source](https://github.com/Rifaditya/Instant-Gratification-ladder-speed)

> 📌 **저장소 소스 고지사항**: 본 위키 문서는 **저장소 내의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 이전의 최신 커밋 또는 개발 중인 기능이 포함될 수 있습니다.
