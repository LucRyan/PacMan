package stevens.lucryan.cs800;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;

public class SkyBox {
	private Mesh[] skyBoxMesh;
	private Texture[] skyBoxTexture;

	public SkyBox(Texture[] textures) {
		skyBoxMesh = new Mesh[6];
		skyBoxTexture = new Texture[6];

		// front
		skyBoxMesh[0] = new Mesh(true, 4, 4, new VertexAttribute(
				Usage.Position, 3, "a_position"), new VertexAttribute(
				Usage.TextureCoordinates, 2, "a_texCoords"));

		skyBoxMesh[0].setVertices(new float[] { -1.5f, 1.5f, -1.5f, 0, 0,
				-1.5f, -1.5f, -1.5f, 0, 1, 1.5f, 1.5f, -1.5f, 1, 0, 1.5f,
				-1.5f, -1.5f, 1, 1 });
		skyBoxMesh[0].setIndices(new short[] { 0, 1, 2, 3 });

		// back
		skyBoxMesh[1] = new Mesh(true, 4, 4, new VertexAttribute(
				Usage.Position, 3, "a_position"), new VertexAttribute(
				Usage.TextureCoordinates, 2, "a_texCoords"));

		skyBoxMesh[1].setVertices(new float[] { 1.5f, 1.5f, 1.5f, 0, 0, 1.5f,
				-1.5f, 1.5f, 0, 1, -1.5f, 1.5f, 1.5f, 1, 0, -1.5f, -1.5f, 1.5f,
				1, 1 });
		skyBoxMesh[1].setIndices(new short[] { 0, 1, 2, 3 });

		// left
		skyBoxMesh[2] = new Mesh(true, 4, 4, new VertexAttribute(
				Usage.Position, 3, "a_position"), new VertexAttribute(
				Usage.TextureCoordinates, 2, "a_texCoords"));

		skyBoxMesh[2].setVertices(new float[] { -1.5f, 1.5f, 1.5f, 0, 0, -1.5f,
				-1.5f, 1.5f, 0, 1, -1.5f, 1.5f, -1.5f, 1, 0, -1.5f, -1.5f,
				-1.5f, 1, 1 });
		skyBoxMesh[2].setIndices(new short[] { 0, 1, 2, 3 });

		// right
		skyBoxMesh[3] = new Mesh(true, 4, 4, new VertexAttribute(
				Usage.Position, 3, "a_position"), new VertexAttribute(
				Usage.TextureCoordinates, 2, "a_texCoords"));

		skyBoxMesh[3].setVertices(new float[] { 1.5f, 1.5f, -1.5f, 0, 0, 1.5f,
				-1.5f, -1.5f, 0, 1, 1.5f, 1.5f, 1.5f, 1, 0, 1.5f, -1.5f, 1.5f,
				1, 1 });
		skyBoxMesh[3].setIndices(new short[] { 0, 1, 2, 3 });

		// up
		skyBoxMesh[4] = new Mesh(true, 4, 4, new VertexAttribute(
				Usage.Position, 3, "a_position"), new VertexAttribute(
				Usage.TextureCoordinates, 2, "a_texCoords"));

		skyBoxMesh[4].setVertices(new float[] { -1.5f, 1.5f, 1.5f, 0, 0, -1.5f,
				1.5f, -1.5f, 0, 1, 1.5f, 1.5f, 1.5f, 1, 0, 1.5f, 1.5f, -1.5f,
				1, 1 });
		skyBoxMesh[4].setIndices(new short[] { 0, 1, 2, 3 });

		// down
		skyBoxMesh[5] = new Mesh(true, 4, 4, new VertexAttribute(
				Usage.Position, 3, "a_position"), new VertexAttribute(
				Usage.TextureCoordinates, 2, "a_texCoords"));

		skyBoxMesh[5].setVertices(new float[] { -1.5f, -1.5f, -1.5f, 0, 0,
				-1.5f, -1.5f, 1.5f, 0, 1, 1.5f, -1.5f, -1.5f, 1, 0, 1.5f,
				-1.5f, 1.5f, 1, 1 });
		skyBoxMesh[5].setIndices(new short[] { 0, 1, 2, 3 });

		skyBoxTexture = textures;
	}

