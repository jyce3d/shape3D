package be.sdlg.app.Shape3D;

import java.awt.Graphics;

import org.ejml.data.FMatrix4;

public class Arc3D extends Object3D {

	
	private float compEllipseX(float cx, float cy, float cz, float a, float b, 
			double phi0) {
		return  (float) (a*Math.cos(phi0) +cx);
		
	}
	private float compEllipseY(float cx, float cy, float cz, float a, float b, 
			double phi0) {
		return  (float) (b*Math.sin(phi0)+cy);
		
	}

	public Arc3D(float cx, float cy, float cz, float a, float b, double phi0, double phi1, int points) {
		super();
		double deltaphi = (phi1-phi0) / points;
		float px=0;
		float py=0;
		
		for (int i=0; i<=points; i++) {
			FMatrix4 p = new FMatrix4();			
			px = compEllipseX(cx,cy,cz,a,b,phi0);
			py = compEllipseY(cx,cy,cz,a,b,phi0);
			p.setTo( px, py, cz,1);
			vertices.add(p);
			phi0+=deltaphi;
		/*	px = compEllipseX(cx,cy,cz,a,b,phi0);
			py = compEllipseY(cx,cy,cz,a,b,phi0);
			p.setTo( px, py, cz,1);
			vertices.add(p);*/
		}
	}
	public void drawShape3D(Graphics g, Object3DComposite cp) {
		drawVertex(g, cp);
	}
}
