/**
 * 节点定义类：
 * 一个数据存储区
 * 一个父节点指针
 * 两个子节点指针：左/右
 */
package com.citi.hz41382.java.caculator.md01.tree;

/**
 * @author
 *
 */
public class Node {
	
	/** 数据存储 */
	private String data;
	
	/** 父节点 */
	private Node parent;
	
	/** 左子节点 */
	private Node left;
	
	/** 右子节点 */
	private Node right;
	
	/** 子树标志 */
	private boolean subTreeFlg;
	
	/** 构造方法 */
	public Node() {
	}
	
	/**
	 * 
	 * @param data 数据部分
	 */
	public Node(String data) {
		this.data = data;
		this.subTreeFlg = false;
	}
	
	/**
	 * 
	 * @param data 数据部分
	 * @param parent 父节点
	 */
	public Node(String data, Node parent) {
		this.data = data;
		this.parent = parent;
		this.subTreeFlg = false;
	}

	/**
	 * @return data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data 設定する data
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return parent
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * @param parent 設定する parent
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	/**
	 * @return left
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * @param left 設定する left
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * @return right
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * @param right 設定する right
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * @return subTreeFlg
	 */
	public boolean getSubTreeFlg() {
		return subTreeFlg;
	}

	/**
	 * @param subTreeFlg 設定する subTreeFlg
	 */
	public void setSubTreeFlg(boolean subTreeFlg) {
		this.subTreeFlg = subTreeFlg;
	}
}
