package stevens.lucryan.cs800;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

public class LevelManager {
	private static int COLLISIONDIS2 = 100;
	private int levelNum;
	private ArrayList<Pellet> pelletList;

	public LevelManager(int levelNum) {
		this.levelNum = levelNum;
		pelletList = new ArrayList<Pellet>();

		readLevel();
	}

	public void readLevel() {
		XmlReader xmlFile = new XmlReader();
		String sxml = Gdx.files.internal("data/lvl" + this.levelNum + ".lvl")
				.readString();
		Element xmlE = xmlFile.parse(sxml);
		Array<Element> entities = xmlE.getChildrenByName("entity");

		int posX, posY, posZ;

		for (int i = 0; i < entities.size; ++i) {
			posX = entities.get(i).getIntAttribute("x");
			posY = entities.get(i).getIntAttribute("y");
			posZ = entities.get(i).getIntAttribute("z");

			Pellet p = new Pellet();
			p.setPelletPosition(new Vector3(posX, posY, posZ));
			pelletList.add(p);
		}
	}

	public void render(Camera camera, GL10 gl) {
		tick(camera);
		for (int i = 0; i < pelletList.size(); ++i) {
			gl.glPushMatrix();
			gl.glTranslatef(pelletList.get(i).getPelletPosition().x, pelletList
					.get(i).getPelletPosition().y, pelletList.get(i)
					.getPelletPosition().z);
			pelletList.get(i).getPelletTexture().bind();
			pelletList.get(i).getPelletMesh().render(GL10.GL_TRIANGLE_STRIP);
			gl.glPopMatrix();
		}
	}

	private void tick(Camera camera) {
		for (int i = 0; i < pelletList.size(); ++i) {
			if (camera.position.dst2(pelletList.get(i).getPelletPosition()) <= COLLISIONDIS2)
				pelletList.remove(pelletList.get(i));
		}
	}
}
