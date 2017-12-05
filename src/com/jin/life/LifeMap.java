package com.jin.life;

import java.util.Random;

/**
 * @describe 细胞图
 * @author 锦锦金
 * @date 2017年10月23日
 */
public class LifeMap {
	private Cell[][] lifeMap;

	public LifeMap() {
		init(false);
	}

	/**
	 * 刷新地图
	 */
	public void refesh() {
		init(true);
	}

	/**
	 * 初始化地图
	 * 
	 * @param mode,是否自定义输入地图
	 */
	private void init(boolean mode) {
		System.out.println("开始初始化地图数据。。。。。。");

		if (!mode)// 默认随机生成地图
			inputMapData(null, CellConstant.DEFAULT_X, CellConstant.DEFAULT_Y);
		else {
			inputMapData(CellConstant.INPUT_MAP, CellConstant.INPUT_X, CellConstant.INPUT_Y);
		}
		System.out.println("地图初始化完毕！");
	}

	/**
	 * 输入地图数据
	 */
	public void inputMapData(String resource, int size_x, int size_y) {
		System.out.println("开始录入地图数据。。。。。。");
		// 地图输入数据效验
		if (!valideMapData(resource, size_x, size_y)) {// 数据尺寸错误
			return;
		} else {
			CellConstant.MAP_X = size_x;
			CellConstant.MAP_Y = size_y;
		}
		this.lifeMap = new Cell[size_x][size_y];

		try {
			int[][] map_data = new int[size_x][size_y];
			String[] data = resource.split(",");
			for (int i = 0; i < size_x; i++) {
				for (int j = 0; j < size_y; j++) {
					map_data[i][j] = Integer.parseInt(data[i * size_y + j].trim());
				}
			}
			// 装载地图节点数据，并初始化
			loadMap(map_data, size_x, size_y);
		} catch (Exception e) {
			System.err.println("地图数据错误！");
			e.printStackTrace();
			return;
		}
		System.out.println("录入地图数据成功！");
	}

	/* 装载地图节点数据，并初始化 */
	private void loadMap(int[][] map_data, int size_x, int size_y) {
		System.out.println("开始初始化并化加载地图节点。。。。。。");
		for (int i = 0; i < size_x; i++) {
			for (int j = 0; j < size_y; j++) {
				this.lifeMap[i][j] = new Cell(i, j, map_data[i][j]);
			}
		}
		System.out.println("装载地图节点，初始化成功！");
	}

	/* 效验地图数据 */
	private boolean valideMapData(String resource, int size_x, int size_y) {
		System.out.println("开始效验地图数据。。。。。。");
		boolean flag = true;
		if (resource == null) {// 数据源为空
			randomCreateMapData(size_x, size_y);// 随机产生地图数据
			flag = false;
		}
		if (size_x < 1 || size_y < 1) {
			System.err.println("地图尺寸错误，不可小于1！");
			flag = false;
		}
		if (flag)
			System.out.println("效验地图数据无误！");
		return flag;
	}

	/* 随机产生地图数据 */
	private void randomCreateMapData(int size_x, int size_y) {
		System.out.println("开始随机产生地图数据。。。。。。");
		StringBuilder resource = new StringBuilder("");
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < size_x * size_y; i++) {
			resource.append(r.nextInt(2)).append(",");
		}
		String result = resource.substring(0, resource.length() - 1);
		System.out.println("随机产生地图数据完毕！");
		inputMapData(result, size_x, size_y);// 输入地图数据
	}

//	/* 接收外部输入数据 */
//	private String readRource() {
//		String result = null;
//
//		return result;
//	}

	public Cell[][] getLifeMap() {
		return lifeMap;
	}

	public void setLifeMap(Cell[][] lifeMap) {
		this.lifeMap = lifeMap;
	}

}
