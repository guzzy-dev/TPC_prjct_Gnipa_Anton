package com.example.servicecomments.repo.model;


import javax.persistence.*;

@Entity
@Table(name = "comments")
public final class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long product_id;
    private String text;
    private long author_id;
    private int likes;

    public Comment() {
    }

    public Comment(long product_id, String text, long author_id, int likes) {
        this.product_id = product_id;
        this.text = text;
        this.author_id = author_id;
        this.likes = likes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
