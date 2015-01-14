package pl.brawura.models;

import java.util.Date;
import java.util.List;

/**
 * Created by Bartłomiej on 2015-01-11.
 */
public class Quote {

    private int id;
    private List<String> content;
    private List<Comment> comments;
    private int likes;
    private Date addDate;

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    public int getLikes() {return likes;}

    public void setLikes(int likes) {this.likes = likes;}

    public Date getAddDate() {return addDate;}

    public void setAddDate(Date addDate) {this.addDate = addDate;}
}
