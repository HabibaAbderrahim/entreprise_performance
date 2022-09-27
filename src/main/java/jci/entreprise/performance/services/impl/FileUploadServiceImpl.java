package jci.entreprise.performance.services.impl;

import jci.entreprise.performance.entities.UploadedFile;
import jci.entreprise.performance.repositories.FileUploadRepository;
import jci.entreprise.performance.services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    private FileUploadRepository fileUploadRepository;
    @Override
    public UploadedFile uploadToDb(MultipartFile file) {
        UploadedFile uploadedFile = new UploadedFile();
        try {
            uploadedFile.setFileData(file.getBytes());
            uploadedFile.setFileType(file.getContentType());
            uploadedFile.setFileName(file.getOriginalFilename());
            UploadedFile uploadedFileToRet = fileUploadRepository.save(uploadedFile);
            return uploadedFileToRet;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UploadedFile downloadFile(String fileId) {
        UploadedFile uploadedFileToRet = fileUploadRepository.getOne(Long.valueOf(fileId));
        return uploadedFileToRet;
    }
}
