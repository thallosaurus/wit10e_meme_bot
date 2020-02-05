import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class StartCommand extends BotCommand {

	public StartCommand(String commandIdentifier, String description) {
		super(commandIdentifier, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
		// TODO Auto-generated method stub
		StringBuilder msgBuilder = new StringBuilder();
		msgBuilder.append("Hello, World!")
			.append("\nYour Username is " + user.getUserName())
			.append("\nThis is just a Test, ignore me :)");
		
		SendMessage msg = new SendMessage();
		msg.setChatId(chat.getId());
		msg.setText(msgBuilder.toString());
		
		try {
			absSender.execute(msg);
		}
		catch (TelegramApiException e)
		{
			e.printStackTrace();
		}
	}

}
