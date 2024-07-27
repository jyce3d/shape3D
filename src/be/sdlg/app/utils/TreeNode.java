package be.sdlg.app.utils;


import java.util.List;

import be.sdlg.app.Shape3D.Object3DNode;

public abstract class TreeNode<T> {
	public TreeNode<T> parent;
	public List<Object3DNode> childs;
	public abstract long getId();
	public abstract long getParentId();
	public abstract void setId(long id);
	public abstract void setParentId(long parentId);
	
	public String toString() {
		return "not initialized";
	}
	public abstract Object getItem();
}