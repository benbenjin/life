package com.jin.life;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @describe 游戏服务者
 * @author 锦锦金
 * @date 2017年10月23日
 */
public class LifeServer extends TimerTask {
	private LifeMap lifeMap;
	private ViewMap viewMap;
	private LifeActivity lifeActivity;

	public static void main(String[] args) {
		// 创建定时器
		Timer timer = new Timer();
		// 定时器每隔1秒自动执行任务
		timer.schedule(new LifeServer(), 0, 1000 * 1);
	}

	public LifeServer() {
		init();
	}

	private void init() {
		System.out.println("加载数据。。。。。。");
		lifeMap = new LifeMap();
		System.out.println("加载数据。。。。。。完成！");
		System.out.println("加载视图。。。。。。");
		viewMap = new ViewMap(lifeMap);
		System.out.println("加载视图。。。。。。完成！");
		System.out.println("加载规则。。。。。。");
		lifeActivity = new LifeActivity(lifeMap);
		System.out.println("加载规则。。。。。。完成！");
	}

	/* 开始一次活动 */
	private void startActivity() {
		lifeMap = lifeActivity.activityCells();
		viewMap.refreshView(lifeMap);// 刷新视图
		lifeActivity.refresh(lifeMap);// 刷新细胞群活动数据
	}

	@Override
	public void run() {
		System.out.println("轮一次");
		startActivity();
	}
}
