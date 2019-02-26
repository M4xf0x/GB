package de.m4xf0x.msi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class AsyncMySQL {

	String host = "localhost";
	String port = "3306";
	String database = "mysqlinventory";
	String username = "lol";
	String password = "lol";
	Connection con;

	public void createTable() {

		PreparedStatement ps;
		try {

			ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS mysqlinventory (UUID VARCHAR(100),Materials VARCHAR(500), Amount VARCHAR(500), Data VARCHAR(500))");

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void connect() {

		if (!isConnected()) {
			try {

				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username,
						password);

				createTable();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public boolean isConnected() {
		return (con == null ? false : true);
	}

	public interface Callback<T, K, J> {
		void onSuccessfull(T mat, K amo, J dat);
	}

	public boolean userExisting(UUID uuid) {
		try {

			PreparedStatement ps = con.prepareStatement("SELECT Materials, Amount, Data FROM mysqlinventory WHERE UUID = ?");

			ps.setString(1, uuid.toString());

			ResultSet rs = ps.executeQuery();

			return rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	public void save(UUID uuid, final String slots, final String amounts, final String datas) {
		new BukkitRunnable() {

			@Override
			public void run() {
				try {
					if (userExisting(uuid)) {

						PreparedStatement ps = con.prepareStatement("UPDATE mysqlinventory SET Materials = ?, Amount = ?, Data = ? WHERE UUID = ?");

						ps.setString(1, slots);
						ps.setString(2, amounts);
						ps.setString(3, datas);
						ps.setString(4, uuid.toString());

						ps.executeUpdate();

					} else {

						PreparedStatement ps = con
								.prepareStatement("INSERT INTO mysqlinventory (UUID, Materials, Amount, Data) VALUES (?,?,?,?)");
						
						ps.setString(4, datas);
						ps.setString(3, amounts);
						ps.setString(2, slots);
						ps.setString(1, uuid.toString());

						ps.executeUpdate();

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}.runTaskAsynchronously(MySQLInventory.instance);
	}

	/** Lukas stinkt **/

	public void load(UUID uuid, Callback<String[], String[], String[]> callback) {

		Bukkit.getScheduler().runTaskAsynchronously(MySQLInventory.instance, new Runnable() {

			@Override
			public void run() {

				try {

					PreparedStatement ps = con.prepareStatement("SELECT Materials, Amount, Data FROM mysqlinventory WHERE UUID = ?");

					ps.setString(1, uuid.toString());
					ResultSet rs = ps.executeQuery();

					Bukkit.getScheduler().runTask(MySQLInventory.instance, new Runnable() {

						@Override
						public void run() {
							try {
								while (rs.next()) {

									callback.onSuccessfull(rs.getString("Materials").split(", "), rs.getString("Amount").split(", "), rs.getString("Data").split(", "));
									
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}

						}
					});

				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
	}

}
