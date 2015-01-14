package pl.brawura;

import org.jsoup.nodes.Document;
import pl.brawura.logic.QuoteReader;
import pl.brawura.url.UrlImporter;

public class Main {

    public static void main(String[] args) {

        UrlImporter importer = new UrlImporter();
        QuoteReader reader = new QuoteReader();
        int falsed = 0;
        for(int i =0;i<100;i++){
            try{
                Document doc = importer.importUrl("http://pr0n.pl/"+i);
                reader.readQuote(doc);
            }catch (Exception e){
                falsed++;
                System.out.println("[//////////////////////////Cytat nr. "+i+" nie istnieje\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\]");
            }
        }

        System.out.println("Zrobione! Przeskanowałem 100 cytatów z czego "+(100-falsed)+" było aktywnych!");

    }
}
