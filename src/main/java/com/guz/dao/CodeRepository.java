package com.guz.dao;

import com.guz.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lguz on 24.03.16.
 */
@Repository
public interface CodeRepository extends JpaRepository<Code, Long> {
}
