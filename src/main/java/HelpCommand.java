import java.lang.reflect.Field;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class HelpCommand extends BotCommand {

	String helpString = "Help goes here\n\nAvailable Commands:\n";
	
	public HelpCommand(String commandIdentifier, String description) {
		super(commandIdentifier, description);
		
		try {
			helpString += getCommands(new Constants());
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getCommands(Object o) throws IllegalArgumentException, IllegalAccessException
	{
		String str = "";
		for (Field f : o.getClass().getDeclaredFields())
		{
			//System.out.println(f.get(o));
			str += "/" + f.get(o) + "\n";
		}
		return str;
	}

	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
		// TODO Auto-generated method stub
		SendMessage msg = new SendMessage();
		msg.setChatId(chat.getId());
		msg.setText(helpString);
		
		try {
			absSender.execute(msg);
		} catch (TelegramApiException e) {
            e.printStackTrace();
        }
	}

}
