package be.sdlg.app.Shape3D;

import org.ejml.data.FMatrix4x4;

public class FMatrixRotX extends FMatrix4x4 {
	private static final long serialVersionUID = 1L;
	public void setMatrix( double angle) {
		a11 = 1;
		a12 = 0;
		a13 = 0;
		a14 = 0;
		
		a21 = 0;
		a22 = (float) Math.cos(angle);
		a23 = (float) (-Math.sin(angle));
		a24 = 0;
		
		a31 = 0;
		a32 = (float) Math.sin(angle);
		a33 = (float) Math.cos(angle);
		a34 = 0;
		
		a41= 0;
		a42=0;
		a43=0;
		a44 = 1;
			
	}
	public FMatrixRotX(double angle) {
		super();
		setMatrix(angle);

	}
	public FMatrixRotX() {
		super();
		setMatrix((double) 0f);
	}

}
