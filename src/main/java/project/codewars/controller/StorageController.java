package project.codewars.controller;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.codewars.Service.StorageService;

@RestController
@AllArgsConstructor
@RequestMapping("/file")
public class StorageController {

    private final StorageService storageService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam(value = "file") MultipartFile file) {
        return storageService.uploadFile(file);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
        byte[] data = storageService.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    @DeleteMapping("/delete/{fileName}")
    public String deleteFile(@PathVariable String fileName) {
        storageService.deleteFile(fileName);
        return "Image deleted successfully!";
    }
}
