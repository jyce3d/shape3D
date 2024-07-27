package be.sdlg.app.Shape3D;

import java.awt.Graphics;
import java.util.List;

import org.ejml.data.FMatrix4;
import org.ejml.data.FMatrix4x4;
import org.ejml.dense.fixed.CommonOps_FDF4;

import be.sdlg.app.utils.TreeNode;
import be.sdlg.app.utils.TreeNodeComposite;

public class Object3DComposite extends TreeNodeComposite<Object3DNode> {
		private long idCounter = 0; 
		public int UOMPixRatio = 128;
		public String UOMName ="meter";
		public int centerXPix = 800;
		public int centerYPix = 480;
		public double azimuth =Math.PI/6;
		public double latitude = Math.PI/4;
		
		private FMatrixRotX rotX;
		private FMatrixRotY rotY;
		private FMatrixRotZ rotZ;
		private FMatrixTransl transl;
		
		public void incCounter() {
			idCounter++;
		}
		public long getCounter() {
			return idCounter;
		}
		public FMatrix4 projection(FMatrix4 pt) {
			rotX.setMatrix(latitude);
			rotY.setMatrix(azimuth);
			FMatrix4 resVec = new FMatrix4();
			FMatrix4 resVec2 = new FMatrix4();

			CommonOps_FDF4.mult( rotX,pt, resVec );
			CommonOps_FDF4.mult( rotY,resVec, resVec2 );
			return resVec2;
		}
		// roll 
		private void recurRotateX(Object3DNode obn, double roll) {
			Object3D ob3d = (Object3D) obn.getItem();
			rotX.setMatrix(roll);
			applyTransformation(rotX, ob3d);
			for (Object3DNode obn2 : obn.childs) {
				recurRotateX(obn2, roll) ;
			}
		}
		public void RotateX(String name, double roll) throws Exception {
			Object3DNode obj = retrieveByName(name);
			if (obj==null) throw new Exception("Object3DComposite::RotateX : no such aname");
				
			Object3D ob3d = (Object3D) obj.getItem();
			rotX.setMatrix(roll);
			applyTransformation(rotX, ob3d);
			for (Object3DNode obn : obj.childs) {
				recurRotateX(obn, roll) ;
			}
		}

		private void applyTransformation(FMatrix4x4 mat, Object3D ob3d) {
			FMatrix4 resVec = new FMatrix4();
			
			if (ob3d!=null) {
				for (FMatrix4 v : ob3d.vertices) {
					CommonOps_FDF4.mult(mat, v, resVec);
					v.setTo(resVec);
				}
				
			}
		}
		private void recurRotateY(Object3DNode obn, double pitch) {
			Object3D ob3d = (Object3D) obn.getItem();
			rotY.setMatrix(pitch);
			applyTransformation(rotY, ob3d);
			for (Object3DNode obn2 : obn.childs) {
				recurRotateY(obn2, pitch) ;
			}
		}
		public void RotateY(String name, double pitch) throws Exception {
			Object3DNode obj = retrieveByName(name);
			if (obj==null) throw new Exception("Object3DComposite::RotateY : no such aname");
				
			Object3D ob3d = (Object3D) obj.getItem();
			rotY.setMatrix(pitch);
			applyTransformation(rotY, ob3d);
			for (Object3DNode obn : obj.childs) {
				recurRotateY(obn, pitch) ;
			}
		}
		
		private void recurRotateZ(Object3DNode obn, double yaw) {
			Object3D ob3d = (Object3D) obn.getItem();
			rotZ.setMatrix(yaw);
			applyTransformation(rotZ, ob3d);
			for (Object3DNode obn2 : obn.childs) {
				recurRotateZ(obn2, yaw) ;
			}
		}
		
