package com.jin.life;

/**
 * @describe 细胞节点实体
 * @author 锦锦金
 *
 */
public class Cell {

	private int x;// 细胞地图位置x
	private int y;// 细胞地图位置y
	private Integer status;// 细胞当前生命状态

	public Cell(int x, int y) {
		this(x, y, null);
	}

	public Cell(int x, int y, Integer status) {
		this.x = x;
		this.y = y;
		this.status = status;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Cell[x=" + x + ",y=" + y + ",status=" + status + "]";
	}
}
