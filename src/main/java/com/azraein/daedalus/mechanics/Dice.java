package com.azraein.daedalus.mechanics;

import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.interpreter.DiceInterpreter;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;
import com.bernardomg.tabletop.dice.parser.DiceParser;

public class Dice {

	private final DiceParser parser;
	private RollHistory rolls;
	private final DiceInterpreter<RollHistory> roller;

	public Dice() {
		parser = new DefaultDiceParser();
		roller = new DiceRoller();
	}
	
	public int roll(String notation) {
		rolls = parser.parse(notation, roller);
		return rolls.getTotalRoll();
	}
	
	public DiceParser getParser() {
		return parser;
	}

	public RollHistory getRolls() {
		return rolls;
	}

	public DiceInterpreter<RollHistory> getRoller() {
		return roller;
	}

}
