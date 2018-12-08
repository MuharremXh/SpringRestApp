package com.rremi.rest_app;

//exception to indicate that the requested item does not exist
public class itemNotFoundExcwption extends RuntimeException {
    private Long id;

    public itemNotFoundExcwption(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
