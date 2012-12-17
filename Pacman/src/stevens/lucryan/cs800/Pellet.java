package stevens.lucryan.cs800;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Pellet {
	private Vector3 pelletPosition;
	private Mesh pelletMesh;
	private Texture pelletTexture;
	
	public Pellet() {		
		pelletMesh = TestGDX.resourceManager.getMesh("pellet");
		pelletTexture = TestGDX.resourceManager.getTexture("pellet");
	}

	public Vector3 getPelletPosition() {
		return pelletPosition;
	}

	public void setPelletPosition(Vector3 vector3) {
		this.pelletPosition = vector3;
	}

	public Mesh getPelletMesh() {
		return pelletMesh;
	}

	public void setPelletMesh(Mesh pelletMesh) {
		this.pelletMesh = pelletMesh;
	}

	public Texture getPelletTexture() {
		return pelletTexture;
	}

	public void setPelletTexture(Texture pelletTexture) {
		this.pelletTexture = pelletTexture;
	}
	
	
}
