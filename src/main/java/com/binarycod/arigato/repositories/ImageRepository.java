package com.binarycod.arigato.repositories;

import com.binarycod.arigato.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}
