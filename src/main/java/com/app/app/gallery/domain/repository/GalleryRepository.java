package com.app.app.gallery.domain.repository;

import com.app.app.gallery.persistence.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GalleryRepository extends JpaRepository<Gallery, Long> {
}
