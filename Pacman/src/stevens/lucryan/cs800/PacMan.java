package stevens.lucryan.cs800;


import java.io.IOException;
import java.io.InputStream;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.loaders.obj.ObjLoader;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;


public class PacMan implements ApplicationListener {
	SpriteBatch batch;
	Texture texture;
	TextureRegion fbteRegion;
	BitmapFont font;
	// public static OrthographicCamera camera;
	public static PerspectiveCamera camera;
	Mesh mesh;
	Color clearColor = new Color(0.2f, 0.2f, 0.2f, 1);
	float angle;

	private Mesh[] skyBoxMesh = new Mesh[6];
	private Texture[] skyBoxTexture = new Texture[6];

	private final Input input = new Input();

	@Override
	public void create() {
		// front
		if (skyBoxMesh[0] == null) {
			skyBoxMesh[0] = new Mesh(true, 4, 4, new VertexAttribute(
					Usage.Position, 3, "a_position"), new VertexAttribute(
					Usage.TextureCoordinates, 2, "a_texCoords"));

			skyBoxMesh[0].setVertices(new float[] { -1.5f, 1.5f, 1.5f, 0, 0,
					-1.5f, -1.5f, 1.5f, 0, 1, 1.5f, 1.5f, 1.5f, 1, 0, 1.5f,
					-1.5f, 1.5f, 1, 1 });
			skyBoxMesh[0].setIndices(new short[] { 0, 1, 2, 3 });
			FileHandle imageFileHandle = Gdx.files.internal("data/tex.jpg");
			skyBoxTexture[0] = new Texture(imageFileHandle);
		}
		// back
		if (skyBoxMesh[1] == null) {
			skyBoxMesh[1] = new Mesh(true, 4, 4, new VertexAttribute(
					Usage.Position, 3, "a_position"), new VertexAttribute(
					Usage.TextureCoordinates, 2, "a_texCoords"));

			skyBoxMesh[1].setVertices(new float[] { -1.5f, 1.5f, -1.5f, 0, 0,
					-1.5f, -1.5f, -1.5f, 0, 1, 1.5f, 1.5f, -1.5f, 1, 0, 1.5f,
					-1.5f, -1.5f, 1, 1 });
			skyBoxMesh[1].setIndices(new short[] { 0, 1, 2, 3 });
			FileHandle imageFileHandle = Gdx.files.internal("data/tex.jpg");
			skyBoxTexture[1] = new Texture(imageFileHandle);
		}

		InputStream stream = Gdx.files.internal("data/ship.obj").read();
		mesh = ObjLoader.loadObj(stream);
		Gdx.input.setInputProcessor(input);
		try {
			stream.close();
		} catch (IOException e) {
		}
		mesh.scale(10.0f, 10.0f, 10.0f);
		texture = new Texture(Gdx.files.internal("data/ship.png"),
				Format.RGB565, true);
		texture.setFilter(TextureFilter.MipMap, TextureFilter.Linear);

		camera = new PerspectiveCamera(45, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());

		camera.near = 1;
		camera.far = 500;
		camera.position.set(0.0f, 0.0f, 100.0f);
		// camera.lookAt(0.0f, 0.0f, 0.0f);
		camera.direction.set(0.0f, 0.0f, -1.0f);
	}

	@Override
	public void dispose() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void render() {
		GL10 gl = Gdx.graphics.getGL10();
		gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		// gl.glClearColor(clearColor.r, clearColor.g, clearColor.b,
		// clearColor.a);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		// gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glEnable(GL10.GL_TEXTURE_2D);
		input.tick();

		skyBoxMesh[0].setVertices(new float[] { -1.5f + camera.position.x,
				1.5f + camera.position.y, 1.5f + camera.position.z, 0, 0,
				-1.5f + camera.position.x, -1.5f + camera.position.y,
				1.5f + camera.position.z, 0, 1, 1.5f + camera.position.x,
				1.5f + camera.position.y, 1.5f + camera.position.z, 1, 0,
				1.5f + camera.position.x, -1.5f + camera.position.y,
				1.5f + camera.position.z, 1, 1 });
		skyBoxMesh[1].setVertices(new float[] { -1.5f + camera.position.x,
				1.5f + camera.position.y, -1.5f + camera.position.z, 0, 0,
				-1.5f + camera.position.x, -1.5f + camera.position.y,
				-1.5f + camera.position.z, 0, 1, 1.5f + camera.position.x,
				1.5f + camera.position.y, -1.5f + camera.position.z, 1, 0,
				1.5f + camera.position.x, -1.5f + camera.position.y,
				-1.5f + camera.position.z, 1, 1 });

		camera.update();
		camera.apply(gl);
		// angle += 45 * Gdx.graphics.getDeltaTime();
		gl.glPushMatrix();
		// gl.glRotatef(angle, 0, 1, 0);
		// texture.bind();
		// mesh.render(GL10.GL_TRIANGLES);
		// mesh.render(GL10.GL_TRIANGLE_FAN);
		skyBoxTexture[0].bind();
		skyBoxMesh[0].render(GL10.GL_TRIANGLE_STRIP);
		skyBoxTexture[1].bind();
		skyBoxMesh[1].render(GL10.GL_TRIANGLE_STRIP);
		gl.glPopMatrix();
		
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glPushMatrix();
		texture.bind();
		mesh.render(GL10.GL_TRIANGLES);
		gl.glPopMatrix();
		gl.glDisable(GL10.GL_DEPTH_TEST);
	}

	@Override
	public void resize(int arg0, int arg1) {

	}

	@Override
	public void resume() {
	}

}