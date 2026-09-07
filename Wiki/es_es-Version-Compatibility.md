🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🔄 Matriz de Compatibilidad de Versiones

> 📌 **Descargo de responsabilidad de fuente de repositorio**: Esta documentación de wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes no publicadas o características en desarrollo antes de los lanzamientos públicos en CurseForge y Modrinth.

---

## 📊 Matriz de Ciclo de Vida y Entorno

| Minecraft Anchor | Release Tag | Fabric Loader | Fabric API | DasikLibrary Bound | Java VM | Environment |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **MC 26.1** | `1.0.0+26.1` | `>=0.16.9` (Built with `0.18.4`) | `*` | `1.6.9+build.14` (`*`) | JDK 25+ | Client & Server (`*`) |
| **MC 26.3** | `1.0.0+build.1+26.3` | `>=0.19.3` | `*` | `>=1.8.36` | JDK 25+ | Client & Server (`*`) |

---

## 🏛️ Principios Arquitectónicos y Estándares

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

## 🧩 Integración en Modpacks y Compatibilidad de Lados

- **Client Only?**: No. Physics calculations are executed on the living entity tick. If installed on a dedicated server, all connecting vanilla-compatible clients will experience boosted ladder physics smoothly.
- **Mod Menu Support**: Contains metadata links to support platforms and documentation.
- **Suggested Companion Mods**:
  - **[Collapsible Game Rules](https://modrinth.com/mod/collapsible-gamerules)**: Groups all 4 `ladderspeed.*` rules under a tidy `ladderspeed:category` header in the world creation menu.

---

## 📜 Autoría y Licencia

- **Author & Creator**: Dasik (Rifaditya)
- **License**: GNU General Public License v3.0 (GPLv3)
- **Project Collection**: Instant Gratification Collection
- **Repository**: [GitHub Source](https://github.com/Rifaditya/Instant-Gratification-ladder-speed)

> 📌 **Descargo de responsabilidad de fuente de repositorio**: Esta documentación de wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes no publicadas o características en desarrollo antes de los lanzamientos públicos en CurseForge y Modrinth.
