package be.sdlg.app.Shape3D;

import org.ejml.data.FMatrix4x4;

public class FMatrixRotZ extends FMatrix4x4  {

	private static final long serialVersionUID = 1L;

	public void setMatrix( double angle) {
		a11 = (float) Math.cos(angle);
		a12 = (float) - Math.sin(angle);
		a13 = 0;
		a14 = 0;
		
		a21 = (float)  Math.sin(angle);
		a22 = (float) Math.cos(angle);
		a23 = 0;
		a24 = 0;

		a31 = 0;
		a32 = 0;
		a33 = 1;
		a34 = 0;
		
		
		a41= 0;
		a42=0;
		a43=0;
		a44 = 1;
			
	}
	public FMatrixRotZ(double angle) {
		super();
		setMatrix(angle);

	}
	public FMatrixRotZ() {
		super();
		setMatrix((double) 0f);
	}

	
}
