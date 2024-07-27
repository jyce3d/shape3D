package be.sdlg.app.Shape3D;

import java.awt.Graphics;
import java.util.ArrayList;

import org.ejml.data.FMatrix4;
import org.ejml.dense.fixed.CommonOps_FDF4;

// utiliser pour le dessin des structure
public final class Create3DService {
	private static Create3DService INSTANCE;


	private Create3DService() {

	}
	
	public static Create3DService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Create3DService();
        }
        
        return INSTANCE;
	}

}
