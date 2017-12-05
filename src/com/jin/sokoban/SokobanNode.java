package com.jin.sokoban;

/**
 * @describe 地图节点
 * @author 锦锦金
 *
 */
public class SokobanNode {

	private int x;// 节点x坐标
	private int y; // 节点y坐标
	private Integer identity;// 节点身份,0表示空道,1表示障碍物,2表示箱子,3表示人,4表示终点
	private SokobanNode father;// 父节点
	private int layer;// 层次

	public SokobanNode(int x, int y) {
		this(x, y, null);
	}

	public SokobanNode(int x, int y, Integer identity) {
		this.x = x;
		this.y = y;
		this.identity = identity;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

	public SokobanNode getFather() {
		return father;
	}

	public void setFather(SokobanNode father) {
		this.father = father;
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	@Override
	public String toString() {
		if (father != null)
			return "NodeSokoban [x=" + x + ", y=" + y + ", identity=" + identity + ",[father=(" + father.x + ","
					+ father.y + ")]" + ", layer=" + layer + "]";
		else
			return "NodeSokoban [x=" + x + ", y=" + y + ", identity=" + identity + ",[father=" + father + ", layer="
					+ layer + "]";
	}
}
