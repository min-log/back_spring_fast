package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Users,Long>
public interface UserRepository extends JpaRepository<User,Long> { //user, id값
}
