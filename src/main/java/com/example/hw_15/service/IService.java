package com.example.hw_15.service;

import com.example.hw_15.exception.NotFountNoteException;

import java.util.List;

public interface IService<T> {
    List<T> listAll();

    T add(T entity);

    void deleteById(Long id) throws NotFountNoteException;

    void update(T entity) throws NotFountNoteException;

    T getById(Long id) throws NotFountNoteException;
}
