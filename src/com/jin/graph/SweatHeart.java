package com.jin.graph;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SweatHeart extends JFrame implements Runnable {

	// 定义加载窗口大小
	public static final int GAME_WIDTH = 500;
	public static final int GAME_HEIGHT = 500;
	// 获取屏幕窗口大小
	public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

	public SweatHeart() {
		// 设置窗口标题
		this.setTitle("心形曲线");
		// 设置窗口初始位置
		this.setLocation((WIDTH - GAME_WIDTH) / 2, (HEIGHT - GAME_HEIGHT) / 2);
		// 设置窗口大小
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		// 设置背景色
		this.setBackground(Color.WHITE);
		// 设置窗口关闭方式
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗口显示
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {

		double x, y, r;
		// Image image = createImage(GAME_WIDTH, GAME_HEIGHT);
		Image image = new BufferedImage(GAME_WIDTH, GAME_HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics image_g = image.getGraphics();
		image_g.setColor(Color.WHITE);
		image_g.fill3DRect(0, 0, GAME_WIDTH, GAME_WIDTH, true);
		image_g.setColor(Color.RED);
		// image_g.fillRoundRect(0, 0, 40, 40,10,10);
		// 绘制图像
		drawHeart(image_g, GAME_WIDTH, 0.00001, true);
		// 生成图片
		g.drawImage(image, 0, 0, this);
	}

	public static void main(String[] args) {
		SweatHeart demo = new SweatHeart();
		Thread t = new Thread(demo);
		t.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(2000);
				this.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void drawHeart(Graphics g, int size, double step, boolean fill) {
		g.drawLine(250, 35, 250, 450);
		if (fill)
			drawFillHeart(g);
		else
			drawLineHeart(size, step, g);

	}

	/* 画填充爱心 */
	public void drawFillHeart(Graphics g) {
		int width_max = 100, width = 0, space = 60;
		boolean flag = false;
		for (int i = 0, j = width_max;;) {
			space = ((--space) >= 0 ? space : 0);
			if (i <= width_max && !flag) {
				g.fillRoundRect(GAME_WIDTH / 2 - 2*i - 50, 40 + i, 3*i, 1, 1, 1);

			} else {
				flag = true;
				//g.fillRoundRect(GAME_WIDTH / 2, 40 + i, j, 1, 1, 1);
				j--;
			}
			if (j < 0) {
				break;
			}
			i++;
		}
	}

	/* 画线条爱心 */
	public void drawLineHeart(int size, double step, Graphics g) {
		g = (Graphics2D) g;
		int x1, y1, x2, y2;
		for (double t = -Math.PI; t < Math.PI; t = t + step) {
			g.setColor(Color.black);
			x1 = (int) ((0.5 + (2 * cos(t) - cos(2 * t)) / 8) * size);
			y1 = (int) ((0.5 + (2 * sin(t) - sin(2 * t)) / 8) * size);
			x2 = (int) ((0.5 + (2 * cos(t + step) - cos(2 * (t + step))) / 8) * size);
			y2 = (int) ((0.5 + (2 * sin(t + step) - sin(2 * (t + step))) / 8) * size);
			// 原曲线是横向的，为求美观调整了输出把它画成纵向，若画其他 函数须修改
			g.drawLine(y1, size - x1, y2, size - x2);

		}
	}

}