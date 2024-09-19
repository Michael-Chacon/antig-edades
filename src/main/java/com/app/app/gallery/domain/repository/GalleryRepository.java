package com.app.app.gallery.domain.repository;

import com.app.app.categoria.persistence.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GalleryRepository extends JpaRepository<Category, Long> {
}
