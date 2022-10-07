package ru.sfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Television Repository container
 */
@Component
@Scope(scopeName = "singleton")
public class RepositoryContainer {

    private final TelevisionRepository repository;

    /**
     * Television Repository dependency injection
     * @param repository Television Repository
     */
    @Autowired
    public RepositoryContainer(TelevisionRepository repository) {
        this.repository = repository;
    }


    /**
     * Get Television Repository Object
     * @return Television Repository Object
     */
    public TelevisionRepository getRepository() {
        return repository;
    }
}
