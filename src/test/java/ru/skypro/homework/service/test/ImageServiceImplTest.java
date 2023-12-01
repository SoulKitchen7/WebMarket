package ru.skypro.homework.service.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import ru.skypro.homework.model.Image;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.service.impl.ImageServiceImpl;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ImageServiceImplTest {
    @Mock
    private ImageRepository imageRepository;
    @Mock
    private MockMultipartFile mockMultipartFile;
    @InjectMocks
    private ImageServiceImpl imageService;

    @Test
    public void shouldReturnImageById() {
        Image image = new Image();
        image.setId("1");
        image.setImage(new byte[]{1, 2});
        when(imageRepository.findById("1")).thenReturn(Optional.of(image));
        Assertions.assertArrayEquals(imageService.getImage("1"), new byte[]{1, 2});

    }

    @Test
    public void shouldReturnImageById2() {
        Image image = new Image();
        when(imageRepository.findById("1")).thenReturn(Optional.of(image));
        Assertions.assertArrayEquals(imageService.getImage("1"), null);

    }
}
