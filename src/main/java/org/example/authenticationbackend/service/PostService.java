package org.example.authenticationbackend.service;

import org.example.authenticationbackend.config.CustomAuthFilter;
import org.example.authenticationbackend.dto.PostRequestDTO;
import org.example.authenticationbackend.dto.PostResponseDTO;
import org.example.authenticationbackend.repository.InMemoryStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final InMemoryStorage inMemoryStorage;

    public PostService(InMemoryStorage inMemoryStorage) {
        this.inMemoryStorage = inMemoryStorage;
    }

    public void savePost(PostRequestDTO postRequest) {
        String authHeader = CustomAuthFilter.getAuthHeader();
        PostResponseDTO postResponse = new PostResponseDTO(postRequest.getTitle(), postRequest.getBody(), authHeader);
        inMemoryStorage.savePost(postResponse);
    }

    public List<PostResponseDTO> getAllPosts() {
        return inMemoryStorage.getAllPosts();
    }
}
