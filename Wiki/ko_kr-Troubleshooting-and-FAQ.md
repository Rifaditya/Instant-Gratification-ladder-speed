🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# ❓ 문제 해결 및 자주 묻는 질문 (FAQ)

> 📌 **저장소 소스 고지사항**: 본 위키 문서는 **저장소 내의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 이전의 최신 커밋 또는 개발 중인 기능이 포함될 수 있습니다.

---

## 🔍 진단 체크리스트

### 1. Snap Descend Not Triggering
- **Check Pitch Angle**: Snap descend requires looking down sharply at an angle greater than $45.0^\circ$ pitch (`entity.getXRot() > 45.0f`). If you are looking diagonally downward at $30^\circ$ or $40^\circ$, normal controlled descent speed applies.
- **Check Sneak Key**: If you are holding `Shift` (Sneak), the safety suppression method `entity.isSuppressingSlidingDownLadder()` returns `true`. This locks your position and intentionally prevents sliding. Release `Shift` to begin descending.
- **Check GameRule**: Verify that `ladderspeed.snap_descend` is set to `true`:
  ```sql
  /gamerule ladderspeed.snap_descend
  ```

### 2. Sprint Climbing Boost Not Applying
- **Active Sprinting Required**: You must be actively sprinting (`entity.isSprinting() == true`). Simply pressing `W` without toggling sprint will result in standard climb speed.
- **Keybind Conflicts**: If using toggle sprint, verify that the sprint state is visibly active on your HUD.
- **Multiplier Value**: Check the sprint multiplier GameRule:
  ```sql
  /gamerule ladderspeed.sprint_multiplier
  ```
  Default is `150` ($1.5\times$). If set to `100`, sprinting will climb at normal speed.

### 3. Block Tag Compatibility (Vines, Scaffolding, Modded Ladders)
- **Tag Integration**: Ladder Speed injects into `LivingEntity.handleOnClimbable` and `LivingEntity.handleRelativeFrictionAndCalculateMovement`, which check `entity.onClimbable()`.
- **Vanilla Climbables**: By default, Minecraft considers any block in `#minecraft:climbable` as climbable:
  - Standard Wooden Ladders (`minecraft:ladder`)
  - Vines (`minecraft:vine`)
  - Weeping Vines (`minecraft:weeping_vines` / `minecraft:weeping_vines_plant`)
  - Twisting Vines (`minecraft:twisting_vines` / `minecraft:twisting_vines_plant`)
  - Scaffolding (`minecraft:scaffolding`)
- **Modded Ladders**: Any custom ladder from other mods that registers itself in the `#minecraft:climbable` block tag inherits Ladder Speed's kinematics automatically!

### 4. Server Velocity Desync / Rubberbanding
- **Client Zero Mitigation**: `ClimbingLogic` guards against unsynchronized client GameRule lookups:
  ```java
  if (climbRule <= 0) climbRule = 100;
  if (sprintRule <= 0) sprintRule = 150;
  if (descendRule <= 0) descendRule = 100;
  ```
- **High Latency Servers**: On high-ping multiplayer servers, ensure the server has installed matching versions of Fabric API and DasikLibrary.

---

## 🙋 자주 묻는 질문

#### Q: Will this mod be backported to 1.20.1, 1.21.1, or older versions?
**A**: No. Instant Gratification focuses strictly on modern releases (`26.1+`). Backports will not be produced.

#### Q: Does snap descend cause fall damage?
**A**: No! While snap descend moves at $-0.4\text{ b/t}$, the entity remains in the climbing state (`onClimbable() == true`). Minecraft resets accumulated fall distance while on a climbable surface. When reaching the floor, the player lands safely.

#### Q: Can I set the climbing speed to extreme values?
**A**: Yes! In accordance with the **Player Agency & Anti-Nanny Invariant**, you can set `ladderspeed.climb_speed` up to `1000` ($10.0\times$ speed) via `/gamerule`.

---

## 📜 작성자 및 라이선스

- **Author & Creator**: Dasik (Rifaditya)
- **License**: GNU General Public License v3.0 (GPLv3)
- **Project Collection**: Instant Gratification Collection
- **Repository**: [GitHub Source](https://github.com/Rifaditya/Instant-Gratification-ladder-speed)

> 📌 **저장소 소스 고지사항**: 본 위키 문서는 **저장소 내의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 이전의 최신 커밋 또는 개발 중인 기능이 포함될 수 있습니다.
