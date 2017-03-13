package platformergame;

import java.awt.Rectangle;

public class Movement {

	private PlatformMain pm;
	private ObjectMovement om;
	private Collision col;

	public Movement(PlatformMain platform) {

		pm = platform;
		om = new ObjectMovement(pm);
		col = new Collision(pm);
	}

	public void movement() {

		// start menu
		if (pm.enter == false && pm.enterCount == 0) {

		}

		else {

			pm.ticks++;
			if (pm.canClick == false && pm.ticks - pm.clickTicks > 20) {
				pm.canClick = true;
			}
			if (pm.ticks % 5 == 0) {
				pm.animTick += 1;
			}
			if (pm.ticks % 40 == 0) {
				pm.bgTick += 1;
			}

			// Level clear
			if (pm.player.y + pm.player.height < 0 || pm.player.x + pm.player.width > pm.WIDTH || pm.levelCount == 0) {

				pm.levelCount += 1;
				pm.clearTicks = pm.ticks;
				pm.obstacle.clear();
				pm.spikes.clear();
				pm.redField.clear();
				pm.block.x = -100;

				// Levels
				if (pm.levelCount == 1) {

					pm.obstacle.add(new Rectangle(200, 460, 200, 350));
					pm.obstacle.add(new Rectangle(pm.WIDTH / 2, 260, 200, 550));
					pm.obstacle.add(new Rectangle(pm.WIDTH / 2 + 150, 610, 300, 200));
					pm.obstacle.add(new Rectangle(pm.WIDTH - 70, 610, 100, 200));
					pm.obstacle.add(new Rectangle(pm.WIDTH - 70, -15, 100, 415));

					pm.spikes.add(new Rectangle(1012, 585, 230, 10));
					pm.spikes.add(new Rectangle(1262, 785, 251, 10));
					pm.spikes.add(new Rectangle(412, 785, 380, 10));
				} else if (pm.levelCount == 2) {

					pm.obstacle.add(new Rectangle(-15, 460, 65, 350));
					pm.obstacle.add(new Rectangle(250, 200, 100, 610));
					pm.obstacle.add(new Rectangle(-40, 70, 380, 20));
					pm.obstacle.add(new Rectangle(300, 460, 250, 350));
					pm.obstacle.add(new Rectangle(800, 460, 50, 350));
					pm.obstacle.add(new Rectangle(800, -15, 50, 300));
					pm.obstacle.add(new Rectangle(900, 550, 100, 100));
					pm.obstacle.add(new Rectangle(1550, -15, 70, 415));
					pm.obstacle.add(new Rectangle(1550, 600, 70, 210));

					pm.spikes.add(new Rectangle(12, 100, 328, 11));
					pm.spikes.add(new Rectangle(562, 785, 220, 10));
					pm.spikes.add(new Rectangle(860, 785, 680, 10));
					pm.spikes.add(new Rectangle(820, 440, 9, 10));
					pm.spikes.add(new Rectangle(820, 295, 9, 11));
				} else if (pm.levelCount == 3) {

					pm.obstacle.add(new Rectangle(300, 460, 300, 350));
					pm.obstacle.add(new Rectangle(900, 350, 50, 460));
					pm.obstacle.add(new Rectangle(900, -20, 50, 210));
					pm.obstacle.add(new Rectangle(1100, 460, 50, 350));
					pm.obstacle.add(new Rectangle(1100, -20, 50, 300));
					pm.obstacle.add(new Rectangle(1450, 600, 200, 300));
					pm.obstacle.add(new Rectangle(1550, -20, 100, 350));

					pm.spikes.add(new Rectangle(620, 785, 255, 10));
					pm.spikes.add(new Rectangle(920, 330, 9, 10));
					pm.spikes.add(new Rectangle(920, 200, 9, 11));
					pm.spikes.add(new Rectangle(1120, 440, 9, 10));
					pm.spikes.add(new Rectangle(1120, 290, 9, 11));
					pm.spikes.add(new Rectangle(960, 785, 130, 10));
					pm.spikes.add(new Rectangle(1160, 785, 280, 10));
				} else if (pm.levelCount == 4) {

					pm.obstacle.add(new Rectangle(-20, 400, 1000, 50));
					pm.obstacle.add(new Rectangle(200, 750, 50, 100));
					pm.obstacle.add(new Rectangle(1400, 130, 300, 800));
					pm.obstacle.add(new Rectangle(200, 100, 1500, 50));

					pm.spikes.add(new Rectangle(260, 785, 1130, 10));
					pm.spikes.add(new Rectangle(300, 377, 350, 10));
					pm.spikes.add(new Rectangle(20, 463, 950, 11));
				} else if (pm.levelCount == 5) {

					pm.obstacle.add(new Rectangle(200, 700, 400, 150));
					pm.obstacle.add(new Rectangle(-20, 340, 1700, 50));
					pm.obstacle.add(new Rectangle(900, 550, 50, 350));

					pm.spikes.add(new Rectangle(40, 402, 1530, 11));
				} else if (pm.levelCount == 6) {

					pm.obstacle.add(new Rectangle(-20, -20, 250, 700));
					pm.obstacle.add(new Rectangle(300, 200, 200, 800));
					pm.obstacle.add(new Rectangle(231, 750, 70, 20));
					pm.obstacle.add(new Rectangle(1500, 300, 150, 700));
					pm.obstacle.add(new Rectangle(1500, -20, 150, 200));

					pm.spikes.add(new Rectangle(250, 600, 10, 8));
					pm.spikes.add(new Rectangle(270, 500, 11, 8));
					pm.spikes.add(new Rectangle(250, 400, 10, 8));
					pm.spikes.add(new Rectangle(270, 300, 11, 8));

					pm.spikes.add(new Rectangle(600, 15, 170, 11));
					pm.spikes.add(new Rectangle(800, 15, 170, 11));
					pm.spikes.add(new Rectangle(1000, 15, 170, 11));
					pm.spikes.add(new Rectangle(530, 785, 950, 10));
					pm.spikes.add(new Rectangle(240, 15, 100, 11));
				} else if (pm.levelCount == 7) {

					pm.obstacle.add(new Rectangle(231, 750, 1300, 20));
					pm.obstacle.add(new Rectangle(1500, 100, 150, 800));

					pm.spikes.add(new Rectangle(-20, 15, 1500, 11));
					pm.spikes.add(new Rectangle(900, 15, 200, 11));
					pm.spikes.add(new Rectangle(1900, 200, 11, 100));
				} else if (pm.levelCount == 8) {

					pm.blueScreen.x = 0;

					pm.obstacle.add(new Rectangle(200, 100, 200, 800));
					pm.obstacle.add(new Rectangle(500, -20, 100, 700));
					pm.obstacle.add(new Rectangle(1000, 100, 650, 1500));
					pm.obstacle.add(new Rectangle(550, 600, 350, 20));
					pm.obstacle.add(new Rectangle(850, 300, 200, 20));
					pm.obstacle.add(new Rectangle(550, 150, 350, 20));

					pm.spikes.add(new Rectangle(420, 200, 10, 9));
					pm.spikes.add(new Rectangle(470, 450, 11, 9));
					pm.spikes.add(new Rectangle(420, 700, 10, 9));

					pm.spikes.add(new Rectangle(620, 580, 250, 10));
					pm.spikes.add(new Rectangle(620, 180, 250, 11));
					pm.spikes.add(new Rectangle(870, 330, 110, 11));

				} else if (pm.levelCount == 9) {

					pm.blueScreen.x = 1600;
					pm.obstacle.add(new Rectangle(-100, -20, 30, 1200));
					pm.obstacle.add(new Rectangle(500, -20, 30, 1200));
					pm.obstacle.add(new Rectangle(-20, 500, 1200, 50));
					pm.obstacle.add(new Rectangle(400, 150, 1250, 50));
					pm.obstacle.add(new Rectangle(-20, -20, 1250, 50));

					pm.spikes.add(new Rectangle(-50, 20, 10, 770));
					pm.spikes.add(new Rectangle(470, 20, 11, 770));

				} else if (pm.levelCount == 10) {

					pm.roof.y = 0;
					pm.obstacle.add(new Rectangle(1450, 500, 200, 500));

					pm.redField.add(new Rectangle(300, 0, 350, 900));
					pm.redField.add(new Rectangle(1000, 0, 50, 1600));
					pm.redField.add(new Rectangle(1150, 0, 50, 1600));

					pm.spikes.add(new Rectangle(300, 785, 1150, 10));
				} else if (pm.levelCount == 11) {

					pm.blueScreen.x = 0;

					pm.obstacle.add(new Rectangle(1450, 500, 200, 500));
					pm.obstacle.add(new Rectangle(150, 750, 50, 100));

					pm.redField.add(new Rectangle(0, 0, 1600, 500));

					pm.spikes.add(new Rectangle(230, 785, 1200, 10));
					pm.spikes.add(new Rectangle(800, 500, 10, 300));
					pm.spikes.add(new Rectangle(750, 500, 11, 300));
				}
				pm.player.setLocation(100, pm.HEIGHT - 140);
			}
			
			if (pm.yMotion < 20 && pm.player.y + pm.player.height < pm.floor.y) {

				pm.yMotion += 1;
			}
			
			if (pm.isStoppingLeft == true) {

				stopLeft();
			}
			if (pm.isStoppingRight == true) {

				stopRight();
			}

			// Object movement
			om.movement();

			// player input movement
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
