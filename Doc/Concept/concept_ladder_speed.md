# Concept: Ladder Speed

> **Philosophy**: Instant Gratification (IG) - "Fluid Verticality."

## Core Mechanics
1. **Configurable Climb Speed**: Increase the vertical velocity when moving up a ladder.
2. **Snap Descend**: Allow faster descent (sliding) when looking down or holding a key.
3. **Gamerule Control**: `ladderClimbSpeed` (Float multiplier).

## Features
- **Smooth Scaling**: Maintain vanilla feel while removing the tedious crawl.
- **Sprint Climb**: Holding the sprint key while on a ladder provides an extra boost.

## Technical Hooks (Snapshot 26.x)
- `LivingEntity.travel()`: Where movement on ladders/vines is calculated.
- `Entity.onClimbable()`: To detect the state.
