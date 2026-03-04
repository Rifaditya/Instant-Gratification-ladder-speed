<div align="center">
  <img src="https://raw.githubusercontent.com/Rifaditya/Instant-Gratification-ladder-speed/main/src/main/resources/assets/ladderspeed/icon.png" alt="Ladder Speed Icon" width="128"/>
  <h1>Ladder Speed</h1>
  <p><b>A Minecraft mod that lets you configure how fast you climb ladders, speeds up climbing when sprinting, and lets you slide down instantly by looking down.</b></p>

  <p>
    <img src="https://img.shields.io/badge/Minecraft-26.1+-brightgreen.svg" alt="Minecraft Version">
    <img src="https://img.shields.io/badge/Loader-Fabric-blue.svg" alt="Mod Loader">
    <img src="https://img.shields.io/badge/Requirement-Dasik_Library-orange.svg" alt="Library Required">
  </p>
</div>

---

### 🧱 What is Vanilla?
Vanilla ladders are slow and agonizing. You crawl up them at a fixed, unchangeable pace, regardless of whether you are walking or sprinting. Going down isn't much better, often resulting in tedious shaft descents.

### 🚀 What is Ladder Speed?
An **Instant Gratification** module that completely unlocks vertical movement. Climb at your own pace, get a boost when sprinting, and snap downwards instantly by looking down. Fully configurable via GameRules so you can dial in the perfect friction.

---

### ✨ Features (Zero Hallucination Guaranteed)

*   🏃 **Sprint Climbing**: Hold your sprint key while on a ladder to receive a configurable speed boost (Default: 1.5x speed).
*   ⚙️ **Configurable Base Speed**: Adjust the default climbing & descending speeds independently to match your modpack's pacing.
*   ⬇️ **Snap Descend**: enabled by default. Look straight down (>45 degrees) while on a ladder to let gravity take over, sliding down significantly faster than sneaking.

*(Note: Requires the **Dasik Library** for the dynamic configuration menu).*

---

### 🛠️ Configuration (Dasik Library UI)

All options are accessible in the Game Menu via Dasik Library's advanced GameRule system:
> [!NOTE] 
> Because Minecraft natively lacks float entry fields, multipliers are represented as integer percentages. `100` = 1.0x vanilla speed.

*   `ladderspeed.climbSpeed` (Int) - Base climbing speed multiplier (Default: 100).
*   `ladderspeed.sprintMultiplier` (Int) - Extra boost multiplier when sprinting (Default: 150).
*   `ladderspeed.descendSpeed` (Int) - Base descending speed multiplier (Default: 100).
*   `ladderspeed.snapDescend` (Bool) - Toggle the look-down quick descent feature (Default: true).

---

### 🧩 Compatibility Matrix

| Environment | Status | Notes |
| :--- | :---: | :--- |
| **Singleplayer** | ✅ | Works perfectly out of the box. |
| **Multiplayer** | ✅ | Server-side authoritative. GameRules sync perfectly to clients via DasikLibrary. |
| **Vanilla Clients** | ❌ | Requires mod installation on both server and client (adjusts client-side prediction logic). |

---

### ❤️ Support the Zenith Architecture
If this mod removes a tiny bit of friction from your day, consider supporting my caffeine dependency so I can build more of them.

<div align="center">
  <a href="https://ko-fi.com/dasikigaijin"><img src="https://storage.ko-fi.com/cdn/kofi2.png?v=3" height="36" alt="Buy Me a Coffee at ko-fi.com" /></a>
  <a href="https://sociobuzz.com/rifaditya/"><img src="https://storage.ko-fi.com/cdn/brandasset/sociobuzz.png" height="36" alt="Support via SocioBuzz (ID/E-Wallets)" /></a>
</div>

---
> **Modpack Permissions**: You are completely free to use this in any modpack. However, absolute prohibition on re-uploading the `.jar` to alternative sites. *Links must point back to Modrinth/CurseForge.*
---
<p align="center"><i>Made with ❤️ by Rifaditya (Dasik) and the Zenith Framework.</i></p>
