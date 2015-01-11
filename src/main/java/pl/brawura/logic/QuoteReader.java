package pl.brawura.logic;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.brawura.models.Comment;
import pl.brawura.models.Quote;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartłomiej on 2015-01-11.
 */
public class QuoteReader {

    public Quote readQuote(Document thread){
        Quote quote = new Quote();
        List<Comment> commentList = new ArrayList<Comment>();
        CommentsReader commentsReader = new CommentsReader();

        Element center = thread.body().getElementsByTag("center").first();

        System.out.println(center);

        Element table = center.getElementsByTag("table").get(2);
        readQuoteContent(table);
        Elements commentSections = table.getElementsByAttributeValue("width","90%");

        quote.setComments(commentsReader.readComments(commentSections));
        return quote;
    }


    private String readQuoteContent(Element table){
    System.out.println(table);
        return null;
    }

}
