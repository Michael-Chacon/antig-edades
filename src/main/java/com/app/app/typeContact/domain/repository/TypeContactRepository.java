package com.app.app.typeContact.domain.repository;

import com.app.app.typeContact.persistence.TypeContact;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TypeContactRepository extends JpaRepository<TypeContact, Long> {
}
