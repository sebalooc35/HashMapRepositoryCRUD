package org.backendada.hashmaprepositorycrud.Service;

import org.backendada.hashmaprepositorycrud.Data.UserDTO;
import org.backendada.hashmaprepositorycrud.Domain.User;
import org.backendada.hashmaprepositorycrud.Exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private HashMap<Long,User> repository;
    private Long lastId;

    public UserServiceImpl() {
        this.repository = new HashMap<>();
        this.lastId = 1L;
    }

    @Override
    public UserDTO add(final User user) {
        this.repository.put(lastId,user);
        return new UserDTO(lastId++, user);
    }

    @Override
    public List<UserDTO> all() {
        List<UserDTO> users = new LinkedList<>();
        if (this.repository.isEmpty()) return users;

        final Set keys = this.repository.keySet();
        final Iterator<Long> iterator = keys.iterator();

        while(iterator.hasNext()){
            Long id = iterator.next();
            final User user = this.repository.get(id);
            users.add(new UserDTO(id, user));
        }
        return users;
    }

    @Override
    public UserDTO findById(Long id) {
        User user = this.repository.get(id);
        if (user == null) throw new UserNotFoundException(id);
        return new UserDTO(id,user);
    }

    @Override
    public UserDTO update(Long id, User userChanges) {
        User user = this.repository.get(id);
        if(user == null) throw new UserNotFoundException(id);

        if(userChanges.getUsername() != null) user.setUsername(userChanges.getUsername());
        if(userChanges.getName() != null) user.setName(userChanges.getName());
        if(userChanges.getEmail() != null) user.setEmail(userChanges.getEmail());
        if(userChanges.getPassword() != null) user.setPassword(userChanges.getPassword());
        if(userChanges.getPhone() != null) user.setPhone(userChanges.getPhone());

        return new UserDTO(id, user);
    }

    @Override
    public void delete(Long id) {
        Set keys = this.repository.keySet();
        if(!keys.contains(id)) throw new UserNotFoundException(id);

        this.repository.remove(id);
    }
}
