package be.sdlg.app.Shape3D;

import org.ejml.data.FMatrix4x4;

public class FMatrixRotY extends FMatrix4x4  {

	private static final long serialVersionUID = 1L;

	public void setMatrix( double angle) {
		a11 = (float) Math.cos(angle);
		a12 = 0;
		a13 = (float) Math.sin(angle);
		a14 = 0;
		
		a21 = 0;
		a22 = 1;
		a23 = 0;
		a24 = 0;
		
		a31 = (float) - Math.sin(angle);
		a32 = 0;
		a33 = (float) Math.cos(angle);
		a34 = 0;
		
		a41= 0;
		a42=0;
		a43=0;
		a44 = 1;
			
	}
	public FMatrixRotY(double angle) {
		super();
		setMatrix(angle);

	}
	public FMatrixRotY() {
		super();
		setMatrix((double) 0f);
	}

	
}
