package de.m4xf0x.gb;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Teams {

	public static ArrayList<Player> red = new ArrayList<>();
	public static ArrayList<Player> green = new ArrayList<>();
	public static ArrayList<Player> blue = new ArrayList<>();
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

				cfg.set("Teams.Red.Player1", red.getName());

			} else if (iRed == 2) {

				cfg.set("Teams.Red.Player2", red.getName());

			}
			
			Main.i.saveConfig();

		}

		for (Player green : green) {

			iGreen++;
			
			if (iGreen == 1) {

				cfg.set("Teams.Green.Player1", green.getName());

			} else if (iGreen == 2) {

				cfg.set("Teams.Green.Player2", green.getName());

			}
			
			Main.i.saveConfig();

		}

		for (Player blue : blue) {

			iBlue++;
			
			if (iBlue == 1) {

				cfg.set("Teams.Blue.Player1", blue.getName());

			} else if (iBlue == 2) {

				cfg.set("Teams.Blue.Player2", blue.getName());

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

			ready = cfg.getBoolean("Teams.Ready");

			if (ready) {

				Player red1 = Bukkit.getPlayer(cfg.getString("Teams.Red.Player1"));
				Player red2 = Bukkit.getPlayer(cfg.getString("Teams.Red.Player2"));
				Player green1 = Bukkit.getPlayer(cfg.getString("Teams.Green.Player1"));
				Player green2 = Bukkit.getPlayer(cfg.getString("Teams.Green.Player2"));
				Player blue1 = Bukkit.getPlayer(cfg.getString("Teams.Blue.Player1"));
				Player blue2 = Bukkit.getPlayer(cfg.getString("Teams.Blue.Player2"));

				red.clear();

				if (!red.contains(red1) && red1 != null) {
					red.add(red1);

				}

				if (!red.contains(red2) && red2 != null) {
					red.add(red2);

				}
				if (!green.contains(green1) && green1 != null) {
					green.add(green1);

				}
				if (!green.contains(green2) && green2 != null) {
					green.add(green2);

				}
				if (!blue.contains(blue1) && blue1 != null) {
					blue.add(blue1);

				}
				if (!blue.contains(blue2) && blue2 != null) {
					blue.add(blue2);

				}
			}

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
}
