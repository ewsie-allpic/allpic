package com.ewsie.allpic.image.service;

import com.ewsie.allpic.image.model.ImageDTO;
import com.ewsie.allpic.user.model.UserDTO;

import java.util.List;

public interface ImageDTOService {
    ImageDTO findById(Long id);

    ImageDTO findByToken(String token);

    List<ImageDTO> findAllUploadedBy(UserDTO uploader);

    List<ImageDTO> findAllOrderByUploadedTimeDesc();

    ImageDTO save(ImageDTO image);
}
