package com.example.springexample.controllers;

import com.example.springexample.dto.CommentDto;
import com.example.springexample.services.CommentCRUDService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentCRUDService commentsService;

    public CommentController(CommentCRUDService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping("/{id}")
    public CommentDto getCommentById(@PathVariable Integer id) {
        return commentsService.getById(id);
    }

    @GetMapping
    public Collection<CommentDto> getAllComments() {
        return commentsService.getAll();
    }

    @PostMapping
    public void createComment(@RequestBody CommentDto commentDto) {
        commentsService.create(commentDto);
    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable Integer id, @RequestBody CommentDto commentDto) {
        commentsService.update(id, commentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Integer id) {
        commentsService.delete(id);
    }
}
