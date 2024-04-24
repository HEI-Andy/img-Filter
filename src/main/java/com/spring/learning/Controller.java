package com.spring.learning;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;


@RestController
public class Controller {

    @PostMapping(
            value= "/image",
            produces = {MediaType.IMAGE_JPEG_VALUE}
    )
    public @ResponseBody byte[] postBody(@RequestBody byte[] file) {
        BufferedImage bufferedColoredImage = ImageHandler.toBufferedImage(file);
        BufferedImage bufferedBNWImage = ImageHandler.toBnW(bufferedColoredImage);
        return ImageHandler.toBytes(bufferedBNWImage);
    }
}
