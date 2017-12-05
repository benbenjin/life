package com.jin.sokoban;

import java.awt.Point;

/**
 * @describe 基础常量 
 * @author 锦锦金
 *
 */
public class SokobanConstant {

	static String DEFAULT_MAP =
			 "0,4,0,1,"
			+"0,1,0,0,"
			+"0,1,1,0,"
			+"3,2,0,0,";// 默认地图
	
	static int DEFAULT_X = 4,DEFAULT_Y = 4;// 默认地图大小
	static int MAP_X, MAP_Y;// 实际地图大小
	static Point START_MEN;// 初始人物位置
	static Point START_TERMINAL;// 初始终点位置
	static Point START_BOX;// 初始箱子位置
}
