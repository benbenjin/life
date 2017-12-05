package com.jin.sokoban;

import java.awt.Point;
import java.util.List;

public class SokobanServer {
	private Sokoban sokoban;

	public static void main(String[] args) {
		new SokobanServer().startSokoban();
	}
	
	public void startSokoban() {
		System.out.println("++++++开始游戏++++++");
		sokoban = new Sokoban();
		//sokoban.inputMap(SokobanConstant.DEFAULT_MAP, SokobanConstant.DEFAULT_X, SokobanConstant.DEFAULT_Y);
		sokoban.inputMap(new String(
				  "0, 0, 0, 0, 0, 0,"
				+ "0, 1, 4, 0, 0, 0,"
				+ "0, 0, 1, 1, 1, 0,"
				+ "0, 0, 0, 0, 0, 0,"
				+ "1, 1, 1, 1, 0, 0,"
				+ "0, 0, 3, 2, 0, 0"),
				6, 6);
		System.out.println("------------");
		System.out.println("初始地图：");
		for (int i = 0; i < sokoban.getSizeX(); i++) {
			for (int j = 0; j < sokoban.getSizeY(); j++) {
				System.out.println((sokoban.getSokoban_map())[i][j]);
			}
		}
		System.out.println("------------");
		// 搜索箱子到终点的最短路径
		searchBoxToTerminal();
	}
	
	private void searchBoxToTerminal() {
		System.out.println("搜索箱子到终点的最短路径。。。。。。");
		SearchServer searchServer = new SearchServer(sokoban.getSokoban_map());
		List<Point> path = searchServer.searchShortestPath();
		System.out.println("搜索后地图：");
		for (int i = 0; i < sokoban.getSizeX(); i++) {
			for (int j = 0; j < sokoban.getSizeY(); j++) {
				System.out.println((sokoban.getSokoban_map())[i][j]);
			}
		}
		System.out.println("------------");
		if(path == null)
			System.err.println("死图，无路径！");
		else {
			System.out.println("一条最短路径长度： "+path.size()+" 路径：");
			for (Point point : path) {
				System.out.println(point);
			}
		}
	}
	

}
