package pl.brawura.url;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Bartłomiej on 2015-01-11.
 */
public class UrlImporter {

    public Document importUrl(String url){
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("Cant connect to given url: ");
            e.printStackTrace();
        }
        return doc;
    }


}
