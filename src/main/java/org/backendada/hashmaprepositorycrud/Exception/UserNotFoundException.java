package org.backendada.hashmaprepositorycrud.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends ResponseStatusException {
    public UserNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND,"El usuario con id: "+id+" no existe");
    }
}
