package de.m4xf0x.deathmatch;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import de.m4xf0x.gb.Main;
import de.m4xf0x.values.Teams;

public class Deathmatch {

	public static boolean build;
	static boolean TempBuild = true;
	static boolean noMove;
	static boolean running;
	public static boolean active;
	static int tiC = 0;
	static Location fountainLoc;
	static int fountainID = 0;
	static int fountainState = 0;
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

				if (count <= 1) {
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

	static void stopFountain() {

		Main.println("Deathmatch - stopFountain");

		Bukkit.getScheduler().cancelTask(fountainID);

	}

	@SuppressWarnings("deprecation")
	static void fountainTP() {
		running = true;

		Player temp = null;

		DMSpawns.load();

		for (Player all : Bukkit.getOnlinePlayers()) {

			if (temp != null) {
				all.hidePlayer(temp);
			}

			all.teleport(DMSpawns.DMSpawns[3]);

			temp = all;
		}

		// noMove = true;

		fountainLoc = DMSpawns.DMSpawns[3].add(-10, 1, 0);

		fountainID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.i, new Runnable() {

			int count = 11;

			@Override
			public void run() {

				count--;
				Bukkit.broadcastMessage(Main.p + "Das Deathmatch beginnt in " + count + " Sekunden!");
				startFountain();

				if (count <= 1) {
					stopFountain();
					noMove = false;

					for (Player all : Bukkit.getOnlinePlayers()) {
						for (Player a : Bukkit.getOnlinePlayers()) {
							all.showPlayer(a);
						}
					}

					start();
				}
			}
		}, 0, 20);
	}

	@SuppressWarnings("deprecation")
	static void startFountain() {

		Material m = Material.STAINED_GLASS;

		FallingBlock fb = fountainLoc.getWorld().spawnFallingBlock(fountainLoc, m, DyeColor.CYAN.getData());

		fb.setVelocity(new Vector(0, 0.9, 0));

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.i, new Runnable() {

			@Override
			public void run() {
				FallingBlock fb2 = fountainLoc.getWorld().spawnFallingBlock(fountainLoc, m, DyeColor.CYAN.getData());
				fb2.setVelocity(new Vector(0, 0.8, 0));
				fb.setVelocity(new Vector(0.1, 0, 0));
			}
		}, 5);

		FallingBlock fb3 = fountainLoc.getWorld().spawnFallingBlock(fountainLoc, m, DyeColor.CYAN.getData());
		fb3.setVelocity(new Vector(0, 0.8, 0));

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.i, new Runnable() {

			@Override
			public void run() {
				FallingBlock fb2 = fountainLoc.getWorld().spawnFallingBlock(fountainLoc, m, DyeColor.CYAN.getData());
				fb2.setVelocity(new Vector(0, 0.8, 0));
				fb3.setVelocity(new Vector(0, 0, 0.1));
			}
		}, 5);

		FallingBlock fb2 = fountainLoc.getWorld().spawnFallingBlock(fountainLoc, m, DyeColor.CYAN.getData());
		fb2.setVelocity(new Vector(0, 1, 0));

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.i, new Runnable() {

			@Override
			public void run() {
				FallingBlock fb666 = fountainLoc.getWorld().spawnFallingBlock(fountainLoc, m, DyeColor.CYAN.getData());
				fb666.setVelocity(new Vector(0, 0.8, 0));
				fb2.setVelocity(new Vector(-0.1, 0, 0));
			}
		}, 5);

		FallingBlock fb4 = fountainLoc.getWorld().spawnFallingBlock(fountainLoc, m, DyeColor.CYAN.getData());
		fb4.setVelocity(new Vector(0, 0.9, 0));

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.i, new Runnable() {

			@Override
			public void run() {
				FallingBlock fb2 = fountainLoc.getWorld().spawnFallingBlock(fountainLoc, m, DyeColor.CYAN.getData());
				fb2.setVelocity(new Vector(0, 0.8, 0));
				fb4.setVelocity(new Vector(0, 0, -0.1));
				fountainState = 0;

			}
		}, 5);
	}

	@SuppressWarnings("deprecation")
	public static void start() {

		Main.println("Deathmatch - start");

		for (Player a : Bukkit.getOnlinePlayers()) {

			if (Teams.isInTeam(a, 1)) {
				a.teleport(DMSpawns.DMSpawns[0]);

			} else if (Teams.isInTeam(a, 2)) {
				a.teleport(DMSpawns.DMSpawns[1]);

			} else if (Teams.isInTeam(a, 3)) {
				a.teleport(DMSpawns.DMSpawns[2]);

			}

		}

		Bukkit.broadcastMessage(Main.p + "Ihr habt nun 15 Minuten in der Mitte");

		TempBuild = build;

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
