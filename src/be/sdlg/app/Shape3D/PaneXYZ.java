package be.sdlg.app.Shape3D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

import org.ejml.data.FMatrix4;

public class PaneXYZ extends JPanel {
	
	private Shape3DApp m_parent = null;
	FMatrix4 proj4P0= null;
	FMatrix4 proj4P1= null;
	FMatrix4 proj4P2= null;
	FMatrix4 proj4P3= null;

	private static final long serialVersionUID = 1L;
	public PaneXYZ(Shape3DApp parent) {
		super();
		m_parent = parent;

	}
	private void drawFace(Graphics2D g2, float UOM) {
		int x1 = (int) (proj4P0.a1*UOM)+800;
		int y1 = (int) (proj4P0.a2*UOM)+600;
		
		int x2 = (int) (proj4P1.a1*UOM)+800;
		int y2 = (int) (proj4P1.a2*UOM)+600;
		g2.drawLine(x1,y1,x2,y2);

		x1 = x2;
		y1 = y2;
		
		x2 = (int) (proj4P3.a1*UOM)+800;
		y2 = (int) (proj4P3.a2*UOM)+600;
		
		g2.drawLine(x1,y1,x2,y2);
		
		x1 = x2;
		y1 = y2;
		
		x2 = (int) (proj4P2.a1*UOM)+800;
		y2 = (int) (proj4P2.a2*UOM)+600;
		
		g2.drawLine(x1,y1,x2,y2);

		x1 = x2;
		y1 = y2;
		
		x2 = (int) (proj4P0.a1*UOM)+800;
		y2 = (int) (proj4P0.a2*UOM)+600;
		
		g2.drawLine(x1,y1,x2,y2);

	}
	public void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D) g;
		g2.setPaint(Color.BLUE);		
		g2.fill(new Rectangle(0,0,1600,1200));
		g2.setPaint(Color.YELLOW);
		//g2.drawLine(800, 0, 800,1200);
		//Cube3D cub = m_parent.cube;
	/*	double az = m_parent.az;
		double lat = m_parent.lat;
		proj4P0 = m_parent.projection(cub.p0, az, lat);*/
//		System.out.print("Start");
		//		proj4P0.print();
//		proj4P1 = m_parent.projection(cub.p1, az, lat);
		//proj4P1.print();
//		proj4P2 = m_parent.projection(cub.p2, az, lat);
		//proj4P2.print();
//		proj4P3 = m_parent.projection(cub.p3, az,lat);
		//proj4P3.print();
		//System.out.print("End\n");
//		float UOM = m_parent.UOMPix;
/*		drawFace(g2, UOM);

		proj4P0 = m_parent.projection(cub.p4, m_parent.az, m_parent.lat);
		proj4P1 = m_parent.projection(cub.p5, m_parent.az, m_parent.lat);
		proj4P2 = m_parent.projection(cub.p6, m_parent.az, m_parent.lat);
		proj4P3 = m_parent.projection(cub.p7, m_parent.az, m_parent.lat);

		drawFace(g2, UOM);*/
		m_parent.scene3D.drawComposite3D(m_parent.draw3DService, g2);
		
		


	}
	public void refresh() {
		this.invalidate();
		this.repaint();
	}
}
