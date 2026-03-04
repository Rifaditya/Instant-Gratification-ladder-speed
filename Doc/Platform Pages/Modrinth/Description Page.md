<div align="center">

![Mod Banner](https://raw.githubusercontent.com/Rifaditya/Instant-Gratification-ladder-speed/main/Images/Banner.png)

</div>
<p align="center">
    <a href="https://modrinth.com/mod/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&logo=fabric" alt="Requires Fabric API"></a>
    <a href="https://modrinth.com/mod/dasik-library"><img src="https://img.shields.io/badge/Requires-Dasik_Library-blue?style=for-the-badge&logo=modrinth" alt="Modrinth: Dasik Library"></a>
    <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java" alt="Java">
    <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License">
    <img src="https://img.shields.io/badge/Minecraft-26.1+-brightgreen?style=for-the-badge" alt="Minecraft 26.1+">
</p>

# 🪜 Ladder Speed: The "Ascension" Update (Build 1)

**No Backports:** I will **NOT** backport this mod to older versions (1.21, 1.20, etc.). Please do not ask.

Vanilla ladders are agonizingly slow. You crawl up them at a fixed, unchangeable pace, regardless of whether you are walking or sprinting. Going down isn't much better, often resulting in tedious shaft descents that disrespect your time.

**Ladder Speed** changes this foundation. It lets you configure how fast you climb ladders, speeds up climbing when sprinting, and lets you slide down instantly by looking down.

---

## ✨ Features

### ⚙️ Configurable Base Speed

Vanilla ladders are slow and agonizing. This mod lets you adjust the default climbing & descending speeds independently to match your modpack's pacing.

> [!NOTE]
> **Dynamic Scaling**: The speed multiplier dynamically applies to the vertical delta movement vector `yd`, keeping interactions with other mods smooth.
> Multiplier Configuration: **Integer Percentage** — `100` equals standard 1.0x vanilla speed.

### 🏃 Sprint Climbing

Hold your sprint key while on a ladder to receive a massive speed boost.

![Feature Screenshot](https://raw.githubusercontent.com/Rifaditya/Instant-Gratification-ladder-speed/main/Images/SprintClimbing.png)

Feature Showcase: [Link to YouTube Video]

### ⬇️ Snap Descend

Look straight down (>45 degrees) while on a ladder to let gravity take over.

We have patched the vanilla climbing logic!
Vanilla heavily suppresses sliding down if you are on a ladder.
**We fixed this:** Looking straight down bypasses this suppression and forces a rapid 0.4 blocks/tick downward slide.

---

## ⚙️ Config

The mod works out of the box with zero setup.

* **Global Template**: `config/ladder-speed.json` (Sets defaults for new worlds - handled by DasikLibrary)
* **In-Game**: Use `/gamerule ladderspeed.` for core settings.
  * `climb_speed`: Base climbing speed multiplier (Default: 100)
  * `descend_speed`: Base descending speed multiplier (Default: 100)
  * `sprint_multiplier`: Extra boost multiplier when sprinting (Default: 150)
  * `snap_descend`: Toggle the look-down quick descent feature (Default: true)

```sql
/gamerule ladderspeed.climb_speed 200     → Double standard climb speed
/gamerule ladderspeed.sprint_multiplier 150 → 1.5x boost when sprinting
/gamerule ladderspeed.descend_speed 200   → Double slide down speed
/gamerule ladderspeed.snap_descend true   → Enable looking down to drop fast
```

![Config Screenshot](https://raw.githubusercontent.com/Rifaditya/Instant-Gratification-ladder-speed/main/Images/ConfigGUI.png)

> [!IMPORTANT]
> **Recommended Mod**: Since this mod generates 4 GameRules, it is highly recommended to use **[Collapsible Game Rules](https://modrinth.com/mod/collapsible-gamerules)** for a cleaner UI.

---

## 🧩 Suggested Mods

For the best experience, we recommend installing:
* **[Collapsible Game Rules](https://modrinth.com/mod/collapsible-gamerules)**: Prevents the GameRules menu from becoming cluttered.

---

## 📦 Install

1. Install **[Fabric API](https://modrinth.com/mod/fabric-api)** and **[Dasik Library](https://modrinth.com/mod/dasik-library)**.
2. Download `ladder-speed.jar` and place it in your `mods` folder.

---

## 🧩 Compatibility

| Feature | Fabric (26.1+) |
| :--- | :---: |
| Singleplayer | ✅ |
| Multiplayer (LAN/Server) | ✅ |

---

## ☕ Support

If you enjoy **Ladder Speed** and the **Instant Gratification** philosophy, consider fueling the next update with a coffee!

[![Ko-fi](https://img.shields.io/badge/Ko--fi-Support%20Me-FF5E5B?style=for-the-badge&logo=ko-fi&logoColor=white)](https://ko-fi.com/dasikigaijin/tip)
[![SocioBuzz](https://img.shields.io/badge/SocioBuzz-Local_Support-7BB32E?style=for-the-badge)](https://sociabuzz.com/dasikigaijin/tribe)

> [!NOTE]
> **Indonesian Users:** SocioBuzz supports local payment methods (Gopay, OVO, Dana, etc.) if you want to support me without using PayPal/Ko-fi!

---

## 📜 Credits

| Role | Author |
| :--- | :--- |
| **Creator** | DasikIgaijin |
| **Collection** | Instant Gratification |
| **License** | GNU GPLv3 |

---

> [!IMPORTANT]
> This mod is part of the **Instant Gratification** collection. You are free to use it in modpacks, videos, and servers.
>
> > [!IMPORTANT]
> > **Modpack Permissions:** You are free to include this mod in modpacks, **provided the modpack is hosted on the same platform** (e.g. Modrinth).
> >
> > **Cross-platform distribution is not permitted.** If you download this mod from Modrinth, your modpack must also be published on Modrinth.

---

<div align="center">

**Made with ❤️ for the Minecraft community**

*Part of the Instant Gratification Collection*

</div>
