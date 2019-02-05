package de.m4xf0x.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.m4xf0x.gb.Lifes;
import de.m4xf0x.gb.Main;
import de.m4xf0x.gb.Teams;

public class challenge implements CommandExecutor {

	String[] passwords = new String[6];

	public challenge() {

		FileConfiguration cfg = Main.i.getConfig();

		passwords[0] = cfg.getString("Challenges.pw1");
		passwords[1] = cfg.getString("Challenges.pw2");
		passwords[2] = cfg.getString("Challenges.pw3");
		passwords[3] = cfg.getString("Challenges.pw4");
		passwords[4] = cfg.getString("Challenges.pw5");
		passwords[5] = cfg.getString("Challenges.pw6");

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (args[0].equalsIgnoreCase(passwords[0]) || args[0].equalsIgnoreCase(passwords[1])
				|| args[0].equalsIgnoreCase(passwords[2]) || args[0].equalsIgnoreCase(passwords[3])
				|| args[0].equalsIgnoreCase(passwords[4]) || args[0].equalsIgnoreCase(passwords[5])) {
			
			Player p = (Player) sender;
			
			if (Teams.red.contains(p)) {
				Lifes.add(1, 1);
				
			} else if (Teams.green.contains(p)) {
				Lifes.add(2, 1);
				
			} else if (Teams.blue.contains(p)) {
				Lifes.add(3, 1);
			}
			
		}

		return false;
	}
}
