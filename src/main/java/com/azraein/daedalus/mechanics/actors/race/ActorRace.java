package com.azraein.daedalus.mechanics.actors.race;

import com.azraein.daedalus.mechanics.actors.Stats.Ability;

public abstract class ActorRace {

	private String actorRaceId, actorRaceName, actorRaceDescription;
	private int[] actorRaceAblInc;

	public ActorRace(String actorRaceId, String actorRaceName, String actorRaceDescription) {
		this.actorRaceId = actorRaceId;
		this.actorRaceName = actorRaceName;
		this.actorRaceDescription = actorRaceDescription;

		actorRaceAblInc = new int[Ability.values().length];
	}

	public void setRaceAblInc(Ability abl, int value) {
		actorRaceAblInc[abl.ordinal()] = value;
	}

	public int getRaceAblInc(Ability abl) {
		return actorRaceAblInc[abl.ordinal()];
	}

	public int[] getActorRaceAblInc() {
		return actorRaceAblInc;
	}

	public String getActorRaceId() {
		return actorRaceId;
	}

	public String getActorRaceName() {
		return actorRaceName;
	}

	public String getActorRaceDescription() {
		return actorRaceDescription;
	}

}
