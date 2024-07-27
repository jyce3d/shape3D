package be.sdlg.app.Shape3D.builder;

import be.sdlg.app.Shape3D.Object3DBuilder;
import be.sdlg.app.Shape3D.Object3DComposite;

//TODO : Implement the face
public class Face3DBuilder extends Object3DBuilder {
public Object3DComposite build(String name) {
		float modulexy =0.0607142857142857f;
		float modulez= 0.0607142857142857f;
		
		double xFactor = 2.5f;
		double yFactor = 3.5f;
		double zFactor = 3.5f;
		Object3DComposite ob3DComposite = new Object3DComposite(name);
		
	    createArc3D(ob3DComposite, null, name+ "_cr_zup",0f,0f,0f,1.5f*modulexy , 1.5f*modulez, (double) 0.585685543458,(double) (Math.PI-0.585685543458), 30);
	    createArc3D(ob3DComposite, null, name + "_cr_zdw",0f,0f,0f,1.5f*modulexy, 1.5f*modulez, (double) 0.585685543458,(double) (Math.PI-0.585685543458), 30);
	    createArc3D(ob3DComposite, null, name + "_cr_xyface",0f,0f,0f,1.5f*modulexy, 1.5f*modulez, (double) 0.585685543458,(double) (Math.PI-0.585685543458), 30);
	    createArc3D(ob3DComposite, null, name + "_cr_arcnose",0f,0f,0f,1.5f*modulexy, 1.5f*modulez, (double) 0.585685543458,(double) (Math.PI-0.585685543458), 30);
	    createArc3D(ob3DComposite, null, name + "_cr_arcmouth",0f,0f,0f,1.5f*modulexy, 1.5f*modulez, (double) 0.585685543458,(double) (Math.PI-0.585685543458), 30);
	    createArc3D(ob3DComposite, null, name + "_cr_arcade",0f,0f,0f,1.5f*modulexy, 1.5f*modulez, (double) 0.585685543458,(double) (Math.PI-0.585685543458), 30);
	    createArc3D(ob3DComposite, null, name + "_cr_xyback",0f,0f,0f,1.5f*modulexy, 1.5f*modulez, (double) 0.585685543458,(double) (Math.PI-0.585685543458), 30);

	    
	    try {
			ob3DComposite.RotateX(name+ "_cr_zup", Math.PI/2);
			ob3DComposite.RotateX(name + "_cr_zdw", - Math.PI/2);
			ob3DComposite.Translate(name + "_cr_arcnose", 0f, (0.16666666667f*modulexy), -modulez);
			ob3DComposite.Translate(name + "_cr_arcmouth", 0f, (0.16666666667f*modulexy), -1.5f*modulez);
			ob3DComposite.Translate(name + "_cr_arcade", 0f, (1.11803398875f-1.5f)*modulexy, modulez);
			ob3DComposite.RotateX(name+ "_cr_xyback", Math.PI);
			
			// fin
			ob3DComposite.RotateY(name, Math.PI/2);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	    return ob3DComposite;
}
	
	/*


	 arc:=Drawer3D.Scene3DTree.AddMayeSurface3D(Scene3DRef);
	 CreateMayeEllipseClip(arc,0,0,0,1.5*modulexy,1.5*modulez,0.585685543458,(pi-0.585685543458),10,BODY_COLOR,BODY_THIN,sprefix+'_cr_xyback',Scene3D,Drawer3D);
	 arc.RotateX(pi);
	 -->
	 valuex:=1.2499999999993;
	 valuez:=0.829156197589911;
	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,valuex*modulexy,0,valuez*moduleZ,valuex*modulexy,0,-valuez*modulez,BODY_COLOR,BODY_THIN,sPrefix+'_cr_hl1',Scene3D,Drawer3D);
	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,valuex*modulexy,-valuez*modulexy,0,valuex*modulexy,valuez*modulexy,0,BODY_COLOR,BODY_THIN,sPrefix+'_cr_hl2',Scene3D,Drawer3D);
	 Ellipse:=Drawer3D.Scene3DTree.AddMayeSurface3D(Scene3DRef);
	 CreateMayeEllipse(Ellipse,0,0,0,valuez*modulez,valuez*modulexy,20,BODY_COLOR,BODY_THIN,sPrefix+'_cr_xysidel',Scene3D,Drawer3D);
	 Ellipse.RotateY(pi/2);
	 Ellipse.Translate(valuex*modulexy,0,0);

	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,-valuex*modulexy,0,valuez*moduleZ,-valuex*modulexy,0,-valuez*modulez,BODY_COLOR,BODY_THIN,sPrefix+'_cr_hr1',Scene3D,Drawer3D);
	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,-valuex*modulexy,-valuez*modulexy,0,-valuex*modulexy,valuez*modulexy,0,BODY_COLOR,BODY_THIN,sPrefix+'_cr_hr2',Scene3D,Drawer3D);
	 Ellipse:=Drawer3D.Scene3DTree.AddMayeSurface3D(Scene3DRef);
	 CreateMayeEllipse(Ellipse,0,0,0,valuez*modulez,valuez*modulexy,20,BODY_COLOR,BODY_THIN,sPrefix+'_cr_xysider',Scene3D,Drawer3D);
	 Ellipse.RotateY(pi/2);
	 Ellipse.Translate(-valuex*modulexy,0,0);

	 arc:=Drawer3D.Scene3DTree.AddMayeSurface3D(Scene3DRef);
	 CreateMayeEllipseClip(arc,0,0,0,1.5*modulez,1.5*modulexy,0,2*pi,40,BODY_COLOR,BODY_THIN,sprefix+'_cr_ring',Scene3D,Drawer3D);
	 arc.RotateY(pi/2);

	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,0,(2-1/3)*modulexy,0,0,2*modulexy,-modulez,BODY_COLOR,BODY_THIN,sPrefix+'_cr_noze',Scene3D,Drawer3D);

	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,0,0,modulez,0,1.11803398875*modulexy,modulez,BODY_COLOR,BODY_THIN,sPrefix+'_cr_ljoin1',Scene3D,Drawer3D);
	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,0,1.5*modulexy,0,0,-1.5*modulexy,0,BODY_COLOR,BODY_THIN,sPrefix+'_cr_ljoin2',Scene3D,Drawer3D);
	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,0,2*modulexy,-modulez,0,0,-modulez,BODY_COLOR,BODY_THIN,sPrefix+'_cr_ljoin3',Scene3D,Drawer3D);
	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,0,(2-1/3)*modulexy,-1.5*modulez,0,0,-1.5*modulez,BODY_COLOR,BODY_THIN,sPrefix+'_cr_ljoin4',Scene3D,Drawer3D);
	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,0,(2-1/3)*modulexy,-2*modulez,0,0,-2*modulez,BODY_COLOR,BODY_THIN,sPrefix+'_cr_ljoin5',Scene3D,Drawer3D);

	 valuex:=0.97338991015;
	 valuez:=1.38217994062;
	 arc:=Drawer3D.Scene3DTree.AddMayeSurface3D(Scene3DRef);
	 CreateMayeEllipseClip(arc,0,0,0,4/3*modulexy,4/3*modulexy,valuex,valuez,5,BODY_COLOR,BODY_THIN,sPrefix+'_cr_arceye1',Scene3D,Drawer3D);
	 arc.Translate(0,0,-0.25*modulez+tr_z);
	 arc:=Drawer3D.Scene3DTree.AddMayeSurface3D(Scene3DRef);
	 CreateMayeEllipseClip(arc,0,0,0,4/3*modulexy,4/3*modulexy,pi-valuex,pi-valuez,5,BODY_COLOR,BODY_THIN,sPrefix+'_cr_arceye2',Scene3D,Drawer3D);
	 arc.Translate(0,0,-0.25*modulez+tr_z);

	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,0.75*modulexy,modulexy,-0.125*modulez,0.75*modulexy,modulexy,-1.5*modulez,BODY_COLOR,BODY_THIN,sPrefix+'_cr_reye',Scene3D,Drawer3D);

	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,-0.75*modulexy,modulexy,-0.125*modulez,-0.75*modulexy,modulexy,-1.5*modulez,BODY_COLOR,BODY_THIN,sPrefix+'_cr_leye',Scene3D,Drawer3D);

	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,-0.25*modulexy,(2-1/3)*modulexy,-2*modulez,0.25*modulexy,(2-1/3)*modulexy,-2*modulez,BODY_COLOR,BODY_THIN,sPrefix+'_cr_menton',Scene3D,Drawer3D);

	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,-0.25*modulexy,(2-1/3)*modulexy,-2*modulez,-0.25*modulexy,(2-1/3)*modulexy,0,BODY_COLOR,BODY_THIN,sPrefix+'_cr_lnose1',Scene3D,Drawer3D);

	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,0.25*modulexy,(2-1/3)*modulexy,-2*modulez,0.25*modulexy,(2-1/3)*modulexy,0,BODY_COLOR,BODY_THIN,sPrefix+'_cr_lnose2',Scene3D,Drawer3D);

	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,-0.75*modulexy,4/3*modulexy,-0.60*modulez,-(0.75*modulexy+0.005),4/3*modulexy+0.003,-0.60*modulez+0.010,BODY_COLOR,BODY_THIN,sPrefix+'_cr_maxi1',Scene3D,Drawer3D);
	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,0.75*modulexy,4/3*modulexy,-0.60*modulez,(0.75*modulexy+0.005),4/3*modulexy+0.003,-0.60*modulez+0.010,BODY_COLOR,BODY_THIN,sPrefix+'_cr_maxi2',Scene3D,Drawer3D);

	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,0.25*modulexy,modulexy,-2*modulez,1.25*modulexy,0.20*modulexy,-4/3*modulez,BODY_COLOR,BODY_THIN,sPrefix+'_cr_mandib1',Scene3D,Drawer3D);
	 Line:=Drawer3D.Scene3DTree.AddLine3D(Scene3DRef);
	 CreateLine(Line,-0.25*modulexy,modulexy,-2*modulez,-1.25*modulexy,0.20*modulexy,-4/3*modulez,BODY_COLOR,BODY_THIN,sPrefix+'_cr_mandib2',Scene3D,Drawer3D);

	 arc:=Drawer3D.Scene3DTree.AddMayeSurface3D(Scene3DRef);
	 CreateMayeEllipseClip(arc,0,0,0,1.5*modulexy,1.5*modulexy,arctan(0.0552455357/(1.5*modulexy)),-arctan(0.0552455357/( 1.5*modulexy)),5,BODY_COLOR,BODY_THIN,sPrefix+'_sph_mouth1',Scene3D,Drawer3D);
	 arc.RotateZ(pi/2);
	 arc1:=Drawer3D.Scene3DTree.AddMayeSurface3D(Scene3DRef);
	 CreateMayeEllipseClip(arc1,0,0,0,1.5*modulexy,1.5*modulexy,arctan(0.0552455357/(1.5*modulexy)),-arctan(0.0552455357/( 1.5*modulexy)),5,BODY_COLOR,BODY_THIN,sPrefix+'_sph_mouth2',Scene3D,Drawer3D);
	 arc1.RotateZ(pi/2);
	 arc.Translate(0,0.16666666667*modulexy,-(1.5*modulez-0.0140625));
	 arc1.Translate(0,0.16666666667*modulexy,-(1.5*modulez-0.005625));

	 //module_cz:=3.5*moduleZ;

	 Scene3D.Translate(0,0,2*modulez+7*Module_cz);
	 Rotule3D.x:=0;
	 Rotule3D.y:= - 0.25*modulexy;
	 Rotule3D.z:= ((1.75+1.25) * modulez+6.25*Module_cz);*/
}
