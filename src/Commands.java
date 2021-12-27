import java.awt.Color;
import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Commands extends ListenerAdapter {
	private boolean BotGreeting = true;
	boolean GAME = true;
	boolean StoryProgressed = false;
	Story s;
	EmbedBuilder eb = new EmbedBuilder();
	GuildMessageReceivedEvent event;
	private boolean StoryProgressed2;
	private boolean StoryProgressed3;
	int HP=100;
	int enemyHP=100;
	int AttackDamage;
	int DamageRecieved;
	private Random random = new Random();
	private int DamageTaken;
	private boolean StoryProgressed4 = false;
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if (event.getAuthor().isBot()) return;
		if (event.getMessage().getContentStripped().equals("!game")) {
			GAME = true;
			StoryProgressed = false;
			event.getChannel().sendMessage("Welcome to The Legends of Shire!").queue();

			eb.setTitle("The Legends of Shire");
			eb.setDescription("Welcome to this Adventure Game!");
			eb.setDescription("You are a young traveller and happen to run into the outskirts of a town!");
			eb.addField("What Would you like to do?   (Press the number to choose an option, e.g. 1)","1. Talk to the guard\n2. Inspect the Area", false);

	
			eb.setColor(0xF40C0C);

			event.getChannel().sendTyping().queue();

			event.getChannel().sendMessage(eb.build()).queue();
			eb.clear();
		}
		
		if(GAME && event.getMessage().getContentStripped().equals("1") && !StoryProgressed) {
			
			eb.addField("Guard:", "Hello there, young traveller!\n "
					+ "We actually need someone young like you to help us out\n "
					+ "Please help us take out the monsters in the dungeon outside this town \n "
					+ "Take this Long Sword and head out South\n "
					+ "I promise I will give you 50 Gold Coins if you are successful" ,false);
			eb.addField("What Would you like to do?   (Press the number to choose an option, e.g. 1)","1. Talk to the guard\n2. Inspect the Area\n3. Equip Long Sword, and head out to find in the dungeon in the forest", false);
			eb.setColor(0xF40C0C);
			event.getChannel().sendMessage(eb.build()).queue();
			eb.clear();
		}
		
		if(GAME && event.getMessage().getContentStripped().equals("2") && !StoryProgressed) {
			eb.setDescription("You see a bustling town... with a lot of townsfolk... it looks quite amazing");
			eb.setColor(0xF40C0C);
			event.getChannel().sendMessage(eb.build()).queue();
			eb.clear();
		}
		
		if(GAME && event.getMessage().getContentStripped().equals("3") && !StoryProgressed) {
			StoryProgressed = true;
		}

	
		if(StoryProgressed) {
			
			s = new Story();
			if(event.getMessage().getContentStripped().equals("3")) {
				eb.setDescription("You come accross some Forest People\n"
						+ "Press 1 to talk to them");
				eb.setColor(0xF40C0C);
				event.getChannel().sendMessage(eb.build()).queue();
				GAME = false;
		}
			if(!GAME && event.getMessage().getContentStripped().equals("1")) {
				eb.setDescription("Ah! Hello there!, I wish I could just talk but these monsters "
						+ "They are terrifying us, Please Help!\n Press 2 to go into the Dungeon");
				eb.setColor(0xF40C0C);
				event.getChannel().sendMessage(eb.build()).queue();
				StoryProgressed = false;
				StoryProgressed2 = true;
			}
	}
		if(StoryProgressed2) {
			boolean EnterDungeon = true;
			if(EnterDungeon  && !GAME && event.getMessage().getContentStripped().equals("2")) {
				eb.setDescription("You slowly enter the dungeon...\n"
						+ "it's quite dark and creepy.. but you think to yourself, 'I have to do this!'\n"
						+ "Press 3 to continue!");
				eb.setColor(0xF40C0C);
				event.getChannel().sendMessage(eb.build()).queue();
				EnterDungeon = false;
		}
			if(!GAME && event.getMessage().getContentStripped().equals("3")) {
				eb.setDescription("A Monster had Appeared!\n What Would you Like to do?\n1. Attack\n 2. Run" );

				eb.setColor(0xF40C0C);
				event.getChannel().sendMessage(eb.build()).queue();
				StoryProgressed2 = false;
				StoryProgressed3 = true;
		}
		}
		
		if(StoryProgressed3) {
				if(!GAME && event.getMessage().getContentStripped().equals("1")) {
					
					AttackDamage = random.nextInt(50);
					DamageTaken = random.nextInt(30);
					HP -= DamageTaken;
					enemyHP -= AttackDamage;
					if(HP<=0) {
						eb.setDescription("Your HP: "+HP+"\n Enemy HP: "+enemyHP+"\nYou attack the Monster Dealing "+AttackDamage+" hp\nThe Monster Deals "+DamageTaken+"hp of damage to you!\n--------------------------------------\nGAME OVER! YOU DIED!");
						eb.setColor(0xF40C0C);
						event.getChannel().sendMessage(eb.build()).queue();
						StoryProgressed3 = false;
						StoryProgressed4 = false;
					}
					else if(HP>0) {
						if(enemyHP>0) {
							eb.setDescription("Your HP: "+HP+"\n Enemy HP: "+enemyHP+"\nYou attack the Monster Dealing "+AttackDamage+" hp\nThe Monster Deals "+DamageTaken+"hp of damage to you!\nWhat Would you Like to do?\n1. Attack\n 2. Run");
							eb.setColor(0xF40C0C);
							event.getChannel().sendMessage(eb.build()).queue();
						}
				
						else if(enemyHP<=0) {
							eb.setDescription("Your HP: "+HP+"\n Enemy HP: "+enemyHP+"\nYou attack the Monster Dealing "+AttackDamage+" hp\nThe Monster Deals "+DamageTaken+"hp of damage to you!\n--------------------------------------\nMonster is Dead!\n Press 4 to return Back to the City");
							eb.setColor(0xF40C0C);
							event.getChannel().sendMessage(eb.build()).queue();
							StoryProgressed3 = false;
							StoryProgressed4 = true;
						}
					}

					
//					
				
			}
				if(!GAME && event.getMessage().getContentStripped().equals("2")) {
					eb.setDescription("Game over!");
					eb.setColor(0xF40C0C);
					event.getChannel().sendMessage(eb.build()).queue();
					StoryProgressed3 = false;
			}
		
		}
		
		if(StoryProgressed4) {
			if(!GAME && event.getMessage().getContentStripped().equals("4")) {
				eb.setDescription("Guard: Thanks alot for your Help! and here's your reward\n The End!\n Thanks for Playing!");
				eb.setColor(0xF40C0C);
				event.getChannel().sendMessage(eb.build()).queue();
		}
		}
		
	}
}
