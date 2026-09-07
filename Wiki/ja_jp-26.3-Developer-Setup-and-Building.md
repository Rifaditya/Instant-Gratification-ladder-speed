🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🛠️ 開発環境セットアップ & ビルド (MC 26.3)

> 📌 **リポジトリソースに関する免責事項**: このWikiドキュメントは**リポジトリ内の現在のソースコード状態**を反映しており、CurseForgeおよびModrinthでの公開リリース前の最新の未リリースコミットや開発中の機能が含まれている場合があります。

This document provides exact toolchain requirements and build commands for compiling the **Minecraft 26.3** target of Ladder Speed.

---

## 💻 開発環境の前提条件

| Tool | Specification |
| :--- | :--- |
| **Target Minecraft** | `26.3` |
| **Java JDK** | JDK 25 |
| **Gradle** | 9.3+ |
| **Fabric Loader** | `>=0.19.3` |
| **DasikLibrary** | `>=1.8.36` |

---

## 🔨 ソースコードからのビルド

```bash
./gradlew build --no-daemon
```

### Target Output
The build produces the finalized production JAR:
`build/libs/ladder-speed-1.0.0+build.1+26.3.jar`

---

## 🧪 テストと実行

Launch an isolated Fabric development client:
```bash
./gradlew runClient
```

---

## 📜 作成者とライセンス

- **Author & Creator**: Dasik (Rifaditya)
- **License**: GNU General Public License v3.0 (GPLv3)
- **Project Collection**: Instant Gratification Collection
- **Repository**: [GitHub Source](https://github.com/Rifaditya/Instant-Gratification-ladder-speed)

> 📌 **リポジトリソースに関する免責事項**: このWikiドキュメントは**リポジトリ内の現在のソースコード状態**を反映しており、CurseForgeおよびModrinthでの公開リリース前の最新の未リリースコミットや開発中の機能が含まれている場合があります。
