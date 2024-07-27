package be.sdlg.app.Shape3D;
import java.awt.Graphics;
import java.util.ArrayList;

import org.ejml.data.FMatrix4;
public class Line3D extends Object3D {


	
	public Line3D(float x1, float y1, float z1, float x2, float y2, float z2, int points) {
		super();
		 float dx=(x2-x1)/points;
		 float dy=(y2-y1)/points;
		 float dz=(z2-z1)/points;

		 float x=x1;
		 float y=y1;
		 float z=z1;

		 for (int i=0; i<=points; i++) {
			 FMatrix4 p = new FMatrix4();
			 p.setTo(x,y,z,1);
			 vertices.add(p);
			 x+=dx;
			 y+=dy;
			 z+=dz;
		 }
	}
	public void drawShape3D(Graphics g, Object3DComposite cp) {
		drawLine3D(g, cp);
	}



	public void drawLine3D(Graphics g, Object3DComposite cp) {
		drawVertex(g, cp);
	}
}
