package com.jin.life;

import java.awt.Color;

import javax.swing.JButton;

/**
 * @describe 细胞节点视图
 * @author 锦锦金
 * @date 2017年10月23日
 */
public class CellButton extends JButton {
	private static final long serialVersionUID = -6174014473866979455L;

	private int size_x;// 尺寸x
	private int size_y;// 尺寸y
	private Color backgroundColor;// 背景颜色

	public CellButton(int size_x, int size_y) {
		this(size_x, size_x, Color.BLACK);
	}

	public CellButton(int size_x, int size_y, Color color) {
		this.size_x = size_x;
		this.size_y = size_y;
		this.backgroundColor = color;
		this.init();
	}

	private void init() {
		this.setSize(size_x, size_y);
		this.setBackground(backgroundColor);
	}
	
	/**
	 * 刷新单元格
	 */
	public void update() {
		this.init();
	}


}
