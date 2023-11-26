package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.model.Image;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.ImageService;

import java.io.*;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    @Value("${path.to.image.folder}")
    private String imageDir;

    private final ImageRepository imageRepository;

    @Override
    //метод для загрузки фото в БД
    public Image uploadImage(MultipartFile file) {
        Image image = new Image();
        image.setId((UUID.randomUUID().toString())); // генерируем уникальный идентификатор
        try {
            byte[] bytes = file.getBytes();
            image.setImage(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageRepository.save(image);
    }

    @Override
    //метод для получения фото по id
    public byte[] getImage(String id) {
        Image image = imageRepository.findById(id).orElse(null);
        if (image != null) {
            return image.getImage();
        } else {
            return null;
        }
    }

}
