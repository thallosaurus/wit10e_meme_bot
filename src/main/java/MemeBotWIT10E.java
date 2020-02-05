import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MemeBotWIT10E extends TelegramLongPollingCommandBot {

	@Override
    public void processNonCommandUpdate(Update update) {

    }

    public String getBotUsername() {
        //return System.getenv("bot_name");
    	return Config.BOT_USER;
    }

    public String getBotToken() {
        //return System.getenv("bot_token");
    	return Config.BOT_TOKEN;
    }
    
    public MemeBotWIT10E()
    {
    	super();
    	
    	register(new StartCommand("start", "start here"));
    	register(new CatPics("cat", "send me cute cat pictures"));
    	
    	registerDefaultAction((absSender, message) -> {
    		SendMessage commandUnknownMessage = new SendMessage();
            commandUnknownMessage.setChatId(message.getChatId());
            commandUnknownMessage.setText("The command '" + message.getText() + "' is not known by this Bot.");
            
            try {
                absSender.execute(commandUnknownMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
    	});
    }
}
