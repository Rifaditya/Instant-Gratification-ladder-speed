🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🏛️ Architecture & Analyse des Mixins (MC 26.1)

> 📌 **Avertissement relatif à la source du dépôt** : Cette documentation wiki reflète **l'état actuel du code source dans le dépôt**, qui peut inclure les derniers commits non publiés ou des fonctionnalités en cours de développement avant les versions publiques sur CurseForge et Modrinth.

This technical reference details the bytecode injection hooks, package structure, and separation of concerns in **Instant Gratification: Ladder Speed** on Minecraft 26.1.

---

## 1. Subsystem Architecture Overview

Ladder Speed is built following the **Clean "1 File, 1 Purpose" Principle**:
- **Entrypoint**: `LadderSpeedFabric` initializes the mod and triggers rule registration.
- **Rule Definitions**: `LadderSpeedRules` registers namespaced GameRules into `DynamicGameRuleManager`.
- **Pure Stateless Logic**: `ClimbingLogic` isolates velocity calculation math from Minecraft entity lifecycle methods.
- **Bytecode Hook**: `LivingEntityMixin` intercepts entity movement ticks and delegates directly to `ClimbingLogic`.

---

## 2. Package & Class Hierarchy

```
net.instantgratification.ladderspeed
├── LadderSpeedFabric.java              # ModInitializer entrypoint
├── logic/
│   └── ClimbingLogic.java              # Pure static math & velocity calculations
├── mixin/
│   └── LivingEntityMixin.java          # SpongePowered Mixin into LivingEntity
└── reg/
    └── LadderSpeedRules.java           # DynamicGameRule definitions
```

---

## 3. Matrice d'Injection des Mixins

| Mixin Class | Target Class | Injected Method | Injection Point | Purpose |
| :--- | :--- | :--- | :--- | :--- |
| `LivingEntityMixin` | `net.minecraft.world.entity.LivingEntity` | `handleOnClimbable(Vec3)` | `@At("RETURN")` | Intercepts downward descent and snap slide calculation. |
| `LivingEntityMixin` | `net.minecraft.world.entity.LivingEntity` | `handleRelativeFrictionAndCalculateMovement` | `@At("RETURN")` | Intercepts upward climb velocity ($0.2\text{ b/t}$) and applies sprint boost. |

---

## 4. Implémentation d'Injection Bytecode

### Hook 1: Upward Movement Interception
```java
@Inject(method = "handleRelativeFrictionAndCalculateMovement", at = @At("RETURN"), cancellable = true)
private void ladderspeed$modifyRelativeFriction(Vec3 input, float friction, CallbackInfoReturnable<Vec3> cir) {
    Vec3 result = cir.getReturnValue();
    LivingEntity entity = (LivingEntity) (Object) this;
    
    if (entity.onClimbable() && Math.abs(result.y - 0.2) < 1.0E-5) {
        float multiplier = ClimbingLogic.getUpwardBoostMultiplier(entity);
        if (multiplier != 1.0f) {
            cir.setReturnValue(new Vec3(result.x, 0.2 * multiplier, result.z));
        }
    }
}
```

### Hook 2: Downward Descent & Snap Slide Interception
```java
@Inject(method = "handleOnClimbable", at = @At("RETURN"), cancellable = true)
private void ladderspeed$onHandleClimbable(Vec3 motion, CallbackInfoReturnable<Vec3> cir) {
    Vec3 result = cir.getReturnValue();
    LivingEntity entity = (LivingEntity) (Object) this;
    
    if (entity.onClimbable() && result.y < 0.0) {
        cir.setReturnValue(ClimbingLogic.handleDescentMovement(entity, result));
    }
}
```

---

## 🔗 Related Documentation
* [[Retour au Portail MC 26.1|fr_fr-26.1-Home]]
* [[26.1 Cinématique d'Échelle & Escalade en Sprint|fr_fr-26.1-Ladder-Kinematics-and-Sprint-Climbing]]
* [[26.1 Descente Rapide & Contrôle de Glisse|fr_fr-26.1-Snap-Descend-and-Slide-Controls]]
* [[26.1 Configuration & GameRules Dynamiques|fr_fr-26.1-Configuration-and-GameRules]]
* [[Retour à l'Accueil|fr_fr-Home]]
