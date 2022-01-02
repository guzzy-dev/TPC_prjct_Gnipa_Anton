package com.example.servicecomments.api;

import com.example.servicecomments.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comments")
public final class CommentController {

    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<com.example.servicecomments.repo.model.Comment>> index(){
        final List<com.example.servicecomments.repo.model.Comment> comments = commentService.fetchall();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.example.servicecomments.repo.model.Comment> show(@PathVariable long id){
        try{
            final com.example.servicecomments.repo.model.Comment comment = commentService.fetchById(id);
            return ResponseEntity.ok(comment);

        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.example.servicecomments.api.dto.Comment comment){
        final long author_id = comment.getAuthor_id();
        final long product_id = comment.getProduct_id();
        final String text = comment.getText();
        final int likes = comment.getLikes();

        final long id = commentService.create(product_id, text, author_id, likes);
        final String location = String.format("/comments/%d", id);

        return ResponseEntity.created(URI.create(location)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody com.example.servicecomments.api.dto.Comment comment){
        final long author_id = comment.getAuthor_id();
        final long product_id = comment.getProduct_id();
        final String text = comment.getText();
        final int likes = comment.getLikes();

        try{
            commentService.update(id, product_id, text, author_id, likes);
            return ResponseEntity.noContent().build();

        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
