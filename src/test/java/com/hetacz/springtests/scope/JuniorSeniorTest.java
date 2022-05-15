package com.hetacz.springtests.scope;

import com.hetacz.springtests.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class JuniorSeniorTest extends BaseTest {

    @Autowired
    private JuniorEng junior;

    @Autowired
    private SeniorEng senior;

    @Test
    public void scopeTest() {
        junior.setAmount(100);
        System.out.println("Junior:: " + junior.getSalary().getAmount());
        senior.setAmount(200);
        System.out.println("Senior:: " + senior.getSalary().getAmount());
        System.out.println("Junior:: " + junior.getSalary().getAmount());
    }
}
