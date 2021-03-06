package de.m4xf0x.gb;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.m4xf0x.cmd.admin;
import de.m4xf0x.cmd.challenge;
import de.m4xf0x.cmd.web;
import de.m4xf0x.deathmatch.DMCommand;
import de.m4xf0x.deathmatch.DMEvents;
import de.m4xf0x.values.Teams;


public class Main extends JavaPlugin {
	
	public static Main i;
	public static String p = " �8[�3System�8] �7";
	public static String consoleP = "�8[�3System�8] " + org.bukkit.ChatColor.RESET;
	
	public void onEnable() {
		i = this;
		
		loadCfg();
		
		PluginManager pm = Bukkit.getPluginManager();
		
		getCommand("admin").setExecutor(new admin());
		getCommand("web").setExecutor(new web());
		getCommand("challenge").setExecutor(new challenge());
		getCommand("dm").setExecutor(new DMCommand());
		pm.registerEvents(new Events(), this);
		pm.registerEvents(new DMEvents(), this);
		
		Timer.Time = 0;
		Timer.start();
		
		Teams.load();
	}
	
	public void loadCfg() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public static void println(String msg) {
		Bukkit.getConsoleSender().sendMessage(consoleP + msg);
	}
	
}
