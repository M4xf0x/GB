package de.m4xf0x.deathmatch;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.m4xf0x.gb.Main;

public class Deathmatch {

	public static boolean build;
	static boolean TempBuild = true;
	static boolean noMove;
	static boolean running;
	public static boolean active;
	static int tiC = 0;
	public static int TID = 0;

	public static void delay() {

		Main.println("Deathmatch - delay");

		Bukkit.broadcastMessage(Main.p + "Das Deathmatch startet! In 5 Minuten werdet ihr in die Mitte teleportiert");
		TID = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.i, new Runnable() {

			@Override
			public void run() {
				countdown();

			}
		}, 5800);

	}

	public static void countdown() {

		Main.println("Deathmatch - countdown");

		tiC = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.i, new Runnable() {

			int count = 11;

			@Override
			public void run() {

				count--;
				Bukkit.broadcastMessage(Main.p + "Ihr werdet in " + count + " Sekunden teleportiert!");

				if (count <= 0) {
					Bukkit.broadcastMessage(Main.p + "Ihr werdet jetzt in die Mitte teleportiert");
					stopCountdown();
					fountainTP();
				}
			}
		}, 0, 20);

	}

	static void stopCountdown() {

		Main.println("Deathmatch - stopCountdown");

		Bukkit.getScheduler().cancelTask(tiC);

	}

	static void fountainTP() {
		
		// TODO Teleport Player to the Middle

		noMove = true;
		
		noMove = false;
		
		start();
		
	}
	
	public static void start() {

		Main.println("Deathmatch - start");
		
		Bukkit.broadcastMessage(Main.p + "Ihr habt nun 15 Minuten in der Mitte");

		TempBuild = build;
		running = true;

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.i, new Runnable() {

			@Override
			public void run() {

				endDeathmatch();
				running = false;

			}
		}, 18000);
	}

	@SuppressWarnings("deprecation")
	static void endDeathmatch() {

		Main.println("Deathmatch - endDeathmatch");

		TempBuild = true;

		for (Player all : Bukkit.getOnlinePlayers()) {
			
			all.setAllowFlight(false);
			all.setFlying(false);

		}

	}

	public static void load() {

		Main.println("Deathmatch - load");

		build = Main.i.getConfig().getBoolean("Deathmatch.Build");
		active = Main.i.getConfig().getBoolean("Deathmatch.Active");

	}

	public static void saveBuild() {

		Main.println("Deathmatch - saveBuild");

		Main.i.getConfig().set("Deathmatch.Build", build);
		Main.i.saveConfig();

	}

	public static void saveActive() {

		Main.println("Deathmatch - saveActive");

		Main.i.getConfig().set("Deathmatch.Active", active);
		Main.i.saveConfig();

	}

}
