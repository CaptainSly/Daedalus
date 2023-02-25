package com.azraein.daedalus.system;

import java.util.HashMap;
import java.util.Map;

import com.azraein.daedalus.mechanics.actors.Npc;
import com.azraein.daedalus.mechanics.actors.race.ActorRace;
import com.azraein.daedalus.mechanics.actors.race.Dwarf;
import com.azraein.daedalus.mechanics.actors.race.Elf;
import com.azraein.daedalus.mechanics.actors.race.Human;
import com.azraein.daedalus.mechanics.location.Location;

public class Registry {

	public static final Map<String, ActorRace> ACTOR_RACE_REGISTRY = new HashMap<>();
	public static final Map<String, Npc> ACTOR_REGISTRY = new HashMap<>();
	public static final Map<String, Location> LOCATION_REGISTRY = new HashMap<>();

	public static void registerRaces() {
		final Dwarf dwarfRace = new Dwarf();
		final Elf elfRace = new Elf();
		final Human humanRace = new Human();

		ACTOR_RACE_REGISTRY.put(dwarfRace.getActorRaceId(), dwarfRace);
		ACTOR_RACE_REGISTRY.put(elfRace.getActorRaceId(), elfRace);
		ACTOR_RACE_REGISTRY.put(humanRace.getActorRaceId(), humanRace);
	}

	public static void registerActors() {
		final Npc testBobNPC = new Npc("001BobTestNPC", "Bob Boberson", "A Default Bob Description",
				ACTOR_RACE_REGISTRY.get("dwarfRace"));

		final Npc testTomNPC = new Npc("002TomTestNPC", "Tom Testerson", "A Default Tom Description",
				ACTOR_RACE_REGISTRY.get("elfRace"));

		ACTOR_REGISTRY.put(testBobNPC.getActorId(), testBobNPC);
		ACTOR_REGISTRY.put(testTomNPC.getActorId(), testTomNPC);
	}

	public static void registerLocations() {
		final Location testLocal = new Location("001TestLocation", "The Test Isles",
				"An Island full of testing Mystery!");

		testLocal.addNpc(ACTOR_REGISTRY.get("001BobTestNPC"));
		testLocal.addNpc(ACTOR_REGISTRY.get("002TomTestNPC"));

		LOCATION_REGISTRY.put(testLocal.getLocationId(), testLocal);
	}

}
