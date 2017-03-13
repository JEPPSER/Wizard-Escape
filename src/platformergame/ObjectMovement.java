package platformergame;

public class ObjectMovement {

	private PlatformMain pm;

	public ObjectMovement(PlatformMain platform) {

		pm = platform;
	}

	public void movement() {

		// level 5
		if (pm.levelCount == 5) {

			if (pm.spikes.get(0).y < 700 && pm.spikesDown == true) {
				pm.spikes.get(0).y += 3;
			} else {

				pm.spikes.get(0).y -= 3;
				pm.spikesDown = false;
				if (pm.spikes.get(0).y < 402) {

					pm.spikesDown = true;
				}
			}
		}

		// level 6
		if (pm.levelCount == 6) {

			if (pm.player.x >= pm.obstacle.get(2).x) {

				pm.obstacle.get(2).y += -5;
			}
			if (pm.obstacle.get(2).y < 0) {

				pm.obstacle.get(2).y = -20;
			}
			if (pm.player.x <= 100) {

				pm.obstacle.get(2).y = 750;
			}
			for (int i = 4; i < 7; i++) {

				if (pm.player.x + pm.player.width > pm.spikes.get(i).x || pm.spikes.get(i).y > 15) {

					pm.spikes.get(i).y += 15;
				}
				if (pm.player.x <= 100) {

					pm.spikes.get(i).y = 15;
				}
			}
		}

		// level 7
		if (pm.levelCount == 7) {

			if (pm.player.x >= pm.obstacle.get(0).x) {

				pm.obstacle.get(0).y += -3;
			}
			if (pm.obstacle.get(0).y < 0) {

				pm.obstacle.get(0).y = -20;
			}
			if (pm.player.x <= 100) {

				pm.obstacle.get(0).y = 750;
			}
			if (pm.player.x + pm.player.width > pm.spikes.get(1).x || pm.spikes.get(1).y > 15) {

				pm.spikes.get(1).y += 15;
				pm.spikes.get(2).x -= 15;
			}
			if (pm.player.x <= 100) {

				pm.spikes.get(1).y = 15;
				pm.spikes.get(2).x = 2000;
			}
		}

		// level 9
		if (pm.levelCount == 9) {

			pm.roof.y = -300;

			if (pm.obstacle.get(0).x <= 900 && pm.obstacle.get(0).y % 2 == 0) {

				pm.obstacle.get(0).x += 6;
				pm.obstacle.get(1).x += 6;

				if (pm.obstacle.get(0).x > 900) {

					pm.obstacle.get(0).y = -19;
				}
			} else {

				pm.obstacle.get(0).x += -6;
				pm.obstacle.get(1).x += -6;

				if (pm.obstacle.get(0).x < 100) {

					pm.obstacle.get(0).y = -20;
				}
			}
			pm.spikes.get(0).x = pm.obstacle.get(0).x + 50;
			pm.spikes.get(1).x = pm.obstacle.get(1).x - 30;

			if (pm.player.x <= 100) {

				pm.obstacle.get(0).x = -100;
				pm.obstacle.get(1).x = 500;
				pm.obstacle.get(0).y = -20;
			}
		}

		// level 11
		if (pm.levelCount == 11) {

			if (pm.spikes.get(1).x <= 1200 && pm.spikes.get(1).y % 2 == 0) {

				pm.spikes.get(1).x += 6;
				pm.spikes.get(2).x = pm.spikes.get(1).x - 50;

				if (pm.spikes.get(1).x > 1200) {

					pm.spikes.get(1).y = 499;
				}
			} else {

				pm.spikes.get(1).x += -6;
				pm.spikes.get(2).x = pm.spikes.get(1).x - 50;

				if (pm.spikes.get(1).x < 300) {

					pm.spikes.get(1).y = 500;
				}
			}
		}
	}
}