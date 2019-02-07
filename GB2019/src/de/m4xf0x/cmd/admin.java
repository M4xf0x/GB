package de.m4xf0x.cmd;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.m4xf0x.gb.Main;
import de.m4xf0x.gb.Timer;
import de.m4xf0x.values.Lifes;
import de.m4xf0x.values.Spawns;
import de.m4xf0x.values.Teams;

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

			} else if (args[0].equalsIgnoreCase("startMatch")) {
				startMatch(args, p);

			} else if (args[0].equalsIgnoreCase("setMatchTime")) {
				setMatchTime(args, p);

			} else if (args[0].equalsIgnoreCase("stopMatch")) {
				stopMatch(args, p);

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

				if (Teams.green[0] == target) {
					System.out.println("Removing " + args[1] + " from Team Green 0");
					Teams.green[1] = null;
					Teams.save();

				}

				if (Teams.green[1] == target) {
					System.out.println("Removing " + args[1] + " from Team Green 1");
					Teams.green[1] = null;
					Teams.save();

				}

				if (Teams.blue[0] == target) {
					System.out.println("Removing " + args[1] + " from Team Blue 0");
					Teams.blue[1] = null;
					Teams.save();

				}

				if (Teams.blue[1] == target) {
					System.out.println("Removing " + args[1] + " from Team Blue 1");
					Teams.blue[1] = null;
					Teams.save();

				}

				if (Teams.red[0] != target && Teams.red[1] != target) {

					// TODO Must be edited
					if (Teams.red[0] == null) {
						Teams.red[0] = target;
						Teams.save();

					} else {
						Teams.red[1] = target;
						Teams.save();
					}

					p.sendMessage(Main.p + "" + target.getName() + " in Team " + args[2] + " gesetzt");

				} else {
					p.sendMessage("§c" + target.getName() + " ist bereits in diesem Team");
				}

			} else if (args[2].equalsIgnoreCase("2") || args[2].equalsIgnoreCase("green")) {

				if (Teams.red[0] == target) {
					System.out.println("Removing " + args[1] + " from Team Red 0");
					Teams.red[0] = null;
					Teams.save();

				}

				if (Teams.red[1] == target) {
					System.out.println("Removing " + args[1] + " from Team Red 1");
					Teams.red[1] = null;
					Teams.save();

				}

				if (Teams.blue[0] == target) {
					System.out.println("Removing " + args[1] + " from Team Blue 0");
					Teams.blue[0] = null;
					Teams.save();

				}

				if (Teams.blue[1] == target) {
					System.out.println("Removing " + args[1] + " from Team Blue 1");
					Teams.blue[1] = null;
					Teams.save();

				}

				if (Teams.green[0] != target && Teams.green[1] != target) {

					// TODO Must be edited
					if (Teams.green[0] == null) {
						Teams.green[0] = target;
						Teams.save();

					} else {
						Teams.green[1] = target;
						Teams.save();
					}

					p.sendMessage(Main.p + "" + target.getName() + " in Team " + args[2] + " gesetzt");

				} else {
					p.sendMessage("§c" + target.getName() + " ist bereits in diesem Team");
				}

			} else if (args[2].equalsIgnoreCase("3") || args[2].equalsIgnoreCase("blue")) {

				if (Teams.green[0] == target) {
					System.out.println("Removing " + args[1] + " from Team Green 0");
					Teams.green[0] = null;
					Teams.save();

				}

				if (Teams.green[1] == target) {
					System.out.println("Removing " + args[1] + " from Team Green 1");
					Teams.green[1] = null;
					Teams.save();

				}

				if (Teams.red[0] == target) {
					System.out.println("Removing " + args[1] + " from Team Red 0");
					Teams.red[0] = null;
					Teams.save();

				}

				if (Teams.red[1] == target) {
					System.out.println("Removing " + args[1] + " from Team Red 1");
					Teams.red[1] = null;
					Teams.save();

				}

				if (Teams.blue[0] != target && Teams.blue[1] != target) {

					// TODO Must be edited
					if (Teams.blue[0] == null) {
						Teams.blue[0] = target;
						Teams.save();

					} else {
						Teams.blue[1] = target;
						Teams.save();
					}

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

	@SuppressWarnings("deprecation")
	private void startMatch(String[] args, Player p) {
		try {

			Timer.active = true;
			Timer.saveActive();
			
			Spawns.load();
			
			Bukkit.broadcastMessage(Main.p + "Das Match wurde gestartet! Ihr werdet in eure Basen teleportiert...");
			
			for (Player all : Bukkit.getOnlinePlayers()) {
				
				Location[] locs = Spawns.spawns;
				
				all.playSound(all.getLocation(), Sound.SUCCESSFUL_HIT, 10, 1);

				if (Teams.isInTeam(all, 1)) {

					all.teleport(locs[0]);

				} else if (Teams.isInTeam(all, 2)) {

					all.teleport(locs[1]);

				} else if (Teams.isInTeam(all, 3)) {

					all.teleport(locs[2]);

				}

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void setMatchTime(String[] args, Player p) {
		try {
			
			int amount = Integer.parseInt(args[1]);
			
			Timer.Time = amount;
			Timer.saveMatchTime();
			
			Bukkit.broadcastMessage(Main.p + "Die Match Time wurde auf " + amount + " gesetzt");
				
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
	}
	
	private void stopMatch(String[] args, Player p) {
		try {
			
			Timer.active = false;
			Timer.saveActive();		
			
			Bukkit.broadcastMessage(Main.p + "Das Match wurde gestoppt!");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
