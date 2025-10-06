package com.mftplus.model.service;

import com.mftplus.exception.NotFoundException;
import com.mftplus.model.repository.CrudRepository;
import org.glassfish.jersey.process.internal.RequestScoped;

import java.util.List;

@RequestScoped
public class Service<T> {

    private final Class<T> tClass;

    public Service(Class<T> tClass) {
        this.tClass = tClass;
    }
    public T save(T entity) throws Exception {
        try (CrudRepository<T, Integer> repository = new CrudRepository<>()) {
            return repository.save(entity);
        }
    }

    public T edit(T entity, int id) throws Exception {
        try (CrudRepository<T, Integer> repository = new CrudRepository<>()) {
            if (repository.findById(id, tClass) == null) {
                throw new NotFoundException(entity);
            }
            return repository.edit(entity);
        }
    }

    public void deleteById(int id) throws Exception {
        try (CrudRepository<T, Integer> repository = new CrudRepository<>()) {
            if (repository.findById(id, tClass) == null) {
                throw new NotFoundException(tClass);
            }
            repository.deleteById(id, tClass);
        }
    }

    public List<T> findAll() throws Exception {
        try (CrudRepository<T, Integer> repository = new CrudRepository<>()) {
            return repository.findAll(tClass);
        }
    }

    public T findById(int id) throws Exception {
        try (CrudRepository<T, Integer> repository = new CrudRepository<>()) {
            T entity = repository.findById(id, tClass);
            if (entity == null) {
                throw new NotFoundException(tClass);
            }
            return entity;
        }
    }
    public T findByNameAndFamily(String name, String family) throws Exception {
        try (CrudRepository<T, Integer> repository = new CrudRepository<>()) {
            T entity = repository.findByNameAndFamily(tClass, name, family);
            if (entity == null) {
                throw new NotFoundException(tClass);
            }
            return entity;
        }
    }
}
