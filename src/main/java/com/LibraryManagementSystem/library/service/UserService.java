package com.LibraryManagementSystem.library.service;

import com.LibraryManagementSystem.library.dto.UserDTO;
import com.LibraryManagementSystem.library.dto.UserSaveDTO;
import com.LibraryManagementSystem.library.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {
    String addUser(UserSaveDTO userSaveDTO);
    List<UserDTO> getAllUser();
    String updateUser(UserUpdateDTO userUpdateDTO);
    String deleteUser(int id);
}
