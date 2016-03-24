package com.guz.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity()
public class User {

    @Id
    @GeneratedValue
    private Long userId;
    private String name;

    @ManyToMany
    @JoinTable(name = "USER_CODES",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "CODE_ID")
            }
    )
    private Set<Code> userCodes = new HashSet<Code>();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Code> getUserCodes() {
        return userCodes;
    }

    public void setUserCodes(Set<Code> userCodes) {
        this.userCodes = userCodes;
    }
}