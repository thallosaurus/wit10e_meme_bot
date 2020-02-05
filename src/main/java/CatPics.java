import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CatPics extends BotCommand {

	public CatPics(String commandIdentifier, String description) {
		super(commandIdentifier, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
		// TODO Auto-generated method stub
		
		
		//Pick a random picture
		//String in = getClass().getResource("/resources/cat_pics/1.jpg").getFile();
		System.out.println("What the fuck");
		
		Random rand = null;
		
		int chosenPicture = rand.nextInt() % 3;
		
		SendPhoto msg = new SendPhoto();
		msg.setChatId(chat.getId());
		
		msg.setPhoto("Meow", getClass().getResourceAsStream(chosenPicture + ".jpg"));
		
		try {
			absSender.execute(msg);
		} catch (TelegramApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*private String readFromInputStream(InputStream inputStream)
			  throws IOException {
			    StringBuilder resultStringBuilder = new StringBuilder();
			    try (BufferedReader br
			      = new BufferedReader(new InputStreamReader(inputStream))) {
			        String line;
			        while ((line = br.readLine()) != null) {
			            resultStringBuilder.append(line).append("\n");
			        }
			    }
			  return resultStringBuilder.toString();
			} */

}
