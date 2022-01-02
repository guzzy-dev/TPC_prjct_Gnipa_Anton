package com.example.servicecomments.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Comment {
    private long product_id;
    private String text;
    private long author_id;
    private int likes;
}
