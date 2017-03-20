package platformergame;

public class Movement {

	private PlatformMain pm;
	private ObjectMovement om;
	private Collision col;
	private LevelReader lv;

	public Movement(PlatformMain platform) {

		pm = platform;
		om = new ObjectMovement(pm);
		col = new Collision(pm);
		lv = new LevelReader(pm);
	}

	public void movement() {

		// start menu
		if (pm.enter == false && pm.enterCount == 0) {

		}

		else {

			pm.ticks++;
			if (!pm.canClick && pm.ticks - pm.clickTicks > 20) {
				pm.canClick = true;
			}
			if (pm.ticks % 5 == 0) {
				pm.animTick += 1;
			}
			if (pm.ticks % 40 == 0) {
				pm.bgTick += 1;
			}

			// Level clear
			if (pm.player.x + pm.player.width > pm.WIDTH || pm.levelCount == 0) {

				pm.levelCount++;
				pm.clearTicks = pm.ticks;
				pm.obstacle.clear();
				pm.spikes.clear();
				pm.redField.clear();
				pm.block.x = -100;

				// Load level
				lv.getLevel(pm.levelCount);

				// Reset the players location
				pm.player.setLocation(100, pm.HEIGHT - 140);
			}

			if (pm.yMotion < 20 && pm.player.y + pm.player.height < pm.floor.y) {

				pm.yMotion += 1;
			}

			if (pm.isStoppingLeft) {

				stopLeft();
			}
			if (pm.isStoppingRight) {

				stopRight();
			}

			// Object movement
			om.movement();

			// player Movement
			pm.player.x += pm.xMotion;
			pm.player.y += pm.yMotion;

			// Collision
			col.collision();

			if (pm.press == true && pm.cur == 'A') {
				left();
			} else if (pm.press == true && pm.cur == 'D') {
				right();
			}

			// block movement
			pm.block.y += 2;
		}
		pm.renderer.repaint();
	}

	public void jump() {

		if (pm.canJump == true && pm.yMotion == 0) {
			pm.yMotion -= 20;
			pm.canJump = false;
		}
	}

	public void left() {

		pm.xMotion = -7;
	}

	public void right() {

		pm.xMotion = 7;
	}

	public void stopLeft() {

		if (pm.stoppingTicks < 20 && pm.xMotion < 0) {
			if (pm.ticks % 2 == 0) {
				pm.xMotion += 1;
			}
			pm.stoppingTicks++;
		} else if (pm.xMotion >= 0) {
			pm.isStoppingLeft = false;
		}
	}

	public void stopRight() {

		if (pm.stoppingTicks < 20 && pm.xMotion > 0) {
			if (pm.ticks % 2 == 0) {
				pm.xMotion -= 1;
			}
			pm.stoppingTicks++;
		} else if (pm.xMotion <= 0) {
			pm.isStoppingRight = false;
		}
	}
}
