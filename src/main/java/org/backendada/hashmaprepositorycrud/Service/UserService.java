package org.backendada.hashmaprepositorycrud.Service;

import org.backendada.hashmaprepositorycrud.Data.UserDTO;
import org.backendada.hashmaprepositorycrud.Domain.User;

import java.util.List;

public interface UserService {

    public UserDTO add(User user);
    public List<UserDTO> all();
    public UserDTO findById(Long id);
    public UserDTO update(Long id, User user);
    public void delete(Long id);
}
