package de.m4xf0x.msi;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import net.md_5.bungee.api.ChatColor;

public class ConsoleMessage {

	String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "MySQLInventory" + ChatColor.DARK_GRAY + "]"
			+ ChatColor.GREEN + " ";

	public ConsoleMessage(String Message) {

		ConsoleCommandSender cs = Bukkit.getConsoleSender();

		cs.sendMessage(prefix + Message);

	}

}
