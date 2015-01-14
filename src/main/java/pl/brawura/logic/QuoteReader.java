package pl.brawura.logic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import pl.brawura.convert.DateConverter;
import pl.brawura.models.Comment;
import pl.brawura.models.Quote;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Bartłomiej on 2015-01-11.
 */
public class QuoteReader {

    public Quote readQuote(Document thread){
        Quote quote = new Quote();
        CommentsReader commentsReader = new CommentsReader();

        Element center = thread.body().getElementsByTag("center").first();
        Element table = center.getElementsByTag("table").get(2);
        Elements commentSections = table.getElementsByAttributeValue("width","90%");

        quote = readQuoteContent(table, quote);
        quote.setComments(commentsReader.readComments(commentSections));

        //Just to check

        System.out.print("Quote ID: " + quote.getId());
        System.out.print(" Likes: " + quote.getLikes());
        System.out.println(" Add Date: "+quote.getAddDate());
        System.out.println("/////////////////////Content////////////////////////");
        for(String contentPart : quote.getContent()){
            System.out.println(contentPart);
        }
        System.out.println("////////////////////Comments/////////////////////////");
        for(Comment comment : quote.getComments()){
            System.out.print("[");
            System.out.print(comment.getAuthor());
            System.out.print("]");
            System.out.print(" A.D. ");
            System.out.println("("+comment.getDate()+")");
            System.out.println("--------------Comment-------------");
            System.out.println(comment.getContent());
            System.out.println("----------------------------------");
            System.out.println("");
        }
        System.out.println("");

        return quote;
    }

    private Quote readQuoteContent(Element table, Quote quote){
        Element quoteLine = table.getElementsByTag("tbody").first().getElementsByTag("td").first();
        Element quoteIdSection = quoteLine.getElementsByTag("b").first();

        String stringId = quoteIdSection.text().substring(1);
        String stringToProcess = quoteLine.text();

        quote.setId(Integer.parseInt(stringId));
        quote.setLikes(extractLikeCount(stringToProcess));
        quote.setAddDate(extractDate(stringToProcess));
        quote.setContent(extractQuoteContent(quoteLine.getElementsByClass("qt")));
        return quote;
    }

    private int extractLikeCount(String given){
        int startPoint = given.lastIndexOf("+(")+2;
        int stopPoint = given.lastIndexOf(")-");
        String stringRepresentationOfLikes = given.substring(startPoint, stopPoint);
        int likes =Integer.parseInt(stringRepresentationOfLikes);
        return likes;
    }

    private Date extractDate(String given){
        int startPoint = given.indexOf(" (")+2;
        int stopPoint = given.indexOf(") ");
        String stringRepresentationOfDate = given.substring(startPoint, stopPoint);
        DateConverter dateConverter = new DateConverter();
        Date quoteAddDate = dateConverter.convertDate(stringRepresentationOfDate);
        return quoteAddDate;
    }

    private List<String> extractQuoteContent(Elements given){
        String contentHtml = given.toString();
        String[] splitedContent = contentHtml.split("<br> ");

        String quotePart = "";
        List<String> result = new ArrayList<String>();
        for(int i =0;i<splitedContent.length;i++){
            quotePart =Jsoup.clean(splitedContent[i],Whitelist.simpleText());
            quotePart = quotePart.replace("&lt;","<");
            quotePart = quotePart.replace("&gt;",">");
            result.add(quotePart);
        }
        return result;
    }
}
