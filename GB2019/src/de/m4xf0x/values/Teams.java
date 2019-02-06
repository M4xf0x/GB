package de.m4xf0x.values;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.m4xf0x.gb.Main;

public class Teams {

	public static Player[] red = new Player[2];
	public static Player[] green = new Player[2];
	public static Player[] blue = new Player[2];
	public static boolean ready;

	public static void save() {

		Main.println("Teams - save");

		FileConfiguration cfg = Main.i.getConfig();
		int iRed = 0;
		int iGreen = 0;
		int iBlue = 0;

		for (Player red : red) {

			iRed++;

			if (iRed == 1) {

				if (red != null) {
					cfg.set("Teams.Red.Player1", red.getName());

				} else {
					cfg.set("Teams.Red.Player1", "none");
				}

			} else if (iRed == 2) {

				if (red != null) {
					cfg.set("Teams.Red.Player2", red.getName());

				} else {
					cfg.set("Teams.Red.Player2", "none");
				}
			}

			Main.i.saveConfig();

		}

		for (Player green : green) {

			iGreen++;

			if (iGreen == 1) {

				if (green != null) {
					cfg.set("Teams.Green.Player1", green.getName());

				} else {
					cfg.set("Teams.Green.Player1", "none");
				}

			} else if (iGreen == 2) {

				if (green != null) {
					cfg.set("Teams.Green.Player2", green.getName());

				} else {
					cfg.set("Teams.Green.Player2", "none");
				}
			}

			Main.i.saveConfig();

		}

		for (Player blue : blue) {

			iBlue++;

			if (iBlue == 1) {

				if (blue != null) {
					cfg.set("Teams.Blue.Player1", blue.getName());

				} else {
					cfg.set("Teams.Blue.Player1", "none");
				}

			} else if (iBlue == 2) {

				if (blue != null) {
					cfg.set("Teams.Blue.Player2", blue.getName());

				} else {
					cfg.set("Teams.Blue.Player2", "none");
				}
			}

			Main.i.saveConfig();

		}

		ready = true;

		cfg.set("Teams.Ready", ready);

		Main.i.saveConfig();

	}

	public static void load() {
		try {
			Main.println("Teams - load");

			FileConfiguration cfg = Main.i.getConfig();

			Player red1 = Bukkit.getPlayer(cfg.getString("Teams.Red.Player1"));
			Player red2 = Bukkit.getPlayer(cfg.getString("Teams.Red.Player2"));
			Player green1 = Bukkit.getPlayer(cfg.getString("Teams.Green.Player1"));
			Player green2 = Bukkit.getPlayer(cfg.getString("Teams.Green.Player2"));
			Player blue1 = Bukkit.getPlayer(cfg.getString("Teams.Blue.Player1"));
			Player blue2 = Bukkit.getPlayer(cfg.getString("Teams.Blue.Player2"));

			red[0] = red1;
			red[1] = red2;
			green[0] = green1;
			green[1] = green2;
			blue[0] = blue1;
			blue[1] = blue2;

			System.out.println(" ");
			Bukkit.getConsoleSender().sendMessage(Main.consoleP + "Teams - load - localArrayLists");
			System.out.println("Team1: " + red);
			System.out.println("Team2: " + green);
			System.out.println("Team3: " + blue);
			System.out.println(" ");

		} catch (NullPointerException nex) {
			nex.printStackTrace();
		}
	}

	public static boolean isInTeam(Player p, int TeamNumber) {

		switch (TeamNumber) {

		case 1:
			if (red[0] == p || red[1] == p) {
				return true;
			}
			break;
		case 2:
			if (green[0] == p || green[1] == p) {
				return true;
			}
			break;
		case 3:
			if (blue[0] == p || blue[1] == p) {
				return true;
			}
			break;

		}
		return false;
	}
}
