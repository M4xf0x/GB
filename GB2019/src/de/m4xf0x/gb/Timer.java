package de.m4xf0x.gb;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Timer {

	public static int TID;
	public static int Time;
	private static int DMTime;

	public static void start() {
		
		Main.println("Timer - start");
		
		DMTime = (int) (Math.random() * ((200 - 30) + 1));
		saveDeathmatchTime();

		TID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.i, new Runnable() {

			@SuppressWarnings("deprecation")
			@Override
			public void run() {

				Time++;
				saveMatchTime();

				if (DMTime == Time) {

					// startDeathmatch

				}

				WebEdit.editWebAndSave();

				for (Player all : Bukkit.getOnlinePlayers()) {
					Sideboard.doScoreboard(all);
				}
			}

		}, 0L, 1200L);
	}

	public static void load() {
		
		Main.println("Timer - load");

		Time = Main.i.getConfig().getInt("Match.Time");
		DMTime = Main.i.getConfig().getInt("Deathmatch.Time");

	}

	private static void saveMatchTime() {
		
		Main.println("Timer - saveMatchTime");

		Main.i.getConfig().set("Match.Time", Time);
		Main.i.saveConfig();

	}

	private static void saveDeathmatchTime() {
		
		Main.println("Timer - saveDeathmatchTime");

		Main.i.getConfig().set("Deathmatch.Time", DMTime);
		Main.i.saveConfig();

	}
}
