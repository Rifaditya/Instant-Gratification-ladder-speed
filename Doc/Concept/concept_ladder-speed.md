# Concept: Faster Ladder Climbing

## Philosophy Fit

**Collection**: Instant Gratification
**Reasoning**: Players should not be slowed down by vertical terrain. Faster climbing respects the player's time during traversal.

## Core Mechanics

### 1. Speed Multiplier
- A configurable GameRule (`flc_speed_multiplier`) that scales the base climbing speed.
- Range: 0-500 (100 is Vanilla).

### 2. Look-to-Climb Acceleration
- Looking UP (Pitch < -15) and holding Forward (W) provides the speed boost.
- Looking DOWN (Pitch > 15) provides the speed boost in the downward direction.
- Center looking remains at Vanilla speed to allow for precision.

## Configuration

- `flc_speed_multiplier`: Integer Rule (Default: 150).

## To Do

- [x] **Project Initialization** (Build 1)
- [ ] **Feature Implementation**:
  - [x] Reference-style movement logic.
  - [ ] Gradual speed scaling based on pitch angle (from initial request).
- [ ] **Documentation**:
  - [ ] Architecture documentation.
  - [ ] User guide.
