package com.jin.life;

/**
 * @describe 细胞状态枚举
 * @author 锦锦金
 * @date 2017年10月23日
 */
public enum CellEnums {

	LIVE(1, "live"), DEAD(0, "dead");

	private int status_code;// 细胞生命状态码
	private String status_describe;// 细胞生命状态描述

	private CellEnums(int status_code, String status_describe) {
		this.status_code = status_code;
		this.status_describe = status_describe;
	}

	public int getStatus_code() {
		return status_code;
	}

	public String getStatus_describe() {
		return status_describe;
	}

}
