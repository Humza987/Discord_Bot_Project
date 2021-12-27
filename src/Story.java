import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
public class Story extends ListenerAdapter{

		public void onGuildMessageReceived(GuildMessageReceivedEvent event2) {
			Commands c = new Commands();
				EmbedBuilder eb2 = new EmbedBuilder();

				if(event2.getMessage().getContentStripped().equals("3")) {
				eb2.setDescription("You come accross some Forest People\n"
						+ "Press 4 to talk to them");
				eb2.setColor(0xF40C0C);
				event2.getChannel().sendMessage(eb2.build()).queue();
			}
				if(c.StoryProgressed && event2.getMessage().getContentStripped().equals("4")) {
					eb2.setDescription("Ah! Hello there!, I wish I could just talk but these monsters"
							+ "They are terrifying us, Please Help!");
					eb2.setColor(0xF40C0C);
					event2.getChannel().sendMessage(eb2.build()).queue();
				}
		

		}
}
