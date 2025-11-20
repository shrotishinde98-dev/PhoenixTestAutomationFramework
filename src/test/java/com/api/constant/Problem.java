package com.api.constant;

public enum Problem {
  Smartphone_is_running_slow(1),Poor_battery_life(2);
	
	int code;

	private Problem(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	
	
}
