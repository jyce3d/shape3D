package be.sdlg.app.Shape3D;

import java.awt.Graphics;
import java.util.ArrayList;

import org.ejml.data.FMatrix4;
import org.ejml.dense.fixed.CommonOps_FDF4;

public class Object3D  {
	public ArrayList<FMatrix4> vertices = null;
	public Object3DNode node;
	public Object3D () {
		vertices = new ArrayList<FMatrix4>();
	}
	
	public  void drawShape3D( Graphics g, Object3DComposite cp) {
	
	}	
	
	public void drawVertex(Graphics g, Object3DComposite cp) {
		FMatrix4 proj4P0= null;
		FMatrix4 proj4P1= null;
		FMatrix4 P0 =new FMatrix4();
		FMatrix4 p=new FMatrix4();
		
		
		int x1, y1, x2,y2;

		for (int i=1; i<this.vertices.size();i++ ) {
				P0.setTo(this.vertices.get(i-1));
				p.setTo(this.vertices.get(i));

				proj4P0 = cp.projection(P0);
				proj4P1 = cp.projection(p);
				x1 = (int) (proj4P0.a1*cp.UOMPixRatio)+cp.centerXPix;
				y1 = (int) (-proj4P0.a2*cp.UOMPixRatio)+cp.centerYPix;
			
				x2 = (int) (proj4P1.a1*cp.UOMPixRatio)+cp.centerXPix;
				y2 = (int) (-proj4P1.a2*cp.UOMPixRatio)+cp.centerYPix;
				g.drawLine(x1,y1,x2,y2);
				P0.setTo(p);

			
		} 
	}
	public void RotateX(double angle) {
		FMatrixRotX rotX = new FMatrixRotX(angle);
		FMatrix4 vRes = new FMatrix4();
		for (FMatrix4 v : vertices ) {
			CommonOps_FDF4.mult( rotX,v, vRes );
			v.setTo(vRes);
		}
	}
	public void RotateY(double angle) {
		FMatrixRotY rotY = new FMatrixRotY(angle);
		FMatrix4 vRes = new FMatrix4();
		for (FMatrix4 v : vertices ) {
			CommonOps_FDF4.mult( rotY,v, vRes );
			v.setTo(vRes);
		}
	}
	public void RotateZ(double angle) {
		FMatrixRotZ rotZ = new FMatrixRotZ(angle);
		FMatrix4 vRes = new FMatrix4();
		for (FMatrix4 v : vertices ) {
			CommonOps_FDF4.mult( rotZ,v, vRes );
			v.setTo(vRes);
		}
	}
	
}
