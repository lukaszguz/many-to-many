package com.guz.dao;

import com.guz.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by lguz on 24.03.16.
 */
@Repository
public class UserHibernateDao implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> findAllWithoutCode(String codeName) {
        Session session = (Session) entityManager.getDelegate();
        return session.createQuery(
                "SELECT u FROM User u " +
                        "WHERE " +
                        "not exists (select 1 from u.userCodes userCodes where userCodes.name = :codeName)"
        )
                .setString("codeName", codeName)
                .list();
    }
}
