package ru.skypro.homework.service.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.ImageService;
import ru.skypro.homework.service.impl.AuthServiceImpl;
import ru.skypro.homework.service.mapper.UserMapper;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @MockBean
    private AuthServiceImpl authService;
    @MockBean
    private PasswordEncoder encoder;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private UserMapper userMapper;
    @MockBean
    private ImageService imageService;
    @InjectMocks
    UserServiceImplTest userService;
    @Test
    public void shouldReturnSavedPassword() {

    }
    @Test
    public void shouldReturnUserInfo() {

    }
    @Test
    public void shouldReturnUpdatedUser() {

    }
    @Test
    public void shouldReturnUpdatedUserImage() {

    }
    @Test
    public void shouldReturnImageById() {

    }


}
