package com.azraein.daedalus.mechanics.location;

import java.util.ArrayList;
import java.util.List;

import com.azraein.daedalus.mechanics.actors.Npc;

public class Location {

	public static enum Direction {

		NORTH, SOUTH, EAST, WEST;

		public Direction getOpposite() {
			switch (this) {
			case EAST:
				return WEST;
			default:
			case NORTH:
				return SOUTH;
			case SOUTH:
				return NORTH;
			case WEST:
				return EAST;

			}
		}

	}

	private String locationId, locationName, locationDescription;
	private Location[] connectingLocations;
	private List<Npc> locationNpcs;

	public Location(String locationId, String locationName, String locationDescription) {
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationDescription = locationDescription;

		locationNpcs = new ArrayList<>();

		connectingLocations = new Location[Direction.values().length];
	}

	public void setConnectingLocation(Direction dir, Location local) {
		connectingLocations[dir.ordinal()] = local;

		if (local.getConnectingDirection(dir.getOpposite()) != null)
			return;
		else
			local.getConnectingLocations()[dir.getOpposite().ordinal()] = this;

	}

	public void addNpc(Npc npc) {
		locationNpcs.add(npc);
	}

	public void removeNpc(Npc npc) {
		locationNpcs.remove(locationNpcs.indexOf(npc));
	}

	public List<Npc> getLocationNpcs() {
		return locationNpcs;
	}

	public Location getConnectingDirection(Direction dir) {
		return connectingLocations[dir.ordinal()];
	}

	public String getLocationId() {
		return locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public Location[] getConnectingLocations() {
		return connectingLocations;
	}

}
