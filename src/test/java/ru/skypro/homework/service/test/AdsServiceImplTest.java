package ru.skypro.homework.service.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.service.ImageService;
import ru.skypro.homework.service.impl.AuthServiceImpl;
import ru.skypro.homework.service.mapper.AdsMapper;
@ExtendWith(MockitoExtension.class)
public class AdsServiceImplTest {
    @MockBean
    private AdsRepository adsRepository;
    @MockBean
    private AdsMapper adsMapper;
    @MockBean
    private AuthServiceImpl authService;
    @MockBean
    private ImageService imageService;
    @InjectMocks
    private AdsServiceImplTest adsService;
    @Test
    public void shouldReturnAllAds() {

    }
    @Test
    public void shouldReturnAddedAds() {

    }
@Test
public void shouldReturnAdsById() {

}
@Test
    public void shouldDeleteAds() {

    }
    @Test
    public void shouldUpdateAds() {

    }
    @Test
    public void shouldReturnUserAds() {

    }
    @Test
    public void shouldUpdateAdsImage() {

    }
    @Test
    public void shouldReturnImageById() {

    }
}
