import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class URLTester {
	public void getPicture(String link)
	{
		try (BufferedInputStream in = new BufferedInputStream(new URL(link).openStream());
				  FileOutputStream fileOutputStream = new FileOutputStream(link)) {
				    byte dataBuffer[] = new byte[1024];
				    int bytesRead;
				    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
				        fileOutputStream.write(dataBuffer, 0, bytesRead);
				    }
				} catch (IOException e) {
				    // handle exception
				}
	}
}
