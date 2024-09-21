package com.app.app.contactUser.domain.repository;

import com.app.app.contactUser.persistence.entity.ContactUser;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ContactUserRepository extends JpaRepository<ContactUser, Long> {
}
