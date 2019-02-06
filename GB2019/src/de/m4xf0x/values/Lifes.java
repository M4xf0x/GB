package de.m4xf0x.values;

import org.bukkit.configuration.file.FileConfiguration;

import de.m4xf0x.gb.Main;

public class Lifes {
	
	public static int[] TeamLifes = new int[3];
	
	public static void load() {	
		Main.println("Lifes - load");
		
		FileConfiguration cfg = Main.i.getConfig();
		
		TeamLifes[0] = cfg.getInt("Lifes.Team1");
		TeamLifes[1] = cfg.getInt("Lifes.Team2");
		TeamLifes[2] = cfg.getInt("Lifes.Team3");
	}
	
	public static void save() {
		Main.println("Lifes - save");
		
		FileConfiguration cfg = Main.i.getConfig();
		
		cfg.set("Lifes.Team1", TeamLifes[0]);
		cfg.set("Lifes.Team2", TeamLifes[1]);
		cfg.set("Lifes.Team3", TeamLifes[2]);
		
		Main.i.saveConfig();
	}
	
	public static void add(int teamNumber, int amount) {
		Main.println("Lifes - add");
		
		load();
		
		TeamLifes[teamNumber - 1] = TeamLifes[teamNumber - 1] + amount;
		
		save();
		
	}
	
	public static void remove(int teamNumber, int amount) {
		Main.println("Lifes - remove");
		
		load();
		
		TeamLifes[teamNumber - 1] = TeamLifes[teamNumber - 1] - amount;
		
		save();	
	}
	
	public static void set(int teamNumber, int amount) {
		Main.println("Lifes - set");
		
		load();
		
		TeamLifes[teamNumber - 1] = amount;
		
		save();
	}
	
	public static int get(int teamNumber) {
		Main.println("Lifes - get");
		
		load();
		
		return TeamLifes[teamNumber - 1];
		
	}
	
}
