package com.hetacz.springtests.framework.service;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Lazy
@Service
public class Screenshot {

    @Autowired
    private ApplicationContext context;
    @Value("${screenshot.path}")
    private Path path;

    public void takeScreenShot() throws IOException {
        File file = context.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        String fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH-mm-ss", Locale.ROOT));
        FileCopyUtils.copy(file, new File(System.getProperty("user.dir") + path.resolve(fileName + ".png").toFile()));
    }
}
