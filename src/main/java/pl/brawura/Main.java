package pl.brawura;

import org.jsoup.nodes.Document;
import pl.brawura.logic.QuoteReader;
import pl.brawura.url.UrlImporter;

public class Main {

    public static void main(String[] args) {

        UrlImporter importer = new UrlImporter();
        Document doc = importer.importUrl("http://pr0n.pl/32970");
        QuoteReader reader = new QuoteReader();
        reader.readQuote(doc).getComments();

    }
}
