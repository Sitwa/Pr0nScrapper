package pl.brawura.logic;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.brawura.convert.DateConverter;
import pl.brawura.models.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartłomiej on 2015-01-11.
 */
public class CommentsReader {

    public List<Comment> readComments(Elements commentSections){
        List<Comment> comments = new ArrayList<Comment>();
        for(Element commentSection:commentSections){
            Comment comment = new Comment();
            Element commentBody = commentSection.getElementsByTag("tbody").first();
            comment = extractCommentAuthorAndDate(commentBody.children().first(),comment);
            comment = extractCommentContent(commentBody.children().last(),comment);
            comments.add(comment);
        }
        return comments;
    }

    private Comment extractCommentAuthorAndDate(Element authorLineSection, Comment comment){
        Element authorLine = authorLineSection.children().first();
        String date = authorLine.ownText();
        String author = authorLine.children().first().text();
        DateConverter dateConverter = new DateConverter();
        comment.setAuthor(author);
        comment.setDate(dateConverter.convertDate(date));
        return comment;
    }

    private Comment extractCommentContent(Element contentLineSection, Comment comment){
        Element contentLine = contentLineSection.children().first();
        comment.setContent(contentLine.text());
        return comment;
    }

}
