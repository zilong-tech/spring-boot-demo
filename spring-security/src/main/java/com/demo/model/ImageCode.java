package com.demo.model;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * Description:验证码对象
 * <p>
 * Create on 2019/04/20
 *
 * @author zys
 */
@Data
public class ImageCode {

    private BufferedImage image; //图片

    private String code; //验证码

    private LocalDateTime expireTime; //过期时间

    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpire() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
