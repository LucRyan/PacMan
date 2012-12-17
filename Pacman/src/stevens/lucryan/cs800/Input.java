package stevens.lucryan.cs800;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.InputProcessor;

public class Input implements InputProcessor {
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;

	public static final int ESCAPE = 4;

	boolean[] buttons = new boolean[10];

	public void moveUp() {
		TestGDX.camera.position.set(new Vector3(TestGDX.camera.position.x + TestGDX.camera.direction.nor().x,
				TestGDX.camera.position.y + TestGDX.camera.direction.nor().y, TestGDX.camera.position.z + TestGDX.camera.direction.nor().z));
		TestGDX.camera.update();
	}

	public void moveDown() {
		TestGDX.camera.position.set(new Vector3(TestGDX.camera.position.x - TestGDX.camera.direction.nor().x,
				TestGDX.camera.position.y - TestGDX.camera.direction.nor().y, TestGDX.camera.position.z - TestGDX.camera.direction.nor().z));
		TestGDX.camera.update();
	}

	public void turnLeft() {
		Vector3 currentPosition = new Vector3(TestGDX.camera.position.x,
				TestGDX.camera.position.y, TestGDX.camera.position.z);
		
		TestGDX.camera.translate(-currentPosition.x, -currentPosition.y, -currentPosition.z);
		TestGDX.camera.rotate(new Vector3(0.0f, 1.0f, 0.0f), 1.0f);
		//TestGDX.camera.rotate(new Vector3(1.0f, 0.0f, 0.0f), 1.0f);
		TestGDX.camera.translate(currentPosition.x, currentPosition.y, currentPosition.z);

		TestGDX.camera.update();
	}


	public void turnRight() {
		Vector3 currentPosition = new Vector3(TestGDX.camera.position.x,
				TestGDX.camera.position.y, TestGDX.camera.position.z);
		TestGDX.camera.translate(-currentPosition.x, -currentPosition.y, -currentPosition.z);
		TestGDX.camera.rotate(new Vector3(0.0f, 1.0f, 0.0f), -1.0f);
		//TestGDX.camera.rotate(new Vector3(1.0f, 0.0f, 0.0f), -1.0f);
		TestGDX.camera.translate(currentPosition.x, currentPosition.y, currentPosition.z);
		
		TestGDX.camera.update();

	}

	public void tick() {
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i] == true) {
				switch (i) {
				case UP:
					moveUp();
					break;
				case DOWN:
					moveDown();
					break;
				case LEFT:
					turnLeft();
					break;
				case RIGHT:
					turnRight();
					break;
				}
			}
		}

	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {

		// keys for moving the model up and down
		case Keys.W:
			buttons[UP] = true;
			return true;
		case Keys.S:
			buttons[DOWN] = true;
			return true;
			// keys for moving the model left and right
		case Keys.A:
			buttons[LEFT] = true;
			return true;
		case Keys.D:
			buttons[RIGHT] = true;
			return true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = false;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
