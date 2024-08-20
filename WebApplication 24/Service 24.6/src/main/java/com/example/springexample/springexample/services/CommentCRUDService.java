package com.example.springexample.springexample.services;

import com.example.springexample.springexample.dto.CommentDto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.TreeMap;

@Service
public class CommentCRUDService implements CRUDServices<CommentDto>{

    private final TreeMap<Integer, CommentDto> storage = new TreeMap<>();

    @Override
    public CommentDto getById(Integer id) {
        System.out.println("Get by ID: " + id);
        return storage.get(id);
    }

    @Override
    public Collection<CommentDto> getAll() {
        System.out.println("Get all");
        return storage.values();
    }

    @Override
    public void create(CommentDto item) {
        System.out.println("Create");
        int nextId = (storage.isEmpty() ? 0 : storage.lastKey()) + 1;
        item.setId(nextId);
        storage.put(nextId, item);

    }

    @Override
    public void update(Integer id, CommentDto item) {
        System.out.println("Update " + id);
        if (!storage.containsKey(id)) {
            return;
        }
        item.setId(id);
        storage.put(id, item);

    }

    @Override
    public void delete(Integer id) {
        System.out.println("Delete " + id);
        storage.remove(id);

    }
}
