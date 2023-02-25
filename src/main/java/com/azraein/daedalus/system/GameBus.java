package com.azraein.daedalus.system;

import java.util.ArrayList;
import java.util.List;

public class GameBus {

	private List<GameData> busData;

	public GameBus() {
		busData = new ArrayList<>();
	}

	public void addData(GameData data) {
		busData.add(data);
	}

	public List<GameData> getBusData() {
		return busData;
	}

}
