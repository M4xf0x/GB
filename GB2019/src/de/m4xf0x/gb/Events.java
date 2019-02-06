package de.m4xf0x.gb;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import de.m4xf0x.values.Lifes;
import de.m4xf0x.values.Teams;

public class Events implements Listener {

	HashMap<Player, Boolean> spawnProtection = new HashMap<Player, Boolean>();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {

		Main.println("Events - onJoin");

		Player p = e.getPlayer();
		String s = "§7[§a+§7] §8» ";

		Teams.load();

		if (Teams.isInTeam(p, 1)) {
			e.setJoinMessage(s + "§4§l" + p.getName());

		} else if (Teams.isInTeam(p, 2)) {
			e.setJoinMessage(s + "§2§l" + p.getName());

		} else if (Teams.isInTeam(p, 3)) {
			e.setJoinMessage(s + "§3§l" + p.getName());

		} else
			e.setJoinMessage(s + "§7" + p.getName());

		for (Player all : Bukkit.getOnlinePlayers()) {
			Sideboard.doScoreboard(all);

		}

		spawnProtection.put(e.getPlayer(), false);

	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {

		Player p = e.getPlayer();
		String s = "§7[§c-§7] §8» ";

		Teams.load();

		if (Teams.isInTeam(p, 1)) {
			e.setQuitMessage(s + "§4§l" + p.getName());

		} else if (Teams.isInTeam(p, 2)) {
			e.setQuitMessage(s + "§2§l" + p.getName());

		} else if (Teams.isInTeam(p, 3)) {
			e.setQuitMessage(s + "§3§l" + p.getName());

		} else {
			e.setQuitMessage(s + "§7" + p.getName());
		}
	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {

		Main.println("Events - onRespawn");

		Player p = e.getPlayer();

		// Normal Shit Here

		spawnProtection.put(p, true);

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.i, new Runnable() {

			@Override
			public void run() {

				spawnProtection.put(p, false);

			}
		}, 200);

	}

	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {

		Main.println("Events - onHit");

		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();

			if (spawnProtection.get(p)) {
				e.setCancelled(true);
			}

			if (e.getDamager() instanceof Player) {
				Player damager = (Player) e.getDamager();

				if (spawnProtection.get(damager)) {
					e.setCancelled(true);
				}
			}

		}
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {

		Player p = e.getEntity();

		if (p.getKiller() instanceof Player) {

			Lifes.load();
			Player killer = p.getKiller();
			String killerName = p.getKiller().getName();

			if (Teams.isInTeam(p, 1)) {

				Lifes.remove(1, 1);

				if (Teams.isInTeam(killer, 1)) {
					e.setDeathMessage(Main.p + "§4§l" + p.getName() + " §7wurde von §4§l" + killerName + " §7getötet");
					Bukkit.broadcastMessage(Main.p + "Team §4§lRot §7hat noch " + Lifes.TeamLifes[0] + " Leben");

				} else if (Teams.isInTeam(killer, 2)) {
					e.setDeathMessage(Main.p + "§4§l" + p.getName() + " §7wurde von §2§l" + killerName + " §7getötet");
					Bukkit.broadcastMessage(Main.p + "Team §4§lRot §7hat noch " + Lifes.TeamLifes[0] + " Leben");

				} else if (Teams.isInTeam(killer, 3)) {
					e.setDeathMessage(Main.p + "§4§l" + p.getName() + " §7wurde von §3§l" + killerName + " §7getötet");
					Bukkit.broadcastMessage(Main.p + "Team §4§lRot §7hat noch " + Lifes.TeamLifes[0] + " Leben");

				}

			} else if (Teams.isInTeam(p, 2)) {

				Lifes.remove(2, 1);

				if (Teams.isInTeam(killer, 1)) {
					e.setDeathMessage(Main.p + "§4§l" + p.getName() + " §7wurde von §4§l" + killerName + " §7getötet");
					Bukkit.broadcastMessage(Main.p + "Team §4§lRot §7hat noch " + Lifes.TeamLifes[1] + " Leben");

				} else if (Teams.isInTeam(killer, 2)) {
					e.setDeathMessage(Main.p + "§4§l" + p.getName() + " §7wurde von §2§l" + killerName + " §7getötet");
					Bukkit.broadcastMessage(Main.p + "Team §4§lRot §7hat noch " + Lifes.TeamLifes[1] + " Leben");

				} else if (Teams.isInTeam(killer, 3)) {
					e.setDeathMessage(Main.p + "§4§l" + p.getName() + " §7wurde von §3§l" + killerName + " §7getötet");
					Bukkit.broadcastMessage(Main.p + "Team §4§lRot §7hat noch " + Lifes.TeamLifes[1] + " Leben");

				}

			} else if (Teams.isInTeam(p, 3)) {

				Lifes.remove(3, 1);

				if (Teams.isInTeam(killer, 1)) {
					e.setDeathMessage(Main.p + "§3§l" + p.getName() + " §7wurde von §4§l" + killerName + " §7getötet");
					Bukkit.broadcastMessage(Main.p + "Team §3§lRot §7hat noch " + Lifes.TeamLifes[2] + " Leben");

				} else if (Teams.isInTeam(killer, 2)) {
					e.setDeathMessage(Main.p + "§3§l" + p.getName() + " §7wurde von §2§l" + killerName + " §7getötet");
					Bukkit.broadcastMessage(Main.p + "Team §3§lRot §7hat noch " + Lifes.TeamLifes[2] + " Leben");

				} else if (Teams.isInTeam(killer, 3)) {
					e.setDeathMessage(Main.p + "§3§l" + p.getName() + " §7wurde von §3§l" + killerName + " §7getötet");
					Bukkit.broadcastMessage(Main.p + "Team §3§lRot §7hat noch " + Lifes.TeamLifes[2] + " Leben");

				}

			} else {
				e.setDeathMessage(Main.p + "§7" + p.getName() + " §7wurde von " + killerName);
			}

		} else {

			if (Teams.isInTeam(p, 1)) {
				e.setDeathMessage(Main.p + "§4§l" + p.getName() + " §7ist gestorben");

			} else if (Teams.isInTeam(p, 2)) {
				e.setDeathMessage(Main.p + "§2§l" + p.getName() + " §7ist gestorben");

			} else if (Teams.isInTeam(p, 3)) {
				e.setDeathMessage(Main.p + "§3§l" + p.getName() + " §7ist gestorben");

			} else {
				e.setDeathMessage(Main.p + "§7 " + p.getName() + " ist gestorben");
			}

		}
	}

}