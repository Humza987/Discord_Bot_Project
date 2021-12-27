import java.util.List;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter  {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event)  {
		String args[] = event.getMessage().getContentStripped().split("\\s+");
		if (args[0].equals("!clear")) {
			if(event.getMessage().getContentStripped().length() < 2) {
				
			}
			try {
				List<Message> messages = event.getChannel().getHistory().retrievePast(30).complete();
				event.getChannel().deleteMessages(messages).queue();
			}
			catch(Exception e) {
				
			}
		}
			
	}
}
