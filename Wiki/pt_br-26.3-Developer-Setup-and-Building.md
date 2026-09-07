🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🛠️ Configuração de Desenvolvedor e Compilação (MC 26.3)

> 📌 **Aviso Legal da Fonte do Repositório**: Esta documentação wiki reflete o **estado atual do código-fonte no repositório**, podendo incluir os commits mais recentes não lançados ou recursos em desenvolvimento antes dos lançamentos públicos no CurseForge e Modrinth.

This document provides exact toolchain requirements and build commands for compiling the **Minecraft 26.3** target of Ladder Speed.

---

## 💻 Pré-requisitos do Ambiente

| Tool | Specification |
| :--- | :--- |
| **Target Minecraft** | `26.3` |
| **Java JDK** | JDK 25 |
| **Gradle** | 9.3+ |
| **Fabric Loader** | `>=0.19.3` |
| **DasikLibrary** | `>=1.8.36` |

---

## 🔨 Compilação a partir do Código-Fonte

```bash
./gradlew build --no-daemon
```

### Target Output
The build produces the finalized production JAR:
`build/libs/ladder-speed-1.0.0+build.1+26.3.jar`

---

## 🧪 Testes & Execução

Launch an isolated Fabric development client:
```bash
./gradlew runClient
```

---

## 📜 Autoria & Licença

- **Author & Creator**: Dasik (Rifaditya)
- **License**: GNU General Public License v3.0 (GPLv3)
- **Project Collection**: Instant Gratification Collection
- **Repository**: [GitHub Source](https://github.com/Rifaditya/Instant-Gratification-ladder-speed)

> 📌 **Aviso Legal da Fonte do Repositório**: Esta documentação wiki reflete o **estado atual do código-fonte no repositório**, podendo incluir os commits mais recentes não lançados ou recursos em desenvolvimento antes dos lançamentos públicos no CurseForge e Modrinth.
