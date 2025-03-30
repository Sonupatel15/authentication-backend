package org.example.authenticationbackend.repository;

import org.example.authenticationbackend.dto.PostResponseDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryStorage {
    private final List<PostResponseDTO> posts = new ArrayList<>();

    public void savePost(PostResponseDTO post) {
        posts.add(post);
    }

    public List<PostResponseDTO> getAllPosts() {
        return posts;
    }
}
