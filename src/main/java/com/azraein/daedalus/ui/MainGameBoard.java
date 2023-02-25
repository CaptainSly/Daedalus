package com.azraein.daedalus.ui;

import com.azraein.daedalus.mechanics.actors.Npc;
import com.azraein.daedalus.mechanics.actors.Stats.Ability;
import com.azraein.daedalus.mechanics.actors.Stats.Stat;
import com.azraein.daedalus.mechanics.location.Location;

import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Callback;

public class MainGameBoard extends Parent {

	private final BorderPane mgbRootBPane;
	private final TextArea mgbMainTArea;
	private final ListView<Npc> mgbLocalNpcLView;

	private Location currentLocation;

	public MainGameBoard() {
		mgbRootBPane = new BorderPane();
		mgbMainTArea = new TextArea();
		mgbLocalNpcLView = new ListView<>();

		VBox mgbVbox = new VBox();

		mgbLocalNpcLView.setCellFactory(new Callback<ListView<Npc>, ListCell<Npc>>() {

			@Override
			public ListCell<Npc> call(ListView<Npc> param) {
				ListCell<Npc> cell = new ListCell<Npc>() {

					@Override
					protected void updateItem(Npc npc, boolean empty) {
						super.updateItem(npc, empty);

						if (!empty || npc != null) {
							setText(npc.getActorName());
							setTooltip(new Tooltip(npc.getActorDescription()));
						} else {
							setText("");
							setTooltip(null);
						}

					}

				};

				return cell;
			}

		});

		mgbLocalNpcLView.setOnMouseClicked(e -> {
			Npc npc = mgbLocalNpcLView.getSelectionModel().getSelectedItem();

			if (npc != null) {
				Alert alert = new Alert(AlertType.WARNING);

				alert.setTitle("NPC Info Panel");
				alert.setHeaderText(npc.getActorName());

				alert.setGraphic(null);

				String npcInfoPane = npc.getActorRace().getActorRaceName() + "\n" + npc.getActorDescription() + "\n\n";
				npcInfoPane += "HP: " + npc.getActorStat(Stat.HP) + "\nMP: " + npc.getActorStat(Stat.MP) + "\n\n";

				for (int i = 0; i < Ability.values().length; i++)
					npcInfoPane += Ability.values()[i].name() + ": " + npc.getActorAbilityScore(Ability.values()[i])
							+ "\n";

				alert.setContentText(npcInfoPane);
				alert.show();
			}
		});

		mgbVbox.getChildren().add(mgbLocalNpcLView);

		mgbMainTArea.setEditable(false);
		mgbMainTArea.setFont(new Font(13));

		mgbRootBPane.setLeft(mgbVbox);
		mgbRootBPane.setCenter(mgbMainTArea);

		this.getChildren().add(mgbRootBPane);
	}

	public void setCurrentLocation(Location local) {
		currentLocation = local;

		// Update NPC Sidebar
		mgbLocalNpcLView.getItems().clear();
		mgbLocalNpcLView.setItems(FXCollections.observableArrayList(currentLocation.getLocationNpcs()));

		// Update Text Area
		mgbMainTArea.clear();
		mgbMainTArea.setText("~ " + currentLocation.getLocationName() + " ~");
		mgbMainTArea.appendText("\n" + currentLocation.getLocationDescription());
	}

	public TextArea getMGBTextArea() {
		return mgbMainTArea;
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

}
