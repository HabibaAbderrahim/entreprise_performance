package jci.entreprise.performance.services;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

public interface ImageService {

    public ImageModel addImage(MultipartFile image) throws IOException;
    public Resource retreiveImage(Long imageId);

}
