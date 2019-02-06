package de.m4xf0x.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.m4xf0x.gb.Main;
import de.m4xf0x.values.Lifes;
import de.m4xf0x.values.Teams;

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

			if (Teams.isInTeam(p, 1)) {
				Lifes.add(1, 1);
				Bukkit.broadcastMessage(Main.p + "§4§l" + p.getName() + " hat eine Challenge geschafft!");
				Bukkit.broadcastMessage(Main.p + "Team §4§lRot §7hat wieder " + Lifes.TeamLifes[0] + " Leben");

			} else if (Teams.isInTeam(p, 2)) {
				Lifes.add(2, 1);
				Bukkit.broadcastMessage(Main.p + "§2§l" + p.getName() + " hat eine Challenge geschafft!");
				Bukkit.broadcastMessage(Main.p + "Team §2§lGrün §7hat wieder " + Lifes.TeamLifes[1] + " Leben");

			} else if (Teams.isInTeam(p, 3)) {
				Lifes.add(3, 1);
				Bukkit.broadcastMessage(Main.p + "§3§l" + p.getName() + " hat eine Challenge geschafft!");
				Bukkit.broadcastMessage(Main.p + "Team §3§lBlau §7hat wieder " + Lifes.TeamLifes[2] + " Leben");
			}
		}
		return false;
	}
}