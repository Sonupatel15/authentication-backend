package org.example.authenticationbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostResponseDTO {
    private String title;
    private String body;
    private String pinggyAuthHeader;
}
