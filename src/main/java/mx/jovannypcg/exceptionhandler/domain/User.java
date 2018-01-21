package mx.jovannypcg.exceptionhandler.domain;

import java.util.List;

public class User {
    private String username;
    private List<Post> publications;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Post> getPublications() {
        return publications;
    }

    public void setPublications(List<Post> publications) {
        this.publications = publications;
    }
}
