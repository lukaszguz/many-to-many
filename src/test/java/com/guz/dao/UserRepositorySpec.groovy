package com.guz.dao

import com.guz.ManyToManyApplication
import com.guz.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import spock.lang.Specification
import spock.lang.Unroll

import javax.transaction.Transactional

/**
 * Created by lguz on 24.03.16.
 */
@SpringApplicationConfiguration(classes = ManyToManyApplication.class)
class UserRepositorySpec extends Specification {

    @Autowired
    UserRepository userRepository

    def "Should find one user by id"() {
        given:
            Long userId = 1L

        when:
            User user = userRepository.findOne(userId)

        then:
            user.userId == userId
    }

    @Transactional
    @Unroll
    def "Should find all users"() {
        when:
            List<User> users = userRepository.findAll()

        then:
            users.size() == 2
    }

    @Transactional
    @Unroll
    def "Should find all users without code 3 - Mail"() {
        given:
            Long userId = 1L
            String codeName = 'Mail'
            when:
            List<User> users = userRepository.findAllWithoutCode(codeName)
            println users.userCodes.name

        then:
            users.userId == [userId]
            users.userCodes
                    .stream()
                    .flatMap { userCodes -> userCodes.stream() }
                    .map { userCode -> userCode.name }
                    .noneMatch {String name -> name == 'Mail' }
    }
}
