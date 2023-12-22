package demon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VersionCheck {
	private final String fileLink = "https://www.dropbox.com/scl/fi/y6qrmktt66wzgiit8mo6h/DemonSlayerOverlayVersion.txt?rlkey=8svv9qjngy4geqrn246d64cif&dl=1";
	
	private final String folder = "C:\\DemonOverlay";
	private final String outputPath = folder + "\\LastVersion.txt";
	private File file = new File(folder);
	
    public boolean isUpdated() throws IOException {
    	boolean value = true;
    	
    	try(InputStream inputStream = new FileInputStream(outputPath);
    		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    		Stream<String> streamOfString = new BufferedReader(inputStreamReader).lines()) {
            	String lastVersion = streamOfString.collect(Collectors.joining());
            	
            	if(SystemManager.Version.equals(lastVersion))
            		value = false;
    	}
    	
    	return value;
    }
    
    public void downloadFile() {
    	try {
            URL url = new URL(fileLink);
            URLConnection connection = url.openConnection();
            
            // 폴더가 존재하지 않을시 폴더 생성
            if(!file.exists())
            	file.mkdir();

            InputStream inputStream = connection.getInputStream();
            OutputStream outputStream = new FileOutputStream(outputPath);
            	
            int bytesRead;
            while ((bytesRead = inputStream.read()) != -1) {
            	outputStream.write(bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}