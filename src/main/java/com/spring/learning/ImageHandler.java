package com.spring.learning;

import javax.imageio.ImageIO;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageHandler {
    public static BufferedImage toBufferedImage(byte[] byteImage){
        InputStream is = new ByteArrayInputStream(byteImage);
        try {
            BufferedImage bi = ImageIO.read(is);
            return bi;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BufferedImage toBnW(BufferedImage bufferedimage){
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp op = new ColorConvertOp(cs, null);
        return op.filter(bufferedimage, null);
    }

    public static byte[] toBytes(BufferedImage bufferedimage){
        ByteArrayOutputStream temp = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedimage, "jpg", temp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byte[] bytes = temp.toByteArray();
        return bytes;
    }
}
