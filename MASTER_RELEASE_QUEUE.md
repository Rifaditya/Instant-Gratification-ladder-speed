# 🎛️ Master Release Queue: Instant Gratification — Ladder Speed

> **Mod Project Master Ground-Truth Document**  
> *Last Synchronized: 2026-09-01*  
> **Modrinth ID**: *Unregistered* | **CurseForge ID**: *Unregistered* | **Lead SemVer**: `1.0.0`

---

## 📊 Multi-Version Release Matrix & Queue Status

| Target MC | Generational Era | Live on Platforms | Next Queued Version | Status & Cadence Action | Feature Highlights / Notes |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **MC 26.1** | Modern Standard | *(Unreleased)* | `1.0.0+26.1` | 🟢 **Ready to Publish** | Clean SemVer rebuild without `+build`. |
| **MC 26.3** | Modern Lead | `None` | `1.0.0+26.3` | ⏸️ **PARITY HOLD** | 1. **Why**: Held in archive until MC 26.1 reaches 1.0.0 feature parity.<br>2. **Until When**: Lifted once 1.0.0 is synchronized across active platforms.<br>3. **Resume Action**: Flip to `- [ ]` for daily automated release hub dispatch. |

---

## 🏛️ Project Operating Rules & Architectural Invariants

1. **🔢 Universal Direct SemVer Inheritance**:
   - Modern subprojects share unified SemVer milestone lineage targeting `1.0.0`.
   - Each Minecraft version anchor manages its own organic progression to ensure 100% clean, verified parity.

2. **📅 Daily Update Guard**:
   - Strict maximum of 1 release per day per targeted Minecraft version anchor across Modrinth and CurseForge.

---

## 🛠️ CLI Publisher Commands for Ladder Speed

```powershell
# 1. Check current status across all targeted Minecraft versions
python ".agents/skills/platform-publisher/scripts/platform_publisher.py" --mod "Ladder Speed" --status

# 2. Publish next sequential batch across all active versions
python ".agents/skills/platform-publisher/scripts/platform_publisher.py" --mod "Ladder Speed" --publish-next --yes

```
