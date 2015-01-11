package pl.brawura.models;

import java.util.Date;

/**
 * Created by Bartłomiej on 2015-01-11.
 */
public class Comment {
    private String Author;
    private String Content;
    private Date Date;

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }
}
