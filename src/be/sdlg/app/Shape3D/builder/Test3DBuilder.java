package be.sdlg.app.Shape3D.builder;

import java.util.List;

import be.sdlg.app.Shape3D.Object3DBuilder;
import be.sdlg.app.Shape3D.Object3DComposite;

public class Test3DBuilder extends Object3DBuilder {

	
	public Object3DComposite build(String name) {
		
		Object3DComposite ob3DComposite = new Object3DComposite(name);
		
		createLine3D(ob3DComposite, null, "line1", 0f, 0f, 0f, 1f, 1f, 1f, 1);
	    createArc3D(ob3DComposite, null, "arc1",0f,0f,0f,1f,1f, 0f,Math.PI/2, 10);
		createCube3D(ob3DComposite, null, "cube1",  0f, 0f, 0f, 1f, 1f, 1f, 10);
		createSphere3D(ob3DComposite,null,"sphere1", 0f, 0f, 0f, 1f, 30);
		try {
			ob3DComposite.RotateY("cube1", Math.PI/4);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return ob3DComposite;

	} 
	
}
