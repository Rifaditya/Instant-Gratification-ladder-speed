🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 🏛️ 아키텍처 및 믹스인(Mixins) 분석 (MC 26.3)

> 📌 **저장소 소스 고지사항**: 본 위키 문서는 **저장소 내의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 이전의 최신 커밋 또는 개발 중인 기능이 포함될 수 있습니다.

This technical reference details the bytecode injection hooks, package structure, and separation of concerns in **Instant Gratification: Ladder Speed** on Minecraft 26.3.

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

## 3. 믹스인 주입 대상 매트릭스

| Mixin Class | Target Class | Injected Method | Injection Point | Purpose |
| :--- | :--- | :--- | :--- | :--- |
| `LivingEntityMixin` | `net.minecraft.world.entity.LivingEntity` | `handleOnClimbable(Vec3)` | `@At("RETURN")` | Intercepts downward descent and snap slide calculation. |
| `LivingEntityMixin` | `net.minecraft.world.entity.LivingEntity` | `handleRelativeFrictionAndCalculateMovement` | `@At("RETURN")` | Intercepts upward climb velocity ($0.2\text{ b/t}$) and applies sprint boost. |

---

## 4. 바이트코드 주입 구현체

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
* [[MC 26.3 개요로 이동|ko_kr-26.3-Home]]
* [[26.3 사다리 운동역학 및 전력 질주 등반|ko_kr-26.3-Ladder-Kinematics-and-Sprint-Climbing]]
* [[26.3 고속 하강 및 슬라이드 조작|ko_kr-26.3-Snap-Descend-and-Slide-Controls]]
* [[26.3 구성 및 동적 게임 규칙|ko_kr-26.3-Configuration-and-GameRules]]
* [[위키 홈으로 이동|ko_kr-Home]]
