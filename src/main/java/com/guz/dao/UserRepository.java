package com.guz.dao;

import com.guz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lguz on 24.03.16.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where not exists (select 1 from u.userCodes userCodes where userCodes.name = :codeName)")
    List<User> findAllWithoutCode(@Param("codeName") String codeName);
}
