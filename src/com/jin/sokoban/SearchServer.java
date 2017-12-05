package com.jin.sokoban;

import java.awt.Point;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @describe 路径搜索服务
 * @author 锦锦金
 *
 */
public class SearchServer {
	private SokobanNode[][] sokobanMap;// 地图

	public SearchServer(SokobanNode[][] sokobanMap) {
		this.sokobanMap = sokobanMap;
	}

	/**
	 * 搜索最短路径
	 */
	public List<Point> searchShortestPath() {
		bfsSearch();// 广度遍历地图搜索最短路径
		// 装载最短路径 
		List<Point> result = getOneOfShortestPath();
		return result;
	}

	/* 广度遍历搜索 */
	private void bfsSearch() {
		Deque<Point> queue = new LinkedList<Point>();// 搜索队列
		Point p = SokobanConstant.START_BOX;
		sokobanMap[p.x][p.y].setLayer(0);// 顶层节点层次为0
		sokobanMap[p.x][p.y].setFather(null);// 顶层节点无上层节点
		queue.offerFirst(p);
		while (!queue.isEmpty()) {
			p = queue.peekLast();
			if (isTerminal(p.x, p.y))
				break;
			if (pointIsLive(p.x - 1, p.y)) {// 上节点
				sokobanMap[p.x - 1][p.y].setFather(sokobanMap[p.x][p.y]);
				sokobanMap[p.x - 1][p.y].setLayer(sokobanMap[p.x - 1][p.y].getFather().getLayer() + 1);
				queue.offerFirst(new Point(p.x - 1, p.y));// 进队
			}
			if (pointIsLive(p.x + 1, p.y)) {// 下节点
				sokobanMap[p.x + 1][p.y].setFather(sokobanMap[p.x][p.y]);
				sokobanMap[p.x + 1][p.y].setLayer(sokobanMap[p.x + 1][p.y].getFather().getLayer() + 1);
				queue.offerFirst(new Point(p.x + 1, p.y));// 进队
			}
			if (pointIsLive(p.x, p.y - 1)) {// 左节点
				sokobanMap[p.x][p.y - 1].setFather(sokobanMap[p.x][p.y]);
				sokobanMap[p.x][p.y - 1].setLayer(sokobanMap[p.x][p.y - 1].getFather().getLayer() + 1);
				queue.offerFirst(new Point(p.x, p.y - 1));// 进队
			}
			if (pointIsLive(p.x, p.y + 1)) {// 右节点
				sokobanMap[p.x][p.y + 1].setFather(sokobanMap[p.x][p.y]);
				sokobanMap[p.x][p.y + 1].setLayer(sokobanMap[p.x][p.y + 1].getFather().getLayer() + 1);
				queue.offerFirst(new Point(p.x, p.y + 1));// 进队
			}
			if (!queue.isEmpty())
				queue.pollLast();// 出队

		}
	}

	/* 装载一条最短路径 */
	private List<Point> getOneOfShortestPath() {
		// 死图
		if (sokobanMap[SokobanConstant.START_TERMINAL.x][SokobanConstant.START_TERMINAL.y].getFather() == null)
			return null;

		// 活图装载路径
		List<Point> list = new LinkedList<Point>();
		Point p = SokobanConstant.START_TERMINAL;
		list.add(p);
		while (sokobanMap[p.x][p.y].getFather() != null) {
			p = new Point(sokobanMap[p.x][p.y].getFather().getX(), sokobanMap[p.x][p.y].getFather().getY());
			list.add(p);
		}
		return list;
	}

	/* 判断该点是否可走 */
	private boolean pointIsLive(int x, int y) {
		if (x < 0 || x >= SokobanConstant.MAP_X)
			return false;
		if (y < 0 || y >= SokobanConstant.MAP_Y)
			return false;
		if (sokobanMap[x][y].getIdentity() == IdentityEnum.BOX.identity_code)
			return false;
		if (sokobanMap[x][y].getIdentity() == IdentityEnum.BLOCK.identity_code)
			return false;
		if (sokobanMap[x][y].getIdentity() == IdentityEnum.MAN.identity_code)
			return false;
		if (sokobanMap[x][y].getFather() != null)
			return false;

		return true;
	}

	/* 是否到达终点判定 */
	private boolean isTerminal(int x, int y) {
		return SokobanConstant.START_TERMINAL.x == x && SokobanConstant.START_TERMINAL.y == y;
	}

}
