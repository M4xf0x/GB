package de.m4xf0x.cmd;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import de.m4xf0x.gb.Main;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;

public class web implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {

			Player p = (Player) sender;
			String s = Main.i.getConfig().getString("Website");
			String json = "{text:\"" + Main.p
					+ "Die Website findet ihr hier: \",extra:[{text:\"§8*click*\",clickEvent:{action:open_url,value:\"" + s
					+ "\"}}]}";

			PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a(json), true);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);

			p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 10, 1);

		}

		return false;
	}

}
