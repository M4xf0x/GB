package de.m4xf0x.gb;

import java.io.File;
import java.io.PrintWriter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import de.m4xf0x.values.Lifes;
import de.m4xf0x.values.Teams;

public class WebEdit {

	static File input;

	public static void editWebAndSave() {

		try {

			Main.println("WebEdit - editWebAndSave");

			input = new File("C:/xampp/htdocs/gb/feed.html");
			Document doc = Jsoup.connect("http://localhost/gb/feed.html").get();
			PrintWriter writer = new PrintWriter(input, "UTF-8");

			// Lifes
			Element redLifes = doc.getElementById("LivesRed");
			Element greenLifes = doc.getElementById("LivesGreen");
			Element blueLifes = doc.getElementById("LivesBlue");

			int iRedLifes = Lifes.get(1);
			int iGreenLifes = Lifes.get(2);
			int iBlueLifes = Lifes.get(3);

			redLifes.text(iRedLifes + " Leben");
			greenLifes.text(iGreenLifes + " Leben");
			blueLifes.text(iBlueLifes + " Leben");

			// Resetting Online Players
			doc.getElementById("Red1").text("- ");
			doc.getElementById("Red2").text("- ");
			doc.getElementById("Green1").text("- ");
			doc.getElementById("Green2").text("- ");
			doc.getElementById("Blue1").text("- ");
			doc.getElementById("Blue2").text("- ");

			// Players in Match
			Teams.load();

			int iRed = 0;

			for (Player red : Teams.red) {

				if (red != null) {
					if (iRed < 2) {
						try {
							iRed++;

							System.out.println(iRed);
							System.out.println(red);

							Element redPlayers = doc.getElementById("Red" + iRed);

							redPlayers.text("- " + red.getName());
						} catch (NullPointerException ex) {
							ex.printStackTrace();

							Bukkit.getConsoleSender().sendMessage(Main.consoleP + ChatColor.RED
									+ "ERROR: WebEdit - editWebAndSave - NullPointerException");
						}
					}
				}
			}

			int i = 0;

			for (Player green : Teams.green) {

				if (green != null && i < 2) {

					i++;

					Element redPlayers = doc.getElementById("Green" + i);

					redPlayers.text("- " + green.getName());

				}
			}

			int iBlue = 0;

			for (Player blue : Teams.blue) {

				if (blue != null && iBlue < 2) {

					iBlue++;

					Element redPlayers = doc.getElementById("Blue" + iBlue);

					redPlayers.text("- " + blue.getName());

				}
			}

			// Match Time
			Element time = doc.getElementById("time");

			time.text("Das Match wurde vor " + Timer.Time + " Minuten gestartet");

			writer.write(doc.html());
			writer.flush();
			writer.close();

		} catch (Exception ex) {
			Bukkit.getConsoleSender()
					.sendMessage(Main.consoleP + ChatColor.RED + "ERROR: WebEdit - editWebAndSave - " + ex.getCause());

			ex.printStackTrace();
		}

	}

}
