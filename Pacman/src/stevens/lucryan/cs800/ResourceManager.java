package stevens.lucryan.cs800;
import java.util.HashMap;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;

public class ResourceManager
{
	private HashMap<String, Mesh> meshes;  //store meshes
	private HashMap<String, Texture> textures;  //store textures

	public ResourceManager()
	{
		meshes = new HashMap<String, Mesh>();
		textures = new HashMap<String, Texture>();
	}

	public void addMesh( String name, Mesh mesh )
	{
		meshes.put( name, mesh );
	}
	
	public Mesh getMesh(String name)
	{
		return meshes.get(name);
	}
	
	public void addTexture( String name, Texture texture )
	{
		textures.put( name, texture );
	}
	
	public Texture getTexture(String name)
	{
		return textures.get(name);
	}
}
