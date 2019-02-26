package de.m4xf0x.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.m4xf0x.msi.InventorySystem;

public class InventoryCMD implements CommandExecutor {

	String prefix = "§8[§3MySQLInventory§8] ";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			InventorySystem invsys = new InventorySystem();

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("save")) {

					p.sendMessage(prefix + "§aInventar wird gespeichert..");
					
					invsys.saveInv(p);
					
				} else if (args[0].equalsIgnoreCase("load")) {

					p.sendMessage(prefix + "§aInventar wird geladen..");
					
					invsys.loadInv(p);
				}
			} else {
				help(p);
			}
		}

		return false;
	}

	private void help(Player p) {

		p.sendMessage(" §c/inventory load/save");

	}
}