	public void render(Camera camera, GL10 gl) {
		skyBoxMesh[0].setVertices(new float[] { -1.5f + camera.position.x,
				1.5f + camera.position.y, -1.5f + camera.position.z, 0, 0,
				-1.5f + camera.position.x, -1.5f + camera.position.y,
				-1.5f + camera.position.z, 0, 1, 1.5f + camera.position.x,
				1.5f + camera.position.y, -1.5f + camera.position.z, 1, 0,
				1.5f + camera.position.x, -1.5f + camera.position.y,
				-1.5f + camera.position.z, 1, 1 });
		skyBoxMesh[1].setVertices(new float[] { 1.5f + camera.position.x,
				1.5f + camera.position.y, 1.5f + camera.position.z, 0, 0,
				1.5f + camera.position.x, -1.5f + camera.position.y,
				1.5f + camera.position.z, 0, 1, -1.5f + camera.position.x,
				1.5f + camera.position.y, 1.5f + camera.position.z, 1, 0,
				-1.5f + camera.position.x, -1.5f + camera.position.y,
				1.5f + camera.position.z, 1, 1 });
		skyBoxMesh[2].setVertices(new float[] { -1.5f + camera.position.x,
				1.5f + camera.position.y, 1.5f + camera.position.z, 0, 0,
				-1.5f + camera.position.x, -1.5f + camera.position.y,
				1.5f + camera.position.z, 0, 1, -1.5f + camera.position.x,
				1.5f + camera.position.y, -1.5f + camera.position.z, 1, 0,
				-1.5f + camera.position.x, -1.5f + camera.position.y,
				-1.5f + camera.position.z, 1, 1 });
		skyBoxMesh[3].setVertices(new float[] { 1.5f + camera.position.x,
				1.5f + camera.position.y, -1.5f + camera.position.z, 0, 0,
				1.5f + camera.position.x, -1.5f + camera.position.y,
				-1.5f + camera.position.z, 0, 1, 1.5f + camera.position.x,
				1.5f + camera.position.y, 1.5f + camera.position.z, 1, 0,
				1.5f + camera.position.x, -1.5f + camera.position.y,
				1.5f + camera.position.z, 1, 1 });
		skyBoxMesh[4].setVertices(new float[] { -1.5f + camera.position.x,
				1.5f + camera.position.y, 1.5f + camera.position.z, 0, 0,
				-1.5f + camera.position.x, 1.5f + camera.position.y,
				-1.5f + camera.position.z, 0, 1, 1.5f + camera.position.x,
				1.5f + camera.position.y, 1.5f + camera.position.z, 1, 0,
				1.5f + camera.position.x, 1.5f + camera.position.y,
				-1.5f + camera.position.z, 1, 1 });
		skyBoxMesh[5].setVertices(new float[] { -1.5f + camera.position.x,
				-1.5f + camera.position.y, -1.5f + camera.position.z, 0, 0,
				-1.5f + camera.position.x, -1.5f + camera.position.y,
				1.5f + camera.position.z, 0, 1, 1.5f + camera.position.x,
				-1.5f + camera.position.y, -1.5f + camera.position.z, 1, 0,
				1.5f + camera.position.x, -1.5f + camera.position.y,
				1.5f + camera.position.z, 1, 1 });

		gl.glDisable(GL10.GL_DEPTH_TEST);
		gl.glPushMatrix();
		skyBoxTexture[0].bind();
		skyBoxMesh[0].render(GL10.GL_TRIANGLE_STRIP);
		skyBoxTexture[1].bind();
		skyBoxMesh[1].render(GL10.GL_TRIANGLE_STRIP);
		skyBoxTexture[2].bind();
		skyBoxMesh[2].render(GL10.GL_TRIANGLE_STRIP);
		skyBoxTexture[3].bind();
		skyBoxMesh[3].render(GL10.GL_TRIANGLE_STRIP);
		skyBoxTexture[4].bind();
		skyBoxMesh[4].render(GL10.GL_TRIANGLE_STRIP);
		skyBoxTexture[5].bind();
		skyBoxMesh[5].render(GL10.GL_TRIANGLE_STRIP);
		gl.glPopMatrix();
		gl.glEnable(GL10.GL_DEPTH_TEST);
	}
}
