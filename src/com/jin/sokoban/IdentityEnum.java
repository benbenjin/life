package com.jin.sokoban;

/**
 * @describe 节点身份枚举
 * @author 锦锦金
 *
 */
public enum IdentityEnum {

	BLOCK(1,"block"),MAN(3, "man"), TERMINAL(4, "terminal"), BOX(2, "box");

	private String identity_value;
	int identity_code;

	private IdentityEnum(int identity_code, String identity_value) {
		this.identity_code = identity_code;
		this.identity_value = identity_value;
	}

	public String getIdentity_value() {
		return identity_value;
	}

	public void setIdentity_value(String identity_value) {
		this.identity_value = identity_value;
	}

}
