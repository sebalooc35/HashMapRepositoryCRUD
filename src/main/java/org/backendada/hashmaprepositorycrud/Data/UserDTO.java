package org.backendada.hashmaprepositorycrud.Data;

import org.backendada.hashmaprepositorycrud.Domain.User;

public class UserDTO {
    private Long id;
    private String username;
    private String name;
    private String email;
    private String password;
    private String phone;

    public UserDTO(String username, String name, String email, String password, String phone, Long id) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.id = id;
    }

    public UserDTO(Long id, User user){
        this.id = id;
        this.username = user.getUsername();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.phone = user.getPhone();
    }

    public UserDTO() {
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
