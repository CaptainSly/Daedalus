package com.azraein.daedalus.mechanics.actors.race;

import com.azraein.daedalus.mechanics.actors.Stats.Ability;

public class Human extends ActorRace {

	public Human() {
		super("humanRace", "Human", "");

		for (int i = 0; i < Ability.values().length; i++)
			getActorRaceAblInc()[i] = 1;
	}

}
