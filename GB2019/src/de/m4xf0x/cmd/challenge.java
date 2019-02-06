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

		passwords[0] = cfg.getString("Challenges.pw1.password");
		passwords[1] = cfg.getString("Challenges.pw2.password");
		passwords[2] = cfg.getString("Challenges.pw3.password");
		passwords[3] = cfg.getString("Challenges.pw4.password");
		passwords[4] = cfg.getString("Challenges.pw5.password");
		passwords[5] = cfg.getString("Challenges.pw6.password");

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		try {

			Main.println("challenge - onCommand");

			Player p = (Player) sender;

			if (args[0].equalsIgnoreCase(passwords[0])) {

				if (Teams.isInTeam(p, 1)) {
					if (!getDone(1, 1)) {
						Lifes.add(1, 1);
						Bukkit.broadcastMessage(Main.p + "§4§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §4§lRot §7hat nun " + Lifes.TeamLifes[0] + " Leben");
						setDone(1, 1);
					}
				} else if (Teams.isInTeam(p, 2)) {
					if (!getDone(2, 1)) {
						Lifes.add(2, 1);
						Bukkit.broadcastMessage(Main.p + "§2§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §2§lGrün §7hat nun " + Lifes.TeamLifes[1] + " Leben");
						setDone(2, 1);
					}
				} else if (Teams.isInTeam(p, 3)) {
					if (!getDone(3, 1)) {
						Lifes.add(3, 1);
						Bukkit.broadcastMessage(Main.p + "§3§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §3§lBlau §7hat nun " + Lifes.TeamLifes[2] + " Leben");
						setDone(3, 1);
					}
				}

			} else if (args[0].equalsIgnoreCase(passwords[1])) {

				if (Teams.isInTeam(p, 1)) {
					if (!getDone(1, 2)) {
						Lifes.add(1, 1);
						Bukkit.broadcastMessage(Main.p + "§4§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §4§lRot §7hat nun " + Lifes.TeamLifes[0] + " Leben");
						setDone(1, 2);
					}
				} else if (Teams.isInTeam(p, 2)) {
					if (!getDone(2, 2)) {
						Lifes.add(2, 1);
						Bukkit.broadcastMessage(Main.p + "§2§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §2§lGrün §7hat nun " + Lifes.TeamLifes[1] + " Leben");
						setDone(2, 2);
					}
				} else if (Teams.isInTeam(p, 3)) {
					if (!getDone(3, 2)) {
						Lifes.add(3, 1);
						Bukkit.broadcastMessage(Main.p + "§3§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §3§lBlau §7hat nun " + Lifes.TeamLifes[2] + " Leben");
						setDone(3, 2);
					}
				}

			} else if (args[0].equalsIgnoreCase(passwords[2])) {

				if (Teams.isInTeam(p, 1)) {
					if (!getDone(1, 3)) {
						Lifes.add(1, 1);
						Bukkit.broadcastMessage(Main.p + "§4§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §4§lRot §7hat nun " + Lifes.TeamLifes[0] + " Leben");
						setDone(1, 3);
					}
				} else if (Teams.isInTeam(p, 2)) {
					if (!getDone(2, 3)) {
						Lifes.add(2, 1);
						Bukkit.broadcastMessage(Main.p + "§2§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §2§lGrün §7hat nun " + Lifes.TeamLifes[1] + " Leben");
						setDone(2, 3);
					}
				} else if (Teams.isInTeam(p, 3)) {
					if (!getDone(3, 3)) {
						Lifes.add(3, 1);
						Bukkit.broadcastMessage(Main.p + "§3§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §3§lBlau §7hat nun " + Lifes.TeamLifes[2] + " Leben");
						setDone(3, 3);
					}
				}

			} else if (args[0].equalsIgnoreCase(passwords[3])) {

				if (Teams.isInTeam(p, 1)) {
					if (!getDone(1, 4)) {
						Lifes.add(1, 1);
						Bukkit.broadcastMessage(Main.p + "§4§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §4§lRot §7hat nun " + Lifes.TeamLifes[0] + " Leben");
						setDone(1, 4);
					}
				} else if (Teams.isInTeam(p, 2)) {
					if (!getDone(2, 4)) {
						Lifes.add(2, 1);
						Bukkit.broadcastMessage(Main.p + "§2§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §2§lGrün §7hat nun " + Lifes.TeamLifes[1] + " Leben");
						setDone(2, 4);
					}
				} else if (Teams.isInTeam(p, 3)) {
					if (!getDone(3, 4)) {
						Lifes.add(3, 1);
						Bukkit.broadcastMessage(Main.p + "§3§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §3§lBlau §7hat nun " + Lifes.TeamLifes[2] + " Leben");
						setDone(3, 4);
					}
				}

			} else if (args[0].equalsIgnoreCase(passwords[4])) {

				if (Teams.isInTeam(p, 1)) {
					if (!getDone(1, 5)) {
						Lifes.add(1, 1);
						Bukkit.broadcastMessage(Main.p + "§4§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §4§lRot §7hat nun " + Lifes.TeamLifes[0] + " Leben");
						setDone(1, 5);
					}
				} else if (Teams.isInTeam(p, 2)) {
					if (!getDone(2, 5)) {
						Lifes.add(2, 1);
						Bukkit.broadcastMessage(Main.p + "§2§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §2§lGrün §7hat nun " + Lifes.TeamLifes[1] + " Leben");
						setDone(2, 5);
					}
				} else if (Teams.isInTeam(p, 3)) {
					if (!getDone(3, 5)) {
						Lifes.add(3, 1);
						Bukkit.broadcastMessage(Main.p + "§3§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §3§lBlau §7hat nun " + Lifes.TeamLifes[2] + " Leben");
						setDone(3, 5);
					}
				}

			} else if (args[0].equalsIgnoreCase(passwords[5])) {

				if (Teams.isInTeam(p, 1)) {
					if (!getDone(1, 6)) {
						Lifes.add(1, 1);
						Bukkit.broadcastMessage(Main.p + "§4§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §4§lRot §7hat nun " + Lifes.TeamLifes[0] + " Leben");
						setDone(1, 6);
					}
				} else if (Teams.isInTeam(p, 2)) {
					if (!getDone(2, 6)) {
						Lifes.add(2, 1);
						Bukkit.broadcastMessage(Main.p + "§2§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §2§lGrün §7hat nun " + Lifes.TeamLifes[1] + " Leben");
						setDone(2, 6);
					}
				} else if (Teams.isInTeam(p, 3)) {
					if (!getDone(3, 6)) {
						Lifes.add(3, 1);
						Bukkit.broadcastMessage(Main.p + "§3§l" + p.getName() + "§7 hat eine Challenge geschafft!");
						Bukkit.broadcastMessage(Main.p + "Team §3§lBlau §7hat nun " + Lifes.TeamLifes[2] + " Leben");
						setDone(3, 6);
					}
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;

	}

	void setDone(int TeamNumber, int Challenge) {

		Main.println("challenge - setDone");

		FileConfiguration cfg = Main.i.getConfig();

		if (TeamNumber == 1) {
			if (Challenge == 1) {
				cfg.set("Challenges.pw1.done1", true);

			} else if (Challenge == 2) {
				cfg.set("Challenges.pw2.done1", true);

			} else if (Challenge == 3) {
				cfg.set("Challenges.pw3.done1", true);

			} else if (Challenge == 4) {
				cfg.set("Challenges.pw4.done1", true);

			} else if (Challenge == 5) {
				cfg.set("Challenges.pw5.done1", true);

			} else if (Challenge == 6) {
				cfg.set("Challenges.pw6.done1", true);

			}

		} else if (TeamNumber == 2) {
			if (Challenge == 1) {
				cfg.set("Challenges.pw1.done2", true);

			} else if (Challenge == 2) {
				cfg.set("Challenges.pw2.done2", true);

			} else if (Challenge == 3) {
				cfg.set("Challenges.pw3.done2", true);

			} else if (Challenge == 4) {
				cfg.set("Challenges.pw4.done2", true);

			} else if (Challenge == 5) {
				cfg.set("Challenges.pw5.done2", true);

			} else if (Challenge == 6) {
				cfg.set("Challenges.pw6.done2", true);

			}

		} else if (TeamNumber == 3) {
			if (Challenge == 1) {
				cfg.set("Challenges.pw1.done3", true);

			} else if (Challenge == 2) {
				cfg.set("Challenges.pw2.done3", true);

			} else if (Challenge == 3) {
				cfg.set("Challenges.pw3.done3", true);

			} else if (Challenge == 4) {
				cfg.set("Challenges.pw4.done3", true);

			} else if (Challenge == 5) {
				cfg.set("Challenges.pw5.done3", true);

			} else if (Challenge == 6) {
				cfg.set("Challenges.pw6.done3", true);

			}

		}

		Main.i.saveConfig();

	}

	boolean getDone(int TeamNumber, int Challenge) {

		FileConfiguration cfg = Main.i.getConfig();

		if (TeamNumber == 1) {
			if (Challenge == 1) {
				return cfg.getBoolean("Challenges.pw1.done1");

			} else if (Challenge == 2) {
				return cfg.getBoolean("Challenges.pw2.done1");

			} else if (Challenge == 3) {
				return cfg.getBoolean("Challenges.pw3.done1");

			} else if (Challenge == 4) {
				return cfg.getBoolean("Challenges.pw4.done1");

			} else if (Challenge == 5) {
				return cfg.getBoolean("Challenges.pw5.done1");

			} else if (Challenge == 6) {
				return cfg.getBoolean("Challenges.pw6.done1");

			}

		} else if (TeamNumber == 2) {
			if (Challenge == 1) {
				return cfg.getBoolean("Challenges.pw1.done2");

			} else if (Challenge == 2) {
				return cfg.getBoolean("Challenges.pw2.done2");

			} else if (Challenge == 3) {
				return cfg.getBoolean("Challenges.pw3.done2");

			} else if (Challenge == 4) {
				return cfg.getBoolean("Challenges.pw4.done2");

			} else if (Challenge == 5) {
				return cfg.getBoolean("Challenges.pw5.done2");

			} else if (Challenge == 6) {
				return cfg.getBoolean("Challenges.pw6.done2");

			}

		} else if (TeamNumber == 3) {
			if (Challenge == 1) {
				return cfg.getBoolean("Challenges.pw1.done3");

			} else if (Challenge == 2) {
				return cfg.getBoolean("Challenges.pw2.done3");

			} else if (Challenge == 3) {
				return cfg.getBoolean("Challenges.pw3.done3");

			} else if (Challenge == 4) {
				return cfg.getBoolean("Challenges.pw4.done3");

			} else if (Challenge == 5) {
				return cfg.getBoolean("Challenges.pw5.done3");

			} else if (Challenge == 6) {
				return cfg.getBoolean("Challenges.pw6.done3");

			}

		}

		return false;
	}
}