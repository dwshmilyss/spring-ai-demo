package com.example.demo;

import org.springframework.ai.image.*;
import org.springframework.stereotype.Service;
/**
 * @author david.duan
 * @packageName com.example.demo
 * @className ImageService
 * @date 2025/2/25
 * @description
 */
@Service
public class ImageService {
    private final ImageClient imageClient;

    public ImageService(ImageClient imageClient) {
        this.imageClient = imageClient;
    }

    public ImageResponse generateImage(String prompt) {
        ImageOptions imageOptions = ImageOptionsBuilder.builder()
                .withN(1) //Number of images to be generated
                .withHeight(1024)
                .withWidth(1024)
                .build();

        // This can be used for some additional options specific to OpenAI, but it is not portable abstraction unlike 'ImageOptions' above,
        // so it will need to be updated when switching AI models
        //    OpenAiImageOptions openAiImageOptions = OpenAiImageOptions.builder()
        //    .withQuality("hd")
        //    .withN(1)
        //    .withHeight(1024)
        //    .withWidth(1024)
        //    .build();


        return imageClient.call(new ImagePrompt(prompt, imageOptions));
    }
}
