package com.azraein.daedalus.mechanics.actors;

import com.azraein.daedalus.DaedalusApp;
import com.azraein.daedalus.mechanics.actors.Stats.Ability;
import com.azraein.daedalus.mechanics.actors.Stats.Stat;
import com.azraein.daedalus.mechanics.actors.race.ActorRace;

/**
 * A Representation of a game "Character" i.e., NPC, Enemy, Player
 */
public abstract class Actor {

	private String actorId, actorName, actorDescription;
	private ActorRace actorRace;
	private int actorLevel;
	private int[] actorStats;
	private int[] actorAbilityScores;

	public Actor(String actorId, String actorName, String actorDescription, ActorRace actorRace) {
		this.actorId = actorId;
		this.actorName = actorName;
		this.actorDescription = actorDescription;

		this.actorRace = actorRace;

		actorLevel = 1;

		actorStats = new int[Stat.values().length];
		actorAbilityScores = new int[Ability.values().length];

		for (int i = 0; i < Ability.values().length; i++)
			actorAbilityScores[i] += actorRace.getActorRaceAblInc()[i];

	}

	public void generateActorStats() {
		// GENERATE ABILITY SCORES |
		// Roll a 2D6 and multiply by 3. Highest = 24 lowest = 4
		for (int i = 0; i < Ability.values().length; i++)
			actorAbilityScores[i] += DaedalusApp.DICE.roll("2d6*2");

		// GENERATE Stats Based off ability scores
		actorStats[Stat.HP.ordinal()] += (int) Math
				.round((actorAbilityScores[Ability.CON.ordinal()] + actorAbilityScores[Ability.DEX.ordinal()]) / 2);
		actorStats[Stat.MP.ordinal()] += (int) Math
				.round((actorAbilityScores[Ability.INT.ordinal()] + actorAbilityScores[Ability.WIS.ordinal()]) / 3);
		actorStats[Stat.XP.ordinal()] += 0; // Starts at the initial 0
	}

	public void setActorStat(Stat stat, int value) {
		actorStats[stat.ordinal()] = value;
	}

	public void setActorAbilityScore(Ability ability, int value) {
		actorAbilityScores[ability.ordinal()] = value;
	}

	public int getActorStat(Stat stat) {
		return actorStats[stat.ordinal()];
	}

	public int getActorAbilityScore(Ability ability) {
		return actorAbilityScores[ability.ordinal()];
	}

	public ActorRace getActorRace() {
		return actorRace;
	}

	public int getActorLevel() {
		return actorLevel;
	}

	public String getActorId() {
		return actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public String getActorDescription() {
		return actorDescription;
	}

	@Override
	public String toString() {
		String actorToString = "{id: " + actorId + ", name: " + actorName + ", desc: " + actorDescription
				+ ", actorRace: " + actorRace.getActorRaceId() + ", level: " + actorLevel + ", ";

		for (int i = 0; i < Ability.values().length; i++)
			actorToString += Ability.values()[i].name().toLowerCase() + ":" + actorAbilityScores[i] + ", ";

		actorToString += "hp: " + actorStats[Stat.HP.ordinal()] + ", ";
		actorToString += "mp: " + actorStats[Stat.MP.ordinal()] + ", ";
		actorToString += "xp: " + actorStats[Stat.XP.ordinal()] + "}";

		return actorToString;
	}


}
