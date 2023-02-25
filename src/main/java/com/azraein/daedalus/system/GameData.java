package com.azraein.daedalus.system;

public abstract class GameData {

	public static enum DATA_STATUS {
		RUNNING, FINISHED
	}

	private DATA_STATUS gameDataStatus;

	public GameData() {
		gameDataStatus = DATA_STATUS.RUNNING;
	}

	public abstract void run();

	public void setGameDataStatus(DATA_STATUS status) {
		gameDataStatus = status;
	}
	
	public DATA_STATUS getGameDataStatus() {
		return gameDataStatus;
	}

}
