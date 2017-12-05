package com.jin.sokoban;

import java.awt.Point;

/**
 * @describe 初始化展开推箱子地图类
 * @author 锦锦金
 *
 */
public class Sokoban {

	private SokobanNode[][] sokobanMap;// 地图
	private int sizeX, sizeY;// 地图实际尺寸

	public Sokoban() {
		this(null);
	}

	public Sokoban(SokobanNode[][] sokobanMap) {
		this.sokobanMap = sokobanMap;
	}

	/**
	 * 输入地图数据
	 */
	public void inputMap(String resource, int size_x, int size_y) {
		System.out.println("开始录入地图数据。。。。。。");
		// 地图输入数据效验
		if (!valideMapData(resource, size_x, size_y)) {// 数据尺寸错误
			System.err.println("录入地图数据失败！");
			return;
		} else {
			this.sizeX =SokobanConstant.MAP_X= size_x;
			this.sizeY =SokobanConstant.MAP_Y= size_y;
		}
		this.sokobanMap = new SokobanNode[size_x][size_x];

		try {
			int[][] map_data = new int[sizeX][sizeY];
			String[] data = resource.split(",");
			for (int i = 0; i < sizeX; i++) {
				for (int j = 0; j < sizeY; j++) {
					map_data[i][j] = Integer.parseInt(data[i * sizeY + j].trim());
				}
			}
			// 装载地图节点数据，并初始化
			loadMap(map_data, size_x, size_y);
		} catch (Exception e) {
			System.err.println("地图数据错误！");
			System.out.println("加载默认地图。。。。。。");
			inputMap(SokobanConstant.DEFAULT_MAP, SokobanConstant.DEFAULT_X, SokobanConstant.DEFAULT_Y);
		}
		System.out.println("录入地图数据成功！");
	}

	/* 装载地图节点数据，并初始化 */
	private void loadMap(int[][] data, int size_x, int size_y) {
		System.out.println("开始初始化并化加载地图节点。。。。。。");
		for (int i = 0; i < size_x; i++) {
			for (int j = 0; j < size_y; j++) {
				this.sokobanMap[i][j] = new SokobanNode(i, j, data[i][j]);
				if (data[i][j] == IdentityEnum.MAN.identity_code)
					SokobanConstant.START_MEN = new Point(i, j);
				if (data[i][j] == IdentityEnum.TERMINAL.identity_code)
					SokobanConstant.START_TERMINAL = new Point(i, j);
				if (data[i][j] == IdentityEnum.BOX.identity_code)
					SokobanConstant.START_BOX = new Point(i, j);
			}
		}
		System.out.println("装载地图节点，初始化成功！");
	}

	/* 效验地图数据 */
	private boolean valideMapData(String resource, int size_x, int size_y) {
		System.out.println("开始效验地图数据。。。。。。");
		boolean flag = true;
		if (resource == null) {
			System.err.println("地图数据源不能为空！");
			flag = false;
		}
		if (size_x < 1 || size_y < 1) {
			System.err.println("地图尺寸错误，不可小于1！");
			flag = false;
		}
		if (size_x != size_y) {
			System.err.println("地图尺寸错误，应为正方地图！");
			flag = false;
		}
		if (flag)
			System.out.println("效验地图数据无误！");
		return flag;
	}

	public SokobanNode[][] getSokoban_map() {
		return sokobanMap;
	}

	public void setSokoban_map(SokobanNode[][] sokobanMap) {
		this.sokobanMap = sokobanMap;
	}

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

}
