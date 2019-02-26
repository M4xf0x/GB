package de.m4xf0x.msi;

import org.bukkit.plugin.java.JavaPlugin;

import de.m4xf0x.commands.InventoryCMD;

public class MySQLInventory extends JavaPlugin {
	
	public static MySQLInventory instance;
	
	public void onEnable() {
		
		instance = this;
		
		getCommand("Inventory").setExecutor(new InventoryCMD());
		
		new ConsoleMessage("Successfully loaded MySQLInventory");
		
	}
	
}
