package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class UserDTO {
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private UserDTO role;
    private String image;
}
