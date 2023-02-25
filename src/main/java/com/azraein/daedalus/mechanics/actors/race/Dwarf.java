package com.azraein.daedalus.mechanics.actors.race;

import com.azraein.daedalus.mechanics.actors.Stats.Ability;

public class Dwarf extends ActorRace {

	public Dwarf() {
		super("dwarfRace", "Dwarf", "");
		setRaceAblInc(Ability.STR, 2);
		setRaceAblInc(Ability.CON, 2);
		setRaceAblInc(Ability.WIS, 1);
	}
	
}
