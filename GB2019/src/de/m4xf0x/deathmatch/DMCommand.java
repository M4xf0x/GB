package de.m4xf0x.deathmatch;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DMCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if (sender.isOp()) {
			
			if (args[0].equalsIgnoreCase("setspawn")) {
				
				if (args[1].equalsIgnoreCase("1")) {

					DMSpawns.ready[0] = true;
					DMSpawns.DMSpawns[0] = p.getLocation();
					DMSpawns.save();

				} else if (args[1].equalsIgnoreCase("2")) {

					DMSpawns.ready[1] = true;
					DMSpawns.DMSpawns[1] = p.getLocation();
					DMSpawns.save();

				} else if (args[1].equalsIgnoreCase("3")) {

					DMSpawns.ready[2] = true;
					DMSpawns.DMSpawns[2] = p.getLocation();
					DMSpawns.save();

				} else if (args[1].equalsIgnoreCase("0")) {

					DMSpawns.ready[3] = true;
					DMSpawns.DMSpawns[3] = p.getLocation();
					DMSpawns.save();

				}
				
			}	
		}		
		return false;
	}

}
