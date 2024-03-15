package myscrapper.app;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.InputStreamReader;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class App  {
    public static void main( String[] args ) {
        String url = "https://en.wikipedia.org/wiki/96th_Academy_Awards";
        try {
            // Connect to the target website
            Document doc = Jsoup.connect(url).get();
            
            try ( BufferedWriter writer = new BufferedWriter(
                new FileWriter("/data/html_conten.txt")
            )) {
                writer.write("doc.toString()");
                writer.flush();
            } catch (IOException e) {
                System.out.println(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        System.out.println( "Hello Java World!" );
    }
}
