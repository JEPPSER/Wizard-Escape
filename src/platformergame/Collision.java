package platformergame;

public class Collision {

	private PlatformMain pm;

	public Collision(PlatformMain platform) {

		pm = platform;
	}

	public void collision() {

		// Spikes
		for (int i = 0; i < pm.spikes.size(); i++) {
			if (pm.player.intersects(pm.spikes.get(i))) {

				pm.player.setLocation(100, pm.HEIGHT - 140);
				pm.deathCount += 1;
			}
		}
		
		// Obstacles
		for (int i = 0; i < pm.obstacle.size(); i++) {

			if (pm.player.y + pm.player.height >= pm.floor.y) {
				pm.player.y = pm.floor.y - 1 - pm.player.height;
				pm.yMotion = 0;
				pm.canJump = true;
			}
			if (pm.player.x < pm.wall.x + pm.wall.width) {
				pm.player.x = pm.wall.x + pm.wall.width + 1;
			}
			if (pm.player.y < pm.roof.y + pm.roof.height) {
				pm.player.y = pm.roof.y + pm.roof.height + 1;
				pm.yMotion = 0;
			}

			// block
			if (pm.player.y + pm.player.height < pm.block.y + 20 && pm.player.y + pm.player.height >= pm.block.y
					&& pm.player.x + pm.player.width > pm.block.x && pm.player.x < pm.block.x + pm.block.width
					&& pm.yMotion > 0) {

				pm.player.y = pm.block.y - pm.player.height + 1;
				pm.yMotion = 0;
				pm.canJump = true;
			}
			// top
			if (pm.player.y + pm.player.height < pm.obstacle.get(i).y + 20
					&& pm.player.y + pm.player.height >= pm.obstacle.get(i).y
					&& pm.player.x + pm.player.width > pm.obstacle.get(i).x
					&& pm.player.x < pm.obstacle.get(i).x + pm.obstacle.get(i).width) {

				if (pm.yMotion > 0 || pm.player.y + pm.player.height < pm.block.y + 20
						&& pm.player.y + pm.player.height >= pm.block.y && pm.player.x + pm.player.width > pm.block.x
						&& pm.player.x < pm.block.x + pm.block.width) {

					pm.player.y = pm.obstacle.get(i).y - pm.player.height - 1;
					pm.yMotion = 0;
					pm.canJump = true;
				}
			}
			// bottom
			if (pm.player.y < pm.obstacle.get(i).y + pm.obstacle.get(i).height
					&& pm.player.y > pm.obstacle.get(i).y + pm.obstacle.get(i).height - 20
					&& pm.player.x < pm.obstacle.get(i).x + pm.obstacle.get(i).width
					&& pm.player.x + pm.player.width > pm.obstacle.get(i).x) {

				pm.player.y = pm.obstacle.get(i).y + pm.obstacle.get(i).height;
				if (pm.yMotion < 0) {
					pm.yMotion = 0;
				}
			}
			// sides
			else if (pm.player.x < pm.obstacle.get(i).x + pm.obstacle.get(i).width
					&& pm.player.x + pm.player.width > pm.obstacle.get(i).x) {

				if (pm.player.y < pm.obstacle.get(i).y + pm.obstacle.get(i).height
						&& pm.player.y + pm.player.height > pm.obstacle.get(i).y + 10) {

					if (pm.xMotion > 0) {
						pm.player.x = pm.obstacle.get(i).x - 1 - pm.player.width;
						pm.xMotion = 0;
						pm.press = true;
					} else if (pm.xMotion < 0) {
						pm.player.x = pm.obstacle.get(i).x + pm.obstacle.get(i).width + 1;
						pm.xMotion = 0;
						pm.press = true;
					}
				}
			}
		}
		// redField
		for (int i = 0; i < pm.redField.size(); i++) {

			if (pm.block.intersects(pm.redField.get(i))) {

				if (pm.block.x + 25 < pm.redField.get(i).x) {

					pm.block.x = pm.redField.get(i).x - 51;
				} else if (pm.block.x + 25 > pm.redField.get(i).x + pm.redField.get(i).width) {

					pm.block.x = pm.redField.get(i).x + pm.redField.get(i).width + 1;
				} else
					pm.block.x = 1600;
			}
		}

	}
}
