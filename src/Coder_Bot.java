import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.JDA;

public class Coder_Bot {
	public static void main(String args[]) throws LoginException{
		JDABuilder jda = JDABuilder.createDefault(""); // Enter personal token here
		jda.setActivity(Activity.playing("GleemShire"));
		jda.setStatus(OnlineStatus.ONLINE);
		jda.addEventListeners(new Commands());
	//	jda.addEventListeners(new Story());
		jda.addEventListeners(new Clear());
		jda.build();
	}

}
