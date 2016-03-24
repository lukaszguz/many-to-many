package com.guz.dao

import com.guz.ManyToManyApplication
import com.guz.entity.Code
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import spock.lang.Specification

/**
 * Created by lguz on 24.03.16.
 */
@SpringApplicationConfiguration(classes = ManyToManyApplication.class)
class CodeRepositorySpec extends Specification {

    @Autowired
    CodeRepository codeRepository

    def "Should find all codes"() {
        when:
            List<Code> codes = codeRepository.findAll()

        then:
            codes.size() == 3
    }
}
