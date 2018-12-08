package com.rremi.rest_app.errorHandling;

//exception to indicate that the requested user does not exists
public class UserNotFoundException extends RuntimeException {
    private Long userId;
    
    public UserNotFoundException(Long userId){
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}
