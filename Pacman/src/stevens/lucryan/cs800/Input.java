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
		PacMan.camera.translate(0.0f, 0.0f, -0.3f);		  
	}

	public void moveDown() {
		PacMan.camera.translate(0.0f, 0.0f, 0.3f);	
	}

	public void turnLeft() {
		Vector3 oldPosition = new Vector3(PacMan.camera.position.x, 
				      PacMan.camera.position.y, 
					  PacMan.camera.position.z );	
PacMan.camera.rotateAround(oldPosition, new Vector3(0.0f, 
1.0f, 
0.0f), 1.0f);
	}

	public void turnRight() {
		Vector3 oldPosition = new Vector3(PacMan.camera.position.x, 
				   					      PacMan.camera.position.y, 
				   						  PacMan.camera.position.z );	
		PacMan.camera.rotateAround(oldPosition, new Vector3(0.0f, 
					 1.0f, 
					 0.0f), -1.0f);
	}

  
	public void tick(){
		for (int i = 0; i < buttons.length; i++){
			if(buttons[i] == true){
				switch (i){
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
		for( int i = 0; i < buttons.length; i++){
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
