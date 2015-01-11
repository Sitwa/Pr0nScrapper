package pl.brawura.models;

import java.util.List;

/**
 * Created by Bartłomiej on 2015-01-11.
 */
public class Quote {

    private String Content;
    private List<Comment> comments;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
