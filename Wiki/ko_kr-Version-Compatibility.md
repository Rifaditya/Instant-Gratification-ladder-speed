🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🔄 버전 호환성 매트릭스

> 📌 **저장소 소스 고지사항**: 본 위키 문서는 **저장소 내의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 이전의 최신 커밋 또는 개발 중인 기능이 포함될 수 있습니다.

---

## 📊 라이프사이클 및 환경 매트릭스

| Minecraft Anchor | Release Tag | Fabric Loader | Fabric API | DasikLibrary Bound | Java VM | Environment |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **MC 26.1** | `1.0.0+26.1` | `>=0.16.9` (Built with `0.18.4`) | `*` | `1.6.9+build.14` (`*`) | JDK 25+ | Client & Server (`*`) |
| **MC 26.3** | `1.0.0+build.1+26.3` | `>=0.19.3` | `*` | `>=1.8.36` | JDK 25+ | Client & Server (`*`) |

---

## 🏛️ 아키텍처 원칙 및 호환성 표준

### 1. The "1 Jar 1 Version" Policy
- **Root Directory**: Houses the modern MC 26.1 implementation.
- **Subproject Directory** (`Ladder Speed v26.3/Ladder Speed 26.3/`): Houses the modern MC 26.3 implementation.
- Discrete SemVer increments ensure that each compiled JAR targets an exact binary mapping without runtime reflection hacks.

### 2. Single Universal JAR Bounds for DasikLibrary
While Ladder Speed maintains version-tailored builds, its underlying dependency **DasikLibrary** operates as a universal library targeting modern versions (`>=26.1.2-`). Dynamic GameRule registration APIs remain binary compatible across snapshots.

### 3. Server-Client Synchronization Architecture
- **Full Multiplayer Parity**: Ladder Speed functions seamlessly in Singleplayer, LAN, and Dedicated Servers.
- **Server Authority**: The server dictates physics calculations and GameRule values.
- **Zero-Crash Mitigation**: Fallback safety guards prevent dividing by zero or unboxing null values before synchronization completes.

---

## 🧩 모드팩 통합 및 클라이언트/서버 지원

- **Client Only?**: No. Physics calculations are executed on the living entity tick. If installed on a dedicated server, all connecting vanilla-compatible clients will experience boosted ladder physics smoothly.
- **Mod Menu Support**: Contains metadata links to support platforms and documentation.
- **Suggested Companion Mods**:
  - **[Collapsible Game Rules](https://modrinth.com/mod/collapsible-gamerules)**: Groups all 4 `ladderspeed.*` rules under a tidy `ladderspeed:category` header in the world creation menu.

---

## 📜 작성자 및 라이선스

- **Author & Creator**: Dasik (Rifaditya)
- **License**: GNU General Public License v3.0 (GPLv3)
- **Project Collection**: Instant Gratification Collection
- **Repository**: [GitHub Source](https://github.com/Rifaditya/Instant-Gratification-ladder-speed)

> 📌 **저장소 소스 고지사항**: 본 위키 문서는 **저장소 내의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 이전의 최신 커밋 또는 개발 중인 기능이 포함될 수 있습니다.
