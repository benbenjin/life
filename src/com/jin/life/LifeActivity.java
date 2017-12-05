package com.jin.life;

/**
 * @describe 细胞活动
 * @author 锦锦金
 * @date 2017年10月24日
 */
public class LifeActivity {
	private LifeMap lifeMap;
	private int[][] previousMap;

	public LifeActivity(LifeMap lifeMap) {
		init(lifeMap);
	}

	private void init(LifeMap lifeMap) {
		this.lifeMap = lifeMap;

		int x = lifeMap.getLifeMap().length;
		int y = lifeMap.getLifeMap()[0].length;
		this.previousMap = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				previousMap[i][j] = lifeMap.getLifeMap()[i][j].getStatus();
			}
		}

	}
	
	/**
	 * 刷新细胞集
	 * @param lifeMap
	 */
	public void refresh(LifeMap lifeMap) {
		init(lifeMap);
	}

	/**
	 *  细胞图的整体活动
	 */
	public LifeMap activityCells() {
		for (int i = 0; i < previousMap.length; i++) {
			for (int j = 0; j < previousMap[0].length; j++) {
				activityCell(i, j, previousMap.length, previousMap[0].length);
			}
		}
		return this.lifeMap;
	}

	/* 单个细胞活动 */
	private void activityCell(int x, int y, int size_x, int size_y) {
		int liveCounts = 0;// 周围活细胞数
		liveCounts = getSurroundingLivingCells(x, y, size_x, size_y);

		if (liveCounts == 3) {// 转生
			this.lifeMap.getLifeMap()[x][y].setStatus(CellEnums.LIVE.getStatus_code());
		} else if (liveCounts == 2) {// 不变
			;
		} else {// 转死
			this.lifeMap.getLifeMap()[x][y].setStatus(CellEnums.DEAD.getStatus_code());
		}
	}

	/* 得到周围活细胞数 */
	private int getSurroundingLivingCells(int x, int y, int size_x, int size_y) {
		int liveCounts = 0;
		if ((0 <= x - 1) && previousMap[x - 1][y] == CellEnums.LIVE.getStatus_code()) {// 上节点
			liveCounts++;
		}
		if ((0 <= x - 1 && 0 <= y - 1) && previousMap[x - 1][y - 1] == CellEnums.LIVE.getStatus_code()) {// 上左节点
			liveCounts++;
		}
		if ((0 <= y - 1) && previousMap[x][y - 1] == CellEnums.LIVE.getStatus_code()) {// 左节点
			liveCounts++;
		}
		if ((x + 1 < size_x && 0 <= y - 1) && previousMap[x + 1][y - 1] == CellEnums.LIVE.getStatus_code()) {// 左下节点
			liveCounts++;
		}
		if ((x + 1 < size_x) && previousMap[x + 1][y] == CellEnums.LIVE.getStatus_code()) {// 下节点
			liveCounts++;
		}
		if ((x + 1 < size_x && y + 1 < size_y) && previousMap[x + 1][y + 1] == CellEnums.LIVE.getStatus_code()) {// 下右节点
			liveCounts++;
		}
		if ((y + 1 < size_y) && previousMap[x][y + 1] == CellEnums.LIVE.getStatus_code()) {// 右节点
			liveCounts++;
		}
		if ((0 <= x - 1 && y + 1 < size_y) && previousMap[x - 1][y + 1] == CellEnums.LIVE.getStatus_code()) {// 右上节点
			liveCounts++;
		}
		return liveCounts;
	}

}
