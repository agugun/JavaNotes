package thinkjava.datatype;

import java.util.ArrayList;
import java.util.List;

public class MyTree<T> {
	private T data;
	private MyTree<T> parent;
	private List<MyTree<T>> childs;
	
	public MyTree(T data) {
		this.data = data;
	}
	
	public MyTree<T> addChild(T data) {
		if (childs == null) childs = new ArrayList<MyTree<T>>();
		MyTree<T> tree = new MyTree<T>(data);
		tree.setParent(this);
		childs.add(tree);
		return tree;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public MyTree<T> getParent() {
		return parent;
	}
	public void setParent(MyTree<T> parent) {
		this.parent = parent;
	}
	
	public List<MyTree<T>> getChilds() {
		return childs;
	}

	public void setChilds(List<MyTree<T>> childs) {
		this.childs = childs;
	}

	public boolean isLeaf() {
		return (childs == null || childs.isEmpty());
	}
	
	public boolean isRoot() {
		return (parent == null);
	}
	
	public MyTree<T> findNode (T data) {
		if (this.data.equals(data)){
			return this;
		} else {
			if (!isLeaf()) {
				for (MyTree<T> child : childs) {
					System.out.println(child.getData());
					MyTree<T> tree = child.findNode(data);
					if (tree!= null && tree.getData().equals(data)) return tree;
				}
			}
			return null;
		} 
	}
	
	public void removeNode(T data) {
		MyTree<T> tree = findNode(data);
		for (MyTree<T> myTree : tree.getChilds()) {
			myTree.setParent(tree.getParent());
		}
		tree.getParent().getChilds().remove(data);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof MyTree) {
			MyTree<T> newObj = (MyTree<T>) obj;
			return newObj.getData().equals(data);
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		MyTree<String> root = new MyTree<String>("A");
		MyTree<String> bNode = root.addChild("B");
		bNode.addChild("B1");
		bNode.addChild("B2");
		bNode.addChild("B3");
		
		MyTree<String> cNode = root.addChild("C");
		cNode.addChild("C1");
		cNode.addChild("C2");
		cNode.addChild("C3");
		
		MyTree<String> dNode = root.addChild("D");
		dNode.addChild("D1");
		dNode.addChild("D2");
		dNode.addChild("D3");
		
		root.findNode("D3");
		
		root.removeNode("B");
		System.out.println("==============");
		root.findNode("D3");
	}
}
