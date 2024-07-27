package be.sdlg.app.Shape3D;

import java.util.ArrayList;

import be.sdlg.app.utils.TreeNode;

public class Object3DNode extends TreeNode<Object3DNode> {
	public Object3D object3D;
	public long id;
	public String name;
	public long parentId;
	public Object3DComposite composite;


	public Object3DNode() {
		
		super();
		childs = new ArrayList<Object3DNode>();
	}
	public Object3DNode (Object3D as) {
		this();
		this.object3D = as;
		if (as !=null)
			as.node = this;
	}
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public long getParentId() {
		return this.parentId;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public Object getItem() {
		return  this.object3D;
	}
	public void addChild(Object3DNode child, Object3DComposite cp) {
		if (child.name==null) {
			
				cp.incCounter();
				child.name = this.name+"_"+cp.getCounter();
		}
		this.childs.add(child);
		child.id = cp.getCounter();
		child.parent= this;
		child.composite =cp;
	}

}