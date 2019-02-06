package de.m4xf0x.values;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import de.m4xf0x.gb.Main;

public class Spawns {

	public static Location[] spawns = new Location[3];
	public static boolean[] ready = new boolean[3];

	public static void save() {
		Main.println("Spawns - save");
		
		FileConfiguration cfg = Main.i.getConfig();

		cfg.set("Spawns.World", spawns[0].getWorld().getName());
		cfg.set("Spawns.Team1.Ready", ready[0]);
		cfg.set("Spawns.Team2.Ready", ready[1]);
		cfg.set("Spawns.Team3.Ready", ready[2]);

		if (ready[0]) {

			cfg.set("Spawns.Team1.x", spawns[0].getX());
			cfg.set("Spawns.Team1.y", spawns[0].getY());
			cfg.set("Spawns.Team1.z", spawns[0].getZ());
			cfg.set("Spawns.Team1.yaw", spawns[0].getYaw());
			cfg.set("Spawns.Team1.pitch", spawns[0].getPitch());

		}
		
		if (ready[1]) {

			cfg.set("Spawns.Team2.x", spawns[1].getX());
			cfg.set("Spawns.Team2.y", spawns[1].getY());
			cfg.set("Spawns.Team2.z", spawns[1].getZ());
			cfg.set("Spawns.Team2.yaw", spawns[1].getYaw());
			cfg.set("Spawns.Team2.pitch", spawns[1].getPitch());

		}
		
		if (ready[2]) {

			cfg.set("Spawns.Team3.x", spawns[2].getX());
			cfg.set("Spawns.Team3.y", spawns[2].getY());
			cfg.set("Spawns.Team3.z", spawns[2].getZ());
			cfg.set("Spawns.Team3.yaw", spawns[2].getYaw());
			cfg.set("Spawns.Team3.pitch", spawns[2].getPitch());

		}

		Main.i.saveConfig();
	}

	public static void load() {
		Main.println("Spawns - load");
		
		FileConfiguration cfg = Main.i.getConfig();

		World w = Bukkit.getWorld(cfg.getString("Spawns.World"));
		double x1 = cfg.getDouble("Spawns.Team1.x");
		double x2 = cfg.getDouble("Spawns.Team2.x");
		double x3 = cfg.getDouble("Spawns.Team3.x");
		double y1 = cfg.getDouble("Spawns.Team1.y");
		double y2 = cfg.getDouble("Spawns.Team2.y");
		double y3 = cfg.getDouble("Spawns.Team3.y");
		double z1 = cfg.getDouble("Spawns.Team1.z");
		double z2 = cfg.getDouble("Spawns.Team2.z");
		double z3 = cfg.getDouble("Spawns.Team3.z");
		float yaw1 = (float) cfg.getDouble("Spawns.Team1.yaw");
		float yaw2 = (float) cfg.getDouble("Spawns.Team2.yaw");
		float yaw3 = (float) cfg.getDouble("Spawns.Team3.yaw");
		float pitch1 = (float) cfg.getDouble("Spawns.Team1.pitch");
		float pitch2 = (float) cfg.getDouble("Spawns.Team2.pitch");
		float pitch3 = (float) cfg.getDouble("Spawns.Team3.pitch");

		ready[0] = cfg.getBoolean("Spawns.Team1.Ready");
		ready[1] = cfg.getBoolean("Spawns.Team2.Ready");
		ready[2] = cfg.getBoolean("Spawns.Team3.Ready");
		spawns[0] = new Location(w, x1, y1, z1, yaw1, pitch1);
		spawns[1] = new Location(w, x2, y2, z2, yaw2, pitch2);
		spawns[2] = new Location(w, x3, y3, z3, yaw3, pitch3);
	}
}
