package stevens.lucryan.cs800;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g3d.loaders.obj.ObjLoader;

public class TestGDX implements ApplicationListener {

	public static PerspectiveCamera camera;
	//private float angle;  //spin
	public static ResourceManager resourceManager;
	private SkyBox skyBox;
	private LevelManager levelManager;
	private final Input input = new Input();

	@Override
	public void create() {
		camera = new PerspectiveCamera(45, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		camera.near = 1;
		camera.far = 1500;
		camera.position.set(0.0f, 0.0f, 100.0f);
		camera.direction.set(0.0f, 0.0f, -1.0f);
		
		Gdx.input.setInputProcessor(input);
		
		createResources();

		// initialize skybox
		Texture[] skyBoxTextures = new Texture[6];
		skyBoxTextures[0] = resourceManager.getTexture("skybox_front");
		skyBoxTextures[1] = resourceManager.getTexture("skybox_back");
		skyBoxTextures[2] = resourceManager.getTexture("skybox_left");
		skyBoxTextures[3] = resourceManager.getTexture("skybox_right");
		skyBoxTextures[4] = resourceManager.getTexture("skybox_up");
		skyBoxTextures[5] = resourceManager.getTexture("skybox_down");
		skyBox = new SkyBox(skyBoxTextures);

		levelManager = new LevelManager(0);
	}

	private void createResources() {
		resourceManager = new ResourceManager();
		Texture textureBuffer;
		Mesh meshBuffer;

		// skybox textures;
		textureBuffer = new Texture(Gdx.files.internal("data/stormy_FR.jpg"),
				true);
		textureBuffer.setFilter(TextureFilter.MipMap, TextureFilter.Linear);
		resourceManager.addTexture("skybox_front", textureBuffer);
		textureBuffer = new Texture(Gdx.files.internal("data/stormy_BK.jpg"),
				true);
		textureBuffer.setFilter(TextureFilter.MipMap, TextureFilter.Linear);
		resourceManager.addTexture("skybox_back", textureBuffer);
		textureBuffer = new Texture(Gdx.files.internal("data/stormy_LF.jpg"),
				true);
		textureBuffer.setFilter(TextureFilter.MipMap, TextureFilter.Linear);
		resourceManager.addTexture("skybox_left", textureBuffer);
		textureBuffer = new Texture(Gdx.files.internal("data/stormy_RT.jpg"),
				true);
		textureBuffer.setFilter(TextureFilter.MipMap, TextureFilter.Linear);
		resourceManager.addTexture("skybox_right", textureBuffer);
		textureBuffer = new Texture(Gdx.files.internal("data/stormy_UP.jpg"),
				true);
		textureBuffer.setFilter(TextureFilter.MipMap, TextureFilter.Linear);
		resourceManager.addTexture("skybox_up", textureBuffer);
		textureBuffer = new Texture(Gdx.files.internal("data/stormy_DN.jpg"),
				true);
		textureBuffer.setFilter(TextureFilter.MipMap, TextureFilter.Linear);
		resourceManager.addTexture("skybox_down", textureBuffer);

		//
		meshBuffer = ObjLoader.loadObj(Gdx.files.internal("data/pellet.obj")
				.read());
		// meshBuffer.scale(10.0f, 10.0f, 10.0f);
		resourceManager.addMesh("pellet", meshBuffer);
		textureBuffer = new Texture(
				Gdx.files.internal("data/pellet_texture.jpg"), true);
		textureBuffer.setFilter(TextureFilter.MipMap, TextureFilter.Linear);
		resourceManager.addTexture("pellet", textureBuffer);

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
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glEnable(GL10.GL_TEXTURE_2D);

		// input ticks here
		input.tick();

		// camera ticks here
		camera.update();
		camera.apply(gl);

		// skyBox ticks here
		skyBox.render(camera, gl);
		levelManager.render(camera, gl);
		// render other objects
		//angle += 45 * Gdx.graphics.getDeltaTime();
		//gl.glPushMatrix();
		//gl.glRotatef(angle, 0, 1, 0);
		//gl.glPopMatrix();
		
	}

	@Override
	public void resize(int arg0, int arg1) {

	}

	@Override
	public void resume() {
	}

}