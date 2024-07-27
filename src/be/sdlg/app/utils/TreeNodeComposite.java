package be.sdlg.app.utils;

import java.util.ArrayList;
import java.util.List;

import be.sdlg.app.Shape3D.Object3DBuilder;
import be.sdlg.app.Shape3D.Object3DNode;



/* Composite à utiliser après le Build, pour effectuer des modification sur l'arbre */ 
public class TreeNodeComposite<Object3D> {
	public List<Object3DNode> roots;
	public List<Object> iterator;
	
	private void recurAdd(Object3DNode t) {
		iterator.add(t.getItem());
		if (t.childs !=null) {
			for (Object3DNode c : t.childs) {
				recurAdd(c);
			}
		}
	}

	public TreeNodeComposite(Object3DBuilder builder) {
		roots = builder.createTree();
		iterator = new ArrayList<Object>();
		for (Object3DNode t : roots) {
			recurAdd(t);
		}
	}
	public TreeNodeComposite() {
		roots = new ArrayList<Object3DNode>();
	}
	public void addChild(Object3DNode parentNode, Object3DNode childNode)  {
		if (parentNode == null) {
			roots.add(childNode);
			childNode.parent = null;
		}
		else {
			parentNode.childs.add(childNode);
			childNode.parent = parentNode;
		}
	}
	public void removeChild(Object3DNode parentNode, Object3DNode childNode) {
		//TODO : implements
	}
		
	private String recurToString(Object3DNode t) {
		String s;
		s = t.toString()+'\n';
		if (t.childs !=null) {
			for (Object3DNode c : t.childs) {
				s=s+recurToString(c);
			}
		}
		return s;
		
	}
	public String toString() {
		String s="";
		for (Object3DNode t : roots) {
			s=s + recurToString(t);
		}
		return s;
	}
	
	public Object3DNode retrieveByObject(Object ob) {
		return null;
	}
/* Template reccurence function to implement with details in the child class version*/
	/* The method applyEach must be customized and called with the proper parameters in each() and recurEach()
	 functions.
	 */
	/*private void recurEach(TreeNode<T> t ) {
		
	}
	public void each( ) {
		for (TreeNode<T> t : roots) {
			recurEach(t) ;
		}
	}
	
	protected void applyEach() {
		
	}*/

}