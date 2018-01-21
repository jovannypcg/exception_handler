package mx.jovannypcg.exceptionhandler.domain;

import javax.validation.constraints.NotNull;

public class Post implements Containable {
    @NotNull
    private User owner;
    private Long id;
    private String content;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
