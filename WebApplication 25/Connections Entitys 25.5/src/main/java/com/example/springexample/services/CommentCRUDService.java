package com.example.springexample.services;

import com.example.springexample.dto.CommentDto;
import com.example.springexample.entity.Comment;
import com.example.springexample.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.TreeMap;

@RequiredArgsConstructor
@Slf4j
@Service
public class CommentCRUDService implements CRUDServices<CommentDto>{

    private final CommentRepository repository;

    @Override
    public CommentDto getById(Integer id) {
        log.info("Get by ID: " + id);
        Comment comment = repository.findById(id).orElseThrow();
        return mapToDto(comment);
    }

    @Override
    public Collection<CommentDto> getAll() {
        log.info("Get all");
        return repository.findAll()
                .stream()
                .map(CommentCRUDService::mapToDto).toList();
    }

    @Override
    public void create(CommentDto item) {
        log.info("Create");
        Comment comment = mapToEntity(item);
        repository.save(comment);
    }

    @Override
    public void update(CommentDto item) {
        log.info("Update");
        Comment comment = mapToEntity(item);
        repository.save(comment);
    }

    @Override
    public void delete(Integer id) {
        log.info("Delete " + id);
        repository.deleteById(id);
    }

    public static CommentDto mapToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setText(comment.getText());
        commentDto.setAuthor(comment.getAuthor());
        return commentDto;
    }

    public static Comment mapToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setText(commentDto.getText());
        comment.setAuthor(commentDto.getAuthor());
        return comment;
    }
}
