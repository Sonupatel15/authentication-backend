package org.example.authenticationbackend.controller;

import org.example.authenticationbackend.dto.PostRequestDTO;
import org.example.authenticationbackend.dto.PostResponseDTO;
import org.example.authenticationbackend.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<String> createPost(@Valid @RequestBody PostRequestDTO postRequest) {
        postService.savePost(postRequest);
        return ResponseEntity.ok("Post saved successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<List<PostResponseDTO>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }
}
