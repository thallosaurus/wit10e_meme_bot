import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MemeBotWIT10E extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText())
        {
            SendMessage msg = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText());

            try {
                execute(msg);
            }
            catch (TelegramApiException e)
            {
                e.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        return System.getenv("bot_name");
    }

    public String getBotToken() {
        return System.getenv("bot_token");
    }
}