		public void RotateZ(String name, double yaw) throws Exception {
			Object3DNode obj = retrieveByName(name);
			if (obj==null) throw new Exception("Object3DComposite::RotateY : no such aname");
				
			Object3D ob3d = (Object3D) obj.getItem();
			rotZ.setMatrix(yaw);
			applyTransformation(rotZ, ob3d);
			for (Object3DNode obn : obj.childs) {
				recurRotateZ(obn, yaw) ;
			}
		}
		private void recurTranslate(Object3DNode obn, float tx, float ty, float tz) {
			Object3D ob3d = (Object3D) obn.getItem();
			transl.setMatrix(tx,ty,tz);
			applyTransformation(transl, ob3d);
			for (Object3DNode obn2 : obn.childs) {
				recurTranslate(obn2, tx,ty,tz) ;
			}
		}
		public void Translate(String name, float tx, float ty, float tz) throws Exception {
			Object3DNode obj = retrieveByName(name);
			if (obj==null) throw new Exception("Object3DComposite::Translate : no such aname");
				
			Object3D ob3d = (Object3D) obj.getItem();
			transl.setMatrix(tx,ty,tz);
			applyTransformation(transl, ob3d);
			for (Object3DNode obn : obj.childs) {
				recurTranslate(obn, tx,ty,tz) ;
			}
			
		}
		public void drawRecur(Create3DService srv, Graphics g, TreeNode<Object3DNode> p) {
			Object3D ob=null;
			ob = (Object3D) p.getItem();
			if (ob!=null)
				ob.drawShape3D(g, this);
			if (p.childs !=null ) {
				for (TreeNode<Object3DNode> c : p.childs) {
					drawRecur(srv, g, c);
				}
			}

		}
		public void drawComposite3D(Create3DService srv, Graphics g) {
			for (TreeNode<Object3DNode> r : roots ) {
				drawRecur(srv, g, r);
			}
				
		}
		private void initialize() {
			rotX = new FMatrixRotX();
			rotY = new FMatrixRotY();
			rotZ = new FMatrixRotZ();
			transl = new FMatrixTransl();
		}
		public Object3DComposite() {
			initialize();
		} 
 		public Object3DComposite(String name) {
			this();
 		/*	Object3D obj = new Object3D();
			Object3DNode obj3DNode = new Object3DNode(obj) ;
			obj3DNode.name = name;
			obj3DNode.id=++idCounter;
			this.addChild(null, obj3DNode);*/
			

			
			
		}
		public Object3DComposite(Object3DBuilder builder ) {
			//List<TreeNode<StudyEventRefNode>> 
			initialize();
		}


		public void addNewChildElement(TreeNode<Object3DNode> parentNode, String name, Object3D childObj) throws Exception {
			Object3DNode childNode = new Object3DNode(childObj);
			childObj.node = childNode;
				
			addNewChild(parentNode, name, childNode);
			
			
		
			
		}
		public void addNewChild(TreeNode<Object3DNode> parentNode, String name,Object3DNode childNode) {
			childNode.composite = this;
			this.incCounter();
			childNode.name = name;
			childNode.setId(this.getCounter()); 
				
			if (parentNode != null)
				parentNode.childs.add(childNode);
			else
				roots.add(childNode);

		}
		private Object3DNode recurByObject(Object3DNode  child2, Object3DNode ob) {
			for (Object3DNode child : child2.childs) {
				if (child.getId() == ob.getId() ) {
					return child;
				} else return recurByObject(child, child);
			}
			return null;
		}
	
		public Object3DNode retrieveByObject(Object3DNode obj) {
			for (Object3DNode  ob : roots ) {
				if (ob.getId() == obj.id) {
					return ob;
				} else
					return recurByObject(ob, obj );
			}
			return null;
			
		}
		
		private Object3DNode recurByName(String name, Object3DNode ob) {
			Object3DNode r2 = null;			
			for (Object3DNode child : ob.childs) {
				if (child.name.equals(name)) 
					return child;
				else if ((r2= recurByName(name, child))!=null) return r2 ;
			}
			return null;
		}
		public Object3DNode retrieveByName(String name) {
			Object3DNode r2 = null;
			for (Object3DNode r : roots) {
				if (r.name.equals(name) )
					return r;
				else 					
					if (  (r2=recurByName(name, r))!=null) return r2;
				
			}
			return null;
		}
		
}


