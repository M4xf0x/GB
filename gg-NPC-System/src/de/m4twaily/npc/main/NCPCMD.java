package de.m4twaily.npc.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NCPCMD implements CommandExecutor {

	NPC npc;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (p.hasPermission("gg.npc")) {

				if (args.length == 1) {

					if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("2")) {

						npc = Main.npc;

						npc.setNPCValues(p, Integer.parseInt(args[0]));
						npc.sendPackets(p);

						p.sendMessage(" ");
						p.sendMessage("§a§lNPC §8» §7NPC Nummer " + args[0] + " wurde gesetzt.");
						p.sendMessage(" ");

					} else {

						p.sendMessage(" ");
						p.sendMessage("§a§lNPC §8» §cUsage: /npc 1/2");
						p.sendMessage(" ");

					}
				} else {

					p.sendMessage(" ");
					p.sendMessage("§a§lNPC §8» §cUsage: /npc 1/2");
					p.sendMessage(" ");

				}
			}
		}

		return false;
	}

}
