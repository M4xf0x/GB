package de.m4xf0x.deathmatch;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import de.m4xf0x.gb.Main;

public class DMEvents implements Listener {

	@EventHandler
	public void onBuild(BlockPlaceEvent e) {

		if (!Deathmatch.TempBuild) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {

		if (!Deathmatch.TempBuild) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onMove(PlayerMoveEvent e) {

		if (Deathmatch.noMove) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onDeath(PlayerRespawnEvent e) {
		Player p = e.getPlayer();

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.i, new Runnable() {

			@Override
			public void run() {

				if (Deathmatch.running) {
					p.setAllowFlight(true);
					p.setFlying(true);

					// TODO e.setRespawnLocation(DMSpawns);

				}
			}
		}, 20);
	}
}
