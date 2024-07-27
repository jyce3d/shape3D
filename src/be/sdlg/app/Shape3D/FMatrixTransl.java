package be.sdlg.app.Shape3D;

import org.ejml.data.FMatrix4x4;

public class FMatrixTransl extends FMatrix4x4 {

	private static final long serialVersionUID = 5412583365531303909L;
	
	public void setMatrix( float tx, float ty, float tz) {
		a11 = tx;
		a12 = 0;
		a13 = 0;
		a14 = 0;
		
		a21 = ty;
		a22 = 0;
		a23 = 0;
		a24 = 0;
		
		a31 = tz;
		a32 = 0;
		a33 = 0;
		a34 = 0;
		
		a41= 0;
		a42=0;
		a43=0;
		a44 = 1;
			
	}
	public FMatrixTransl(float tx, float ty, float tz) {
		super();
		setMatrix(tx,ty,tz);

	}
	public FMatrixTransl() {
		super();
		setMatrix(0,0,0);

	}
	
}
