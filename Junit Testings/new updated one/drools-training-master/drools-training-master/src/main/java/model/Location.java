package model;

import org.kie.api.definition.type.Position;

public class Location {
	
	@Position(0)
	private String thing;
	@Position(1)
	private String location;
	
	
	
	public Location(){}
	
	public Location(String thing, String location) {
		super();
		this.thing = thing;
		this.location = location;
	}
	
	public String getThing() {
		return thing;
	}
	
	public void setThing(String thing) {
		this.thing = thing;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Location [thing=" + thing + ", location=" + location + "]";
	}
	
	
	
}
