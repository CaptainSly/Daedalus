package com.azraein.daedalus.mechanics.actors;

import com.azraein.daedalus.mechanics.actors.race.ActorRace;

public class Npc extends Actor {

	public Npc(String actorId, String actorName, String actorDescription, ActorRace actorRace) {
		super(actorId, actorName, actorDescription, actorRace);
		generateActorStats();
	}

}
