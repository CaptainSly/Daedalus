package com.azraein.daedalus;

import com.azraein.daedalus.system.GameData;

public class RepeatData extends GameData {

	private int timer =10;
	
	String msg;
	
	public RepeatData(String msg) {
		this.msg = msg;
	}
	
	@Override
	public void run() {
		if (timer <= 0) setGameDataStatus(DATA_STATUS.FINISHED);
		
		System.out.println(msg + " " + timer);
		timer--;
	}

}
