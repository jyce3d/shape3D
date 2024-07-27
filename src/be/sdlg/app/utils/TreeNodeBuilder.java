package be.sdlg.app.utils;


import java.util.ArrayList;
import java.util.List;

import be.sdlg.app.Shape3D.Object3DNode;

public class TreeNodeBuilder<Object3D> {
	protected List<Object3DNode> list;
	public List<Object3DNode> roots;
	public TreeNodeBuilder() {
		roots = new ArrayList<Object3DNode>();
		list = new ArrayList<Object3DNode>();
	}
	private void recur(Object3DNode node) {
		for (Object3DNode n : list) {
			if (n.getParentId() == (node.getId())) {
				if (node.childs ==null)
					node.childs =  new ArrayList<Object3DNode>();
				node.childs.add(n);
				n.parent = node;
			}
				
		}
	}
	// return roots
	// On place dans la liste les enfants et leur racines
	// Utile pour créer un TreeNode directement des éléments d'une DB ou d'un fichier si les IDs sont corrects.
	public List<Object3DNode> createTree() {
		for (Object3DNode t : list) {
			if (t.parent == null ) 
				roots.add(t);
		}
		for (Object3DNode r : roots) {
			recur(r); 
		}
		return roots;
	}
	
}