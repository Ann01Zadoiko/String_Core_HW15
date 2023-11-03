package com.example.hw_15.service;

import com.example.hw_15.entity.Note;
import com.example.hw_15.exception.NotFountNoteException;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteService implements IService<Note>{
    private final Map<Long, Note> notes = new HashMap<>();
    private Long setterId = 0L;


    @Override
    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    @Override
    public Note add(Note entity) {
        entity.setId(++setterId);
        notes.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void deleteById(Long id) throws NotFountNoteException {
        if (!notes.containsKey(id)){
            throw new NotFountNoteException(id);
        } else {
            notes.remove(id);
        }
    }

    @Override
    public void update(Note entity) throws NotFountNoteException {
        if (notes.containsKey(entity.getId())){
            notes.get(entity.getId()).setTitle(entity.getTitle());
            notes.get(entity.getId()).setContent(entity.getContent());
        } else
            throw new NotFountNoteException(entity.getId());
    }

    @Override
    public Note getById(Long id) throws NotFountNoteException {
        if (!notes.containsKey(id)){
            throw new NotFountNoteException(id);
        } else {
            return notes.get(id);
        }
    }
}