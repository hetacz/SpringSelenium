package com.hetacz.springtests.framework.aspect;

import com.hetacz.springtests.framework.annotations.TakesSS;
import com.hetacz.springtests.framework.service.Screenshot;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class ScreenshotAspect {

    @Autowired
    private Screenshot screenshot;

    @After("@annotation(takesSS)")
    public void after(@NotNull TakesSS takesSS) throws IOException {
        screenshot.takeScreenShot();
    }
}
