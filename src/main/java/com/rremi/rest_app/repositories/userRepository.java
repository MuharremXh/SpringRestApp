package com.rremi.rest_app.repositories;

import com.rremi.rest_app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User,Long> {
}
