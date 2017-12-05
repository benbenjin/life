package com.jin.life;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @describe 游戏视图
 * @author 锦锦金
 * @date 2017年10月23日
 */
public class ViewMap extends JFrame {
	private static final long serialVersionUID = -4492606007309655407L;

	// 定义加载窗口大小
	public static final int GAME_WIDTH = 500;
	public static final int GAME_HEIGHT = 500;
	public final int NUM_X;// 细胞视图行数
	public final int NUM_Y;// 细胞视图列数

	// 获取屏幕窗口大小
	public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	// 细胞图
	private JButton[][] lifeMap;

	public ViewMap(LifeMap lifeMap) {
		this.NUM_X = lifeMap.getLifeMap().length;
		this.NUM_Y = lifeMap.getLifeMap()[0].length;
		this.initView(lifeMap);
	}

	private void initView(LifeMap lifeMap) {
		System.out.println("初始化创建界面------------");
		// 设置窗口标题
		this.setTitle("生命游戏");
		// 设置窗口初始位置
		this.setLocation((WIDTH - GAME_WIDTH) / 2, (HEIGHT - GAME_HEIGHT) / 2);
		// 设置窗口大小
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setContainers(lifeMap);
		// 设置背景色
		this.setBackground(Color.WHITE);
		// 设置窗口关闭方式
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗口固定
		this.setResizable(false);
		// 设置窗口显示
		this.setVisible(true);

	}

	/* 设置视图内容组件 */
	private void setContainers(LifeMap lifeMap) {
		this.lifeMap = new JButton[NUM_X][NUM_Y];
		loadLifeMap(lifeMap);
		Container con = this.getContentPane();
		this.setLayout(new GridLayout(NUM_X, NUM_Y, 1, 1)); // 设置num_x行num_y列垂直水平间隔为1
		for (int i = 0; i < NUM_X; i++) {
			for (int j = 0; j < NUM_Y; j++) {
				con.add(this.lifeMap[i][j]);
			}
		}
	}

	/* 装载节点视图内容 */
	private void loadLifeMap(LifeMap lifeMap) {
		for (int i = 0; i < NUM_X; i++) {
			for (int j = 0; j < NUM_Y; j++) {
				Color c = Color.BLACK;
				if (lifeMap.getLifeMap()[i][j].getStatus() == CellEnums.LIVE.getStatus_code())
					c = Color.WHITE;
				if (this.lifeMap[i][j] == null) {// 初始化
					this.lifeMap[i][j] = new CellButton(GAME_WIDTH / lifeMap.getLifeMap().length,
							GAME_WIDTH / lifeMap.getLifeMap()[0].length, c);
				}
				else {// 活动变化
					this.lifeMap[i][j].setBackground(c);
				}
			}
		}
	}

	/* 刷新视图 */
	public void refreshView(LifeMap lifeMap) {
		loadLifeMap(lifeMap);
	}
}
