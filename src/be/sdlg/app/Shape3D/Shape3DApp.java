package be.sdlg.app.Shape3D;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.ejml.data.FMatrix1Row;
import org.ejml.data.FMatrix3x3;
import org.ejml.data.FMatrix4;
import org.ejml.data.FMatrix4x4;
import org.ejml.dense.fixed.CommonOps_FDF4;

import be.sdlg.app.Shape3D.builder.Face3DBuilder;
import be.sdlg.app.Shape3D.builder.Test3DBuilder;

public class Shape3DApp extends JFrame {

	
    public	Object3DComposite scene3D  = null;
	// Crée un singleton de la classe service -> une seule instance possible
	public Create3DService draw3DService =null;
	

	private static final long serialVersionUID = 1L;
	//JPanel pane = new JPanel();
	PaneXYZ paneXYZ = new PaneXYZ(this);
	

	public Shape3DApp() {
		super("Shape3D - Tester");
		
//		Test3DBuilder sc3DBuilder = new Test3DBuilder();
		Face3DBuilder sc3DBuilder = new Face3DBuilder();
		scene3D= sc3DBuilder.build("scene3D");

		scene3D.UOMPixRatio = 4096;
		scene3D.UOMName = "mm";

		
		setSize(1600,960);


		//cube = new Cube3D(0f,0f,0f, 1f,1f,1f);
		


		setContentPane(paneXYZ);	
		paneXYZ.refresh();

	}
	public static void main(String arv[]) {
				
		Shape3DApp appFrame = new Shape3DApp();
		appFrame.show();
		appFrame.setResizable(false);
	}

}
