package be.sdlg.app.Shape3D;

import java.util.List;

import be.sdlg.app.utils.TreeNode;
import be.sdlg.app.utils.TreeNodeBuilder;

public class Object3DBuilder extends TreeNodeBuilder<Object3DNode> {
	
	/*public Object3DBuilder (List<Object3D> object3Ds) {
		for (Object3D as : object3Ds) {
			Object3DNode asn = new Object3DNode(as);
			list.add(asn);
		}
	}*/
	public Object3DComposite build(String name) {
		return null;
	} 
	public void createLine3D(Object3DComposite composite, Object3DNode parent, String name,  float x1,float y1, float z1, 
			float x2, float y2, float z2, int points) {
		Line3D line3D =new Line3D(x1,y1,z1, x2,y2,z2, points);
		try {
			composite.addNewChildElement(parent, name, line3D);
		} catch (Exception e) {
				System.out.println("createLine3D::Parent not found");
		}
	}
	public void createCube3D(Object3DComposite composite, Object3DNode parent, String name,  float x1,float y1, float z1, 
			float x2, float y2, float z2, int points) {
		
		
		Object3DNode cube3D = new Object3DNode(null);
		cube3D.name = name;
		cube3D.addChild(new Object3DNode(new Line3D(x1,y1,z1,x2,y1,z1, points)), composite);
		cube3D.addChild(new Object3DNode(new Line3D(x2,y1,z1,x2,y2,z1, points)), composite);
		cube3D.addChild(new Object3DNode(new Line3D(x1,y1,z1,x1,y2,z1, points)), composite);
		cube3D.addChild(new Object3DNode(new Line3D(x1,y2,z1,x2,y2,z1, points)), composite);

		cube3D.addChild(new Object3DNode(new Line3D(x1,y1,z2,x2,y1,z2, points)), composite);
		cube3D.addChild(new Object3DNode(new Line3D(x2,y1,z2,x2,y2,z2, points)), composite);
		cube3D.addChild(new Object3DNode(new Line3D(x1,y1,z2,x1,y2,z2, points)), composite);
		cube3D.addChild(new Object3DNode(new Line3D(x1,y2,z2,x2,y2,z2, points)), composite);
	
	
		cube3D.addChild(new Object3DNode(new Line3D(x1,y1,z1,x1,y1,z2, points)), composite);
		cube3D.addChild(new Object3DNode(new Line3D(x2,y1,z1,x2,y1,z2, points)), composite);
		cube3D.addChild(new Object3DNode(new Line3D(x2,y2,z1,x2,y2,z2, points)), composite);
		cube3D.addChild(new Object3DNode(new Line3D(x1,y2,z1,x1,y2,z2, points)), composite);

		
		try {
			composite.addNewChild(parent, name, cube3D);
		} catch (Exception e) {
				System.out.println("createLine3D::Parent not found");
		}
		
	}
	public void createSphere3D(Object3DComposite composite, Object3DNode parent, String name, float x,float y, float z,
			float r, int points)  {
		Object3DNode sphere3D = new Object3DNode(null);
		sphere3D.name = name;
		try {
			composite.addNewChild(parent, name, sphere3D);
		} catch (Exception e) {
				System.out.println("createLine3D::Parent not found");
		}
		sphere3D.addChild(new Object3DNode(new Arc3D(x,y,z,r,r,0, 2*Math.PI,points)), composite);
		sphere3D.addChild(new Object3DNode(new Arc3D(x,y,z,r,r,0, 2*Math.PI,points)), composite);
		Object3DNode circ = sphere3D.childs.get(1);
		try {
			composite.RotateY(circ.name, Math.PI/2);
		} catch (Exception e) {
			System.out.println("createSphere3D::Parent not found");
		}
		sphere3D.addChild(new Object3DNode(new Arc3D(x,y,z,r,r,0, 2*Math.PI,points)), composite);
		circ = sphere3D.childs.get(2);
		try {
			composite.RotateY(circ.name, Math.PI/4);
		} catch (Exception e) {
			System.out.println("createSphere3D::Parent not found");
		}
		sphere3D.addChild(new Object3DNode(new Arc3D(x,y,z,r,r,0, 2*Math.PI,points)), composite);
		circ = sphere3D.childs.get(3);
		try {
			composite.RotateY(circ.name, -Math.PI/4);
		} catch (Exception e) {
			System.out.println("createSphere3D::Parent not found");
		}

		
	}
	public void createBlock3D(Object3DComposite composite, Object3DNode parent, String name) {
		Object3D empty = new Object3D();
		try {
			composite.addNewChildElement(parent, name, empty);
		} catch (Exception e) {
				System.out.println("createBlock3D::Parent not found");
		}
		
	}
	public void createArc3D(Object3DComposite composite, Object3DNode parent, String name,  float cx,float cy, float cz, 
			float a, float b, double phi0, double phi1,  int points) {
		Arc3D arc3D =new Arc3D(cx,cy,cz,a,b, phi0, phi1, points);
		try {
			composite.addNewChildElement(parent, name, arc3D);
		} catch (Exception e) {
				System.out.println("createArc3D::Parent not found");
		}

	}

}