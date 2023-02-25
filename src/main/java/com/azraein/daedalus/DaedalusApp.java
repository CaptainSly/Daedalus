package com.azraein.daedalus;

import com.azraein.daedalus.mechanics.Dice;
import com.azraein.daedalus.system.GameBus;
import com.azraein.daedalus.system.GameData;
import com.azraein.daedalus.system.Registry;
import com.azraein.daedalus.ui.MainGameBoard;
import com.google.gson.Gson;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DaedalusApp extends Application {

	private BorderPane rootBPane;
	private AnimationTimer gameLoop;

	// -- UI Classes
	private MainGameBoard mainGBoard;

	// -- Mechanic Classes
	public static final Dice DICE = new Dice();
	public static final Gson GSON = new Gson();
	public static final GameBus GAMEBUS = new GameBus();

	@Override
	public void init() throws Exception {
		Registry.registerRaces();
		Registry.registerActors();
		Registry.registerLocations();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		rootBPane = new BorderPane();
		mainGBoard = new MainGameBoard();

		rootBPane.setCenter(mainGBoard);

		mainGBoard.setCurrentLocation(Registry.LOCATION_REGISTRY.get("001TestLocation"));

		// Game Loop
		gameLoop = new AnimationTimer() {

			@Override
			public void handle(long now) {

				// GameBus Stuff
				if (GAMEBUS.getBusData().size() == 0)
					return;
				else {
					for (GameData data : GAMEBUS.getBusData()) {
						switch (data.getGameDataStatus()) {
						case FINISHED:
							GAMEBUS.getBusData().remove(data);
							return;
						case RUNNING:
						default:
							data.run();
							break;
						}
					}
				}

			}
		};

		primaryStage.setScene(new Scene(rootBPane));
		primaryStage.setTitle("Daedalus");
		primaryStage.show();
		gameLoop.start();
	}

}
