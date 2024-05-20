package org.backendada.hashmaprepositorycrud.Controller;

import org.apache.coyote.Response;
import org.backendada.hashmaprepositorycrud.Data.UserDTO;
import org.backendada.hashmaprepositorycrud.Domain.User;
import org.backendada.hashmaprepositorycrud.Service.UserService;
import org.backendada.hashmaprepositorycrud.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List> getUsers(){
        List<UserDTO> users = this.userService.all();
        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String id){
        Long idNumber;

        try {
            idNumber = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"the id provided is not a valid number");
        }

        UserDTO userDTO = this.userService.findById(idNumber);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user){
        UserDTO userDTO = this.userService.add(user);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable String id,
            @RequestBody User userChanges
    ){
        Long idNumber;

        try {
            idNumber = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"the id provided is not a valid number");
        }

        UserDTO userDTO = this.userService.update(idNumber, userChanges);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        Long idNumber;

        try {
            idNumber = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"the id provided is not a valid number");
        }

        this.userService.delete(idNumber);
        return ResponseEntity.ok(null);
    }
}
