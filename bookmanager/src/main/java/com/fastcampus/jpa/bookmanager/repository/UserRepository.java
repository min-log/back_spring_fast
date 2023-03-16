package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Users,Long>
public interface UserRepository extends JpaRepository<Users,Long> {
}
