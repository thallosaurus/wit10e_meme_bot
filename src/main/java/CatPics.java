import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CatPics extends BotCommand {
	
	String cataas = "https://cataas.com/cat";

	public CatPics(String commandIdentifier, String description) {
		super(commandIdentifier, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
		// TODO Auto-generated method stub
		
		//retrieve a random cat picture from CataAS:
		InputStream in = null;
		try {
			in = new URL(cataas).openStream();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		//Create the message and append the picture
		SendPhoto msg = new SendPhoto();
		msg.setChatId(chat.getId());
		msg.setPhoto("Meow", in);
		
		//Send the message back
		try {
			absSender.execute(msg);
		} catch (TelegramApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Sent photo");
		}
	}

}
