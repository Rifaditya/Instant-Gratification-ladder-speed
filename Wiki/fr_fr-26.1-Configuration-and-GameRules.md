🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# ⚙️ Configuration & Règles de Jeu Dynamiques (MC 26.1)

> 📌 **Avertissement relatif à la source du dépôt** : Cette documentation wiki reflète **l'état actuel du code source dans le dépôt**, qui peut inclure les derniers commits non publiés ou des fonctionnalités en cours de développement avant les versions publiques sur CurseForge et Modrinth.

This document provides a comprehensive technical reference for the 4 dynamic GameRules registered by **Instant Gratification: Ladder Speed** on Minecraft 26.1.

---

## 1. GameRule Registry Architecture

All GameRules in Ladder Speed are registered dynamically via **DasikLibrary**'s `DynamicGameRuleManager` under the dedicated category `ladderspeed:category`.

- **Category Identifier**: `ladderspeed:category`
- **Category Display Title**: `Ladder Speed Rules` (`gamerule.category.ladderspeed`)
- **Server Authority**: Dynamic GameRules sync from server to client automatically upon connection.

---

## 2. Exhaustive GameRule Reference Matrix

| GameRule Name | Data Type | Default | Bounds | Translation Key | Description |
| :--- | :--- | :--- | :--- | :--- | :--- |
| `ladderspeed.climb_speed` | Integer | `100` | `10` – `1000` | `gamerule.ladderspeed.climb_speed` | Percentage multiplier for vertical climb speed on ladders ($100 = 1.0\times$). |
| `ladderspeed.sprint_multiplier` | Integer | `150` | `10` – `1000` | `gamerule.ladderspeed.sprint_multiplier` | Percentage multiplier for climb speed while sprinting ($150 = 1.5\times$). |
| `ladderspeed.descend_speed` | Integer | `100` | `10` – `1000` | `gamerule.ladderspeed.descend_speed` | Percentage multiplier for controlled ladder sliding ($100 = 1.0\times$). |
| `ladderspeed.snap_descend` | Boolean | `true` | `true`/`false`| `gamerule.ladderspeed.snap_descend` | When enabled, looking down past $45^\circ$ triggers fast downward slide. |

---

## 3. Commandes en Jeu & Syntaxe

```sql
# Query current values
/gamerule ladderspeed.climb_speed
/gamerule ladderspeed.sprint_multiplier
/gamerule ladderspeed.descend_speed
/gamerule ladderspeed.snap_descend

# Double climbing speed (2.0x standard)
/gamerule ladderspeed.climb_speed 200

# Set sprint boost to 2.0x (total 4.0x when sprinting with 200 climb speed)
/gamerule ladderspeed.sprint_multiplier 200

# Disable snap descend (slide only at standard descend speed)
/gamerule ladderspeed.snap_descend false

# Reset to defaults
/gamerule ladderspeed.climb_speed 100
/gamerule ladderspeed.sprint_multiplier 150
/gamerule ladderspeed.descend_speed 100
/gamerule ladderspeed.snap_descend true
```

---

## 🔗 Related Documentation
* [[Retour au Portail MC 26.1|fr_fr-26.1-Home]]
* [[26.1 Cinématique d'Échelle & Escalade en Sprint|fr_fr-26.1-Ladder-Kinematics-and-Sprint-Climbing]]
* [[26.1 Descente Rapide & Contrôle de Glisse|fr_fr-26.1-Snap-Descend-and-Slide-Controls]]
* [[26.1 Architecture & Analyse des Mixins|fr_fr-26.1-Architecture-and-Mixins]]
* [[Retour à l'Accueil|fr_fr-Home]]
