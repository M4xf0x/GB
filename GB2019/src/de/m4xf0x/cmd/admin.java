package de.m4xf0x.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.m4xf0x.gb.Lifes;
import de.m4xf0x.gb.Main;
import de.m4xf0x.gb.Spawns;
import de.m4xf0x.gb.Teams;

public class admin implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		if (sender instanceof Player && sender.isOp()) {
			Player p = (Player) sender;

			if (args[0].equalsIgnoreCase("addLifes")) {
				addLifes(args, p);

			} else if (args[0].equalsIgnoreCase("removeLifes")) {
				removeLifes(args, p);

			} else if (args[0].equalsIgnoreCase("setLifes")) {
				setLifes(args, p);

			} else if (args[0].equalsIgnoreCase("setTeam")) {
				setTeam(args, p);
				
			} else if (args[0].equalsIgnoreCase("setSpawn")) {
				setSpawn(args, p);
				
			}
		}

		return false;
	}

	private void addLifes(String[] args, Player p) {
		try {

			int teamNumber = Integer.parseInt(args[1]);
			int amount = Integer.parseInt(args[2]);

			Lifes.add(teamNumber, amount);

			p.sendMessage(Main.p + "Team" + args[1] + " " + args[2] + " Leben gegeben");
			p.sendMessage(Main.p + "Neues Level: " + Lifes.get(teamNumber));

		} catch (Exception ex) {
			ex.printStackTrace();
			p.sendMessage("§c/admin addLifes <teamNumber> <amount>");
		}
	}

	private void removeLifes(String[] args, Player p) {
		try {

			int teamNumber = Integer.parseInt(args[1]);
			int amount = Integer.parseInt(args[2]);

			Lifes.remove(teamNumber, amount);

			p.sendMessage(Main.p + "Team" + args[1] + " " + args[2] + " Leben abgezogen");
			p.sendMessage(Main.p + "Neues Level: " + Lifes.get(teamNumber));

		} catch (Exception ex) {
			ex.printStackTrace();
			p.sendMessage("§c/admin removeLifes <teamNumber> <amount>");
		}
	}

	private void setLifes(String[] args, Player p) {
		try {

			int teamNumber = Integer.parseInt(args[1]);
			int amount = Integer.parseInt(args[2]);

			Lifes.set(teamNumber, amount);

			p.sendMessage(Main.p + "Team" + args[1] + " auf " + args[2] + " Leben gesetzt");

		} catch (Exception ex) {
			ex.printStackTrace();
			p.sendMessage("§c/admin setLifes <teamNumber> <amount>");
		}
	}

	private void setTeam(String[] args, Player p) {
		try {
			
			Player target = Bukkit.getPlayer(args[1]);
			
			Teams.load();
			
			if (args[2].equalsIgnoreCase("1") || args[2].equalsIgnoreCase("red")) {

				if (Teams.green.contains(target)) {
					System.out.println("Removing " + args[1] + " from Team Green");
					Teams.green.remove(target);
					Teams.save();
				}

				if (Teams.blue.contains(target)) {
					System.out.println("Removing " + args[1] + " from Team Blue");
					Teams.blue.remove(target);
					Teams.save();
				}

				if (!Teams.red.contains(target)) {
					Teams.red.add(target);
					p.sendMessage(Main.p + "" + target.getName() + " in Team " + args[2] + " gesetzt");

				} else {
					p.sendMessage("§c" + target.getName() + " ist bereits in diesem Team");
				}
			} else if (args[2].equalsIgnoreCase("2") || args[2].equalsIgnoreCase("green")) {

				if (Teams.red.contains(target)) {
					System.out.println("Removing " + args[1] + " from Team Red");
					Teams.red.remove(target);
					Teams.save();
				}

				if (Teams.blue.contains(target)) {
					System.out.println("Removing " + args[1] + " from Team Blue");
					Teams.blue.remove(target);
					Teams.save();
				}

				if (!Teams.green.contains(target)) {
					Teams.green.add(target);
					p.sendMessage(Main.p + "" + target.getName() + " in Team " + args[2] + " gesetzt");

				} else {
					p.sendMessage("§c" + target.getName() + " ist bereits in diesem Team");
				}
			} else if (args[2].equalsIgnoreCase("3") || args[2].equalsIgnoreCase("blue")) {

				if (Teams.red.contains(target)) {
					System.out.println("Removing " + args[1] + " from Team Red");
					Teams.red.remove(target);
					Teams.save();
				}

				if (Teams.green.contains(target)) {
					System.out.println("Removing " + args[1] + " from Team Green");
					Teams.green.remove(target);
					Teams.save();
				}

				if (!Teams.blue.contains(target)) {
					Teams.blue.add(target);
					p.sendMessage(Main.p + "" + target.getName() + " in Team " + args[2] + " gesetzt");

				} else {
					p.sendMessage("§c" + target.getName() + " ist bereits in diesem Team");
				}
			} else {
				p.sendMessage("§c/admin setTeam <Player> <Team>");
			}

			Teams.save();

		} catch (Exception ex) {
			ex.printStackTrace();
			p.sendMessage("§c/admin setTeam <Player> <Team>");
		}
	}
	
	private void setSpawn(String[] args, Player p) {
		try {
			
			if (args[1].equalsIgnoreCase("1") || args[1].equalsIgnoreCase("red")) {
				
				Spawns.ready[0] = true;
				Spawns.spawns[0] = p.getLocation();
				Spawns.save();
				
			} else if (args[1].equalsIgnoreCase("2") || args[1].equalsIgnoreCase("green")) {
				
				Spawns.ready[1] = true;
				Spawns.spawns[1] = p.getLocation();
				Spawns.save();
				
			} else if (args[1].equalsIgnoreCase("3") || args[1].equalsIgnoreCase("blue")) {
				
				Spawns.ready[2] = true;
				Spawns.spawns[2] = p.getLocation();
				Spawns.save();
				
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
