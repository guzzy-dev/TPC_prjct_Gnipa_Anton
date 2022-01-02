package com.example.servicecomments.service;

import com.example.servicecomments.repo.CommentRepo;
import com.example.servicecomments.repo.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class CommentService {

    private final CommentRepo commentRepo;

    public List<Comment> fetchall(){
        return commentRepo.findAll();
    }

    public Comment fetchById(long id) throws IllegalArgumentException{
        final Optional<Comment> maybeComment = commentRepo.findById(id);

        if (maybeComment.isEmpty()) throw new IllegalArgumentException("Comment bot found");
        else return maybeComment.get();
    }

    public long create(long product_id, String text, long author_id, int likes){
        final Comment comment = new Comment(product_id, text, author_id, likes);
        final Comment savedComment = commentRepo.save(comment);

        return savedComment.getId();
    }

    public void update(long id,  long product_id, String text, long author_id, int likes){
        final Optional<Comment> maybeComment = commentRepo.findById(id);
        if (maybeComment.isEmpty()) throw new IllegalArgumentException("Comment bot found");

        final Comment comment = maybeComment.get();
        if (text != null && !text.isBlank()) comment.setText(text);
        if (likes !=0) comment.setLikes(likes);
        commentRepo.save(comment);
    }

    public void delete(long id){
        commentRepo.deleteById(id);
    }
}

