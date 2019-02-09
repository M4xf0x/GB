package de.m4xf0x.deathmatch;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import de.m4xf0x.gb.Main;

public class DMSpawns {
	
	public static Location[] DMSpawns = new Location[4];
	public static boolean[] ready = new boolean[4];

	public static void save() {
		Main.println("DMSpawns - save");
		
		FileConfiguration cfg = Main.i.getConfig();

		cfg.set("DMSpawns.World", DMSpawns[0].getWorld().getName());
		cfg.set("DMSpawns.Team1.Ready", ready[0]);
		cfg.set("DMSpawns.Team2.Ready", ready[1]);
		cfg.set("DMSpawns.Team3.Ready", ready[2]);

		if (ready[0]) {

			cfg.set("DMSpawns.Team1.x", DMSpawns[0].getX());
			cfg.set("DMSpawns.Team1.y", DMSpawns[0].getY());
			cfg.set("DMSpawns.Team1.z", DMSpawns[0].getZ());
			cfg.set("DMSpawns.Team1.yaw", DMSpawns[0].getYaw());
			cfg.set("DMSpawns.Team1.pitch", DMSpawns[0].getPitch());

		}
		
		if (ready[1]) {

			cfg.set("DMSpawns.Team2.x", DMSpawns[1].getX());
			cfg.set("DMSpawns.Team2.y", DMSpawns[1].getY());
			cfg.set("DMSpawns.Team2.z", DMSpawns[1].getZ());
			cfg.set("DMSpawns.Team2.yaw", DMSpawns[1].getYaw());
			cfg.set("DMSpawns.Team2.pitch", DMSpawns[1].getPitch());

		}
		
		if (ready[2]) {

			cfg.set("DMSpawns.Team3.x", DMSpawns[2].getX());
			cfg.set("DMSpawns.Team3.y", DMSpawns[2].getY());
			cfg.set("DMSpawns.Team3.z", DMSpawns[2].getZ());
			cfg.set("DMSpawns.Team3.yaw", DMSpawns[2].getYaw());
			cfg.set("DMSpawns.Team3.pitch", DMSpawns[2].getPitch());

		}
		
		if (ready[3]) {

			cfg.set("DMSpawns.Middle.x", DMSpawns[3].getX());
			cfg.set("DMSpawns.Middle.y", DMSpawns[3].getY());
			cfg.set("DMSpawns.Middle.z", DMSpawns[3].getZ());
			cfg.set("DMSpawns.Middle.yaw", DMSpawns[3].getYaw());
			cfg.set("DMSpawns.Middle.pitch", DMSpawns[3].getPitch());

		}

		Main.i.saveConfig();
	}

	public static void load() {
		Main.println("DMSpawns - load");
		
		FileConfiguration cfg = Main.i.getConfig();

		World w = Bukkit.getWorld(cfg.getString("DMSpawns.World"));
		double x1 = cfg.getDouble("DMSpawns.Team1.x");
		double x2 = cfg.getDouble("DMSpawns.Team2.x");
		double x3 = cfg.getDouble("DMSpawns.Team3.x");
		double y1 = cfg.getDouble("DMSpawns.Team1.y");
		double y2 = cfg.getDouble("DMSpawns.Team2.y");
		double y3 = cfg.getDouble("DMSpawns.Team3.y");
		double z1 = cfg.getDouble("DMSpawns.Team1.z");
		double z2 = cfg.getDouble("DMSpawns.Team2.z");
		double z3 = cfg.getDouble("DMSpawns.Team3.z");
		double x4 = cfg.getDouble("DMSpawns.Middle.x");
		double y4 = cfg.getDouble("DMSpawns.Middle.y");
		double z4 = cfg.getDouble("DMSpawns.Middle.z");
		float yaw1 = (float) cfg.getDouble("DMSpawns.Team1.yaw");
		float yaw2 = (float) cfg.getDouble("DMSpawns.Team2.yaw");
		float yaw3 = (float) cfg.getDouble("DMSpawns.Team3.yaw");
		float yaw4 = (float) cfg.getDouble("DMSpawns.Middle.yaw");
		float pitch1 = (float) cfg.getDouble("DMSpawns.Team1.pitch");
		float pitch2 = (float) cfg.getDouble("DMSpawns.Team2.pitch");
		float pitch3 = (float) cfg.getDouble("DMSpawns.Team3.pitch");
		float pitch4 = (float) cfg.getDouble("DMSpawns.Middle.pitch");

		ready[0] = cfg.getBoolean("DMSpawns.Team1.Ready");
		ready[1] = cfg.getBoolean("DMSpawns.Team2.Ready");
		ready[2] = cfg.getBoolean("DMSpawns.Team3.Ready");
		ready[3] = cfg.getBoolean("DMSpawns.Team3.Ready");
		DMSpawns[0] = new Location(w, x1, y1, z1, yaw1, pitch1);
		DMSpawns[1] = new Location(w, x2, y2, z2, yaw2, pitch2);
		DMSpawns[2] = new Location(w, x3, y3, z3, yaw3, pitch3);
		DMSpawns[3] = new Location(w, x4, y4, z4, yaw4, pitch4);
	}
	
}
