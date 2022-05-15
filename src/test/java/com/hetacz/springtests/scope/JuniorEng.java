package com.hetacz.springtests.scope;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JuniorEng {

    @Getter
    @Autowired
    private Salary salary;

    public void setAmount(int amount) {
        salary.setAmount(amount);
    }
}
