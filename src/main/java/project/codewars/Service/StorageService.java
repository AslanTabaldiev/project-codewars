package project.codewars.Service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    String uploadFile(MultipartFile file);

    byte[] downloadFile(String filename);

    void deleteFile(String filename);
}
