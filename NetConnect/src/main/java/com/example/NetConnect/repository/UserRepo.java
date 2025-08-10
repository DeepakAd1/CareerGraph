package com.example.NetConnect.repository;

import com.example.NetConnect.object.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Query(value = "SELECT username FROM users WHERE username LIKE :pattern ORDER BY LENGTH(username) DESC, username DESC LIMIT 1", nativeQuery = true)
    String findLastSimilarUsername(@Param("pattern") String pattern);

    long countByUserName(String userName);
}
