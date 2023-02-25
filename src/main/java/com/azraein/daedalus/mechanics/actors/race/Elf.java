package com.azraein.daedalus.mechanics.actors.race;

import com.azraein.daedalus.mechanics.actors.Stats.Ability;

public class Elf extends ActorRace {

	public Elf() {
		super("elfRace", "Elf", "");

		setRaceAblInc(Ability.DEX, 2);
		setRaceAblInc(Ability.INT, 1);
		setRaceAblInc(Ability.WIS, 1);
		setRaceAblInc(Ability.CHA, 1);
	}

}
