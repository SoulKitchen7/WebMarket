package ru.skypro.homework.service.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.skypro.homework.dto.NewPasswordDTO;
import ru.skypro.homework.dto.UpdateUserDTO;
import ru.skypro.homework.dto.UserDTO;
import ru.skypro.homework.model.Image;
import ru.skypro.homework.model.UserInfo;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.ImageService;
import ru.skypro.homework.service.impl.AuthServiceImpl;
import ru.skypro.homework.service.impl.UserServiceImpl;
import ru.skypro.homework.service.mapper.UserMapper;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    private AuthServiceImpl authService;
    @Mock
    private PasswordEncoder encoder;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @Mock
    private ImageService imageService;
    @Mock
    private MockMultipartFile mockMultipartFile;
    @InjectMocks
    UserServiceImpl userService;
    @Test
    public void shouldSavePassword() {
        UserInfo user = new UserInfo();
        user.setPassword("myPassword");
        when(authService.getCurrentUser()).thenReturn(user);
        when(encoder.matches(anyString(), anyString())).thenReturn(true);
        when(encoder.encode(anyString())).thenReturn("myPassword2");
        userService.setPassword(new NewPasswordDTO("myPassword", "myPassword2"));
        verify(userRepository, times(1)).save(any());
    }
    @Test
    public void shouldReturnUserInfo() {
        UserInfo user = new UserInfo();
        UserDTO userDTO = new UserDTO();
        when(authService.getCurrentUser()).thenReturn(user);
        when(userMapper.userToDto(user)).thenReturn(userDTO);
        UserDTO userDto2 = userService.getUserInfo();
        Assertions.assertNotNull(userDto2);
        Assertions.assertEquals(userDTO,userDto2);
    }
    @Test
    public void shouldReturnUpdatedUser() {
        UserInfo user = new UserInfo();
        UpdateUserDTO updateUser1 = new UpdateUserDTO();
        updateUser1.setFirstName("Иван");
        updateUser1.setLastName("Иванов");
        updateUser1.setPhone("02");
        when(authService.getCurrentUser()).thenReturn(user);
        when(userMapper.userToUpdateUserDto(user)).thenReturn(updateUser1);
        userService.updateUser(updateUser1);
        Assertions.assertEquals(user.getFirstName(), "Иван");
        Assertions.assertEquals(user.getLastName(), "Иванов");
        Assertions.assertEquals(user.getPhone(), "02");
    }
    @Test
    public void shouldReturnUpdatedUserImage() {
        UserInfo user = new UserInfo();
        Image image = new Image();
        Image uploadImage = new Image();
        when(authService.getCurrentUser()).thenReturn(user);
        when(imageService.uploadImage(mockMultipartFile)).thenReturn(image);
        userService.updateUserImage(mockMultipartFile);
        verify(userRepository, times(1)).save(any());

    }


}
