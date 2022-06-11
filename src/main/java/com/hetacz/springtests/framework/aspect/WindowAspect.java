package com.hetacz.springtests.framework.aspect;

import com.hetacz.springtests.framework.annotations.Window;
import com.hetacz.springtests.framework.service.WindowHandle;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private WindowHandle handle;

    @Before("@target(window) && within(com.hetacz.springtests..*))")
    public void before(@NotNull Window window) {
        handle.switchByTitle(window.value());
    }

    @After("@target(window) && within(com.hetacz.springtests..*))")
    public void after(@NotNull Window window) {
        handle.switchByIndex(0);
    }
}
