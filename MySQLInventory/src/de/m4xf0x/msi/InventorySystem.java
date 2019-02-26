package de.m4xf0x.msi;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import de.m4xf0x.msi.AsyncMySQL.Callback;

public class InventorySystem implements Listener {

	AsyncMySQL mysql;
	String prefix = "§8[§3MySQLInventory§8] ";
	
	@SuppressWarnings("deprecation")
	public void saveInv(Player p) {

		String[] items = new String[36];
		String[] datas = new String[36];
		String[] amounts = new String[36];

		for (int i = 0; i < 36; i++) {

			if (p.getInventory().getItem(i) != null) {

				items[i] = p.getInventory().getItem(i).getType().name();
				datas[i] = Byte.toString(p.getInventory().getItem(i).getData().getData());
				amounts[i] = Integer.toString(p.getInventory().getItem(i).getAmount());

			} else {
				items[i] = "none";
				datas[i] = "none";
				amounts[i] = "none";
			}
		}

		String endItems = "";

		for (int i = 0; i < items.length; i++) {

			endItems += items[i] + ", ";

		}

		String endDatas = "";

		for (int i = 0; i < datas.length; i++) {

			endDatas += datas[i] + ", ";

		}

		String endAmounts = "";

		for (int i = 0; i < amounts.length; i++) {

			endAmounts += amounts[i] + ", ";

		}

		if (mysql == null) {
			mysql = new AsyncMySQL();
			mysql.connect();
		}

		mysql.save(p.getUniqueId(), endItems, endAmounts, endDatas);
		
		p.playSound(p.getLocation(), Sound.CLICK, 10, 1);
		p.sendMessage(prefix + "§aInventar erfolgreich gespeichert");

	}
	
	public void loadInv(Player p) {
		if (mysql == null) {
			mysql = new AsyncMySQL();

			mysql.connect();
		}

		mysql.load(p.getUniqueId(), new Callback<String[], String[], String[]>() {

			@Override
			public void onSuccessfull(String[] mat, String[] amo, String[] dat) {
				
				for (int i = 0; i < 36; i++) {

					if (!mat[i].equalsIgnoreCase("none")) {

						Material m = Material.getMaterial(mat[i]);
						int amount = Integer.parseInt(amo[i]);
						ItemStack is;

						if (!dat[i].equalsIgnoreCase("none")) {

							is = new ItemStack(m, amount, Byte.parseByte(dat[i]));

						} else {

							is = new ItemStack(m, amount);

						}

						p.getInventory().setItem(i, is);
					}
				}
				
				p.sendMessage(prefix + "§aInventar erfolgreich geladen");
				p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 10, 1);
			}
		});
	}
}
