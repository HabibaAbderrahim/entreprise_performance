package jci.entreprise.performance.services;

import jci.entreprise.performance.entities.UploadedFile;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    public UploadedFile uploadToDb(MultipartFile file);
    public UploadedFile downloadFile(String fileId);
}
