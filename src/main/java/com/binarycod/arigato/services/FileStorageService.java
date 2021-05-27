package com.binarycod.arigato.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

@Service
public interface FileStorageService {
    void init();
    void store(MultipartFile file);
    Stream<Path> loadAll();
}
