package ru.skypro.homework.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdsDTO {
    private long authorId;
    private String image;
    private long adsId;
    private long price;
    private String title;


}
