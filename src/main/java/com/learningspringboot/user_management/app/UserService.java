package com.learningspringboot.user_management.app;

import com.learningspringboot.user_management.infrastructure.entitys.User;
import com.learningspringboot.user_management.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.saveAndFlush(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User not found with email: " + email)
        );
    }

    public void deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    public void updateUserById(Integer id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found with id: " + id)
        );
        User UpdatedUser = new User().builder()
                .email(user.getEmail() != null ? user.getEmail() : existingUser.getEmail())
                .name(user.getName() != null ? user.getName() : existingUser.getName())
                .id(existingUser.getId())
                .build();
    }
}
