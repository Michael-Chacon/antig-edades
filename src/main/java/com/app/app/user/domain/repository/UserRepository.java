package com.app.app.user.domain.repository;

import com.app.app.user.persistence.Users;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<Users, Long> {
}
