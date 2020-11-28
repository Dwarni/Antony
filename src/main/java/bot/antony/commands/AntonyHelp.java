package bot.antony.commands;

import java.awt.Color;

import bot.antony.Antony;
import bot.antony.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class AntonyHelp implements ServerCommand {

	@Override
	public void performCommand(Member m, TextChannel channel, Message message) {
		
		String[] userMessage = message.getContentDisplay().split(" ");
		
		if(userMessage.length > 1) {
			
			switch(userMessage[1].toLowerCase()) {
			
	        case "changelog":
	        	EmbedBuilder eb = new EmbedBuilder();
	        	eb.setTitle("***Antony - Changelog***"); // title
	    		eb.setColor(new Color(31, 89, 152)); // color of side stripe
	    		eb.setDescription("Hier kannst du nachvollziehen, wie sich Antony weiterentwickelt hat.");
	    		/* TODO make Antony avatar available
	    		 * if(Antony.isProdStage()) {
	    			//Show prod image
	    			eb.setThumbnail(PRODIMAGE);
	    		} else {
	    			//Show test image
	    			eb.setThumbnail(TESTIMAGE);
	    		}*/
	    		eb.addField("26.11.2020 - Version 1.2.0",
	    				"Einige Basis-Funktionalit�ten wurden hinzugef�gt, um den Bot einfacher nutzen zu k�nnen. "
	    				+ "Dazu z�hlt unter anderem das ***!antony*** Kommando, um dem Anwender Informationen zum Bot zur Verf�gung zu stellen. "
	    				+ "Zus�tzlich wurden kleinere Bugs behoben.",
	    				false);
	    		eb.addField("25.11.2020 - Version 1.1.0",
	    				"Ein Gro�teil des Codes wurde umgeschrieben, um eine bessere Ausgangslage f�r neue Funktionen zu bieten.",
	    				false);
	    		eb.addField("20.11.2020 - Version 1.0.0",
	    				"Die ***!sells*** Funktion wurde fertig implementiert und der Bot auf dem Discord Server \"Ameisen an die Macht!\" vorgestellt.",
	    				false);
	    		eb.addField("17.11.2020 - Version 0.0.1",
	    				"Antony wurde bei Discord registriert und erste Test-Funktionen wurden geschrieben.",
	    				false);
	    		eb.setFooter("Version " + Antony.getVersion());
	    		channel.sendMessage(eb.build()).queue();
	            break;
	            
	        default:
				channel.sendMessage(getCommandList().build()).queue();
				break;
				
			}
		} else {
			
			channel.sendMessage(getCommandList().build()).queue();
			
		}
		
	}
	
	private EmbedBuilder getCommandList() {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle("***Antony***"); // title
		eb.setColor(new Color(31, 89, 152)); // color of side stripe
		eb.setDescription("Folgende Befehle k�nnen genutzt werden.");
		/* TODO make Antony avatar available
		 * if(Antony.isProdStage()) {
			//Show prod image
			eb.setThumbnail(PRODIMAGE);
		} else {
			//Show test image
			eb.setThumbnail(TESTIMAGE);
		}*/
		eb.addField("!antony  |  !antony help",
				"Zeigt diese �bersicht an.",
				false);
		eb.addField("!antony changelog",
				"Zeigt den Changelog von Antony an.",
				false);
		eb.addField("!sells",
				"Listet zu der gesuchten Ameisenart alle Shops und zugeh�rigen Preise. Die Shops werden nach Namen sortiert ausgegeben. Die Daten werden von https://antcheck.de zur Verf�gung gestellt. Vielen Dank hierf�r!\n"
				+ "***Beispiel***: *!sells Lasius niger*",
				false);
		eb.setFooter("Version " + Antony.getVersion());
		
		return eb;
		
	}

}
