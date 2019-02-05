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

public class Events implements Listener {

	HashMap<Player, Boolean> spawnProtection = new HashMap<Player, Boolean>();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {

		Main.println("Events - onJoin");

		Player p = e.getPlayer();
		String s = "§7[§a+§7] §8» ";

		Teams.load();

		if (Teams.red.contains(p)) {
			e.setJoinMessage(s + "§4" + p.getName());

		} else if (Teams.green.contains(p)) {
			e.setJoinMessage(s + "§2" + p.getName());

		} else if (Teams.blue.contains(p)) {
			e.setJoinMessage(s + "§3" + p.getName());

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

		if (Teams.red.contains(p)) {
			e.setQuitMessage(s + "§4" + p.getName());

		} else if (Teams.green.contains(p)) {
			e.setQuitMessage(s + "§2" + p.getName());

		} else if (Teams.blue.contains(p)) {
			e.setQuitMessage(s + "§3" + p.getName());

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
			
			if (Teams.red.contains(p)) {
				e.setDeathMessage(Main.p + "§4 " + p.getName() + " ist gestorben");
				Bukkit.broadcastMessage("");

			} else if (Teams.green.contains(p)) {
				e.setDeathMessage(Main.p + "§2 " + p.getName() + " ist gestorben");

			} else if (Teams.blue.contains(p)) {
				e.setDeathMessage(Main.p + "§3 " + p.getName() + " ist gestorben");

			} else {
				e.setDeathMessage(Main.p + "§7 " + p.getName() + " ist gestorben");
			}
			
		} else {

			if (Teams.red.contains(p)) {
				e.setDeathMessage(Main.p + "§4 " + p.getName() + " ist gestorben");

			} else if (Teams.green.contains(p)) {
				e.setDeathMessage(Main.p + "§2 " + p.getName() + " ist gestorben");

			} else if (Teams.blue.contains(p)) {
				e.setDeathMessage(Main.p + "§3 " + p.getName() + " ist gestorben");

			} else {
				e.setDeathMessage(Main.p + "§7 " + p.getName() + " ist gestorben");
			}

		}
	}

}
