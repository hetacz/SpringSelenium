package com.hetacz.springtests.scope;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Salary {

    @Getter
    @Setter
    private int amount;
}
