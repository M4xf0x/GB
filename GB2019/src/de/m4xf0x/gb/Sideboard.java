package de.m4xf0x.gb;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import de.m4xf0x.values.Lifes;
import de.m4xf0x.values.Teams;

public class Sideboard {

	@SuppressWarnings("deprecation")
	public static void doScoreboard(Player p) {

		Main.println("Sideboard - doScoreboard");

		Lifes.load();
		Teams.load();

		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("aaa", "bbb");
		obj.setDisplaySlot(org.bukkit.scoreboard.DisplaySlot.SIDEBAR);
		obj.setDisplayName("§c§l   System  ");

		Score spacer01 = obj.getScore(" ");
		spacer01.setScore(13);
		Score level_name = obj.getScore("§cTeam §4§lROT");
		level_name.setScore(12);
		Score rang_name = obj.getScore("§8 » §7" + Lifes.TeamLifes[0] + " Leben");
		rang_name.setScore(11);
		Score spacer02 = obj.getScore("  ");
		spacer02.setScore(10);
		Score level = obj.getScore("§cTeam §2§lGRÜN");
		level.setScore(9);
		Score coins = obj.getScore("§8 » §7" + Lifes.TeamLifes[1] + "§7 Leben");
		coins.setScore(8);
		Score spacer03 = obj.getScore("   ");
		spacer03.setScore(7);
		Score stats_name = obj.getScore("§cTeam §3§lBLAU");
		stats_name.setScore(6);
		Score stats = obj.getScore("§8 »§7 " + Lifes.TeamLifes[2] + " Leben");
		stats.setScore(5);
		Score spacer04 = obj.getScore("    ");
		spacer04.setScore(4);
		Score online_name = obj.getScore("§cMatch Time");
		online_name.setScore(3);
		Score online = obj.getScore("§8 » §7" + Timer.Time + " Min");
		online.setScore(2);
		Score spacer05 = obj.getScore("     ");
		spacer05.setScore(1);

		p.setScoreboard(board);

		Team Red = board.registerNewTeam("15Red");
		Team Green = board.registerNewTeam("16Green");
		Team Blue = board.registerNewTeam("17Blue");
		Team Spieler = board.registerNewTeam("18Spieler");

		Red.setPrefix("§4");
		Green.setPrefix("§2");
		Blue.setPrefix("§3");
		Spieler.setPrefix("§7");

		for (Player a : Bukkit.getOnlinePlayers()) {

			if (Teams.isInTeam(a, 1)) {
				Red.addEntry(a.getName());

			} else if (Teams.isInTeam(a, 2)) {
				Green.addEntry(a.getName());

			} else if (Teams.isInTeam(a, 3)) {
				Blue.addEntry(a.getName());

			} else {
				Spieler.addEntry(a.getName());

			}

		}
	}
}
