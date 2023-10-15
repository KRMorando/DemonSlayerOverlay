package demon_slayer;

import java.awt.Color;

import javax.swing.JButton;

public class OniInfo {
	JButton button;
	String rank, name, location;
	Color color;
	
	public OniInfo(JButton button, String rank, String name, String location, Color color) {
		this.button = button;
		this.rank = rank;
		this.name = name;
		this.location = location;
		this.color = color;
	}
	
	public void printInfo() {
		System.out.println("name: " + name);
		System.out.println("location: " + location);
		System.out.println("color: " + color);
	}
}
