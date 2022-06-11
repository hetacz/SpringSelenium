package com.hetacz.springtests.resource;

import com.hetacz.springtests.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceTest extends BaseTest {

    @Value("classpath:data/testdata.csv")
    private Resource resource;

    @Value("https://google.com")
    private Resource resource2;

    @Value("https://www.w3.org/TR/PNG/iso_8859-1.txt")
    private Resource resource3;

    @Value("classpath:data/testdata2.csv")
    private Resource resource4;

    @Value("${directory.path}/some.txt")
    private Path path2;

    @Value("${directory.path}")
    private Path path;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void resourceTest() throws IOException {
        Files.readAllLines(resource.getFile().toPath()).forEach(System.out::println);
        String s2 = new String(resource2.getInputStream().readAllBytes());
        System.out.println(s2);
        String s3 = new String(resource3.getInputStream().readAllBytes());
        System.out.println(s3);
        FileCopyUtils.copy(resource3.getInputStream(), Files.newOutputStream(path2));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return Files.readAllLines(resource4.getFile().toPath())
                .stream().map(line -> line.split(","))
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "getData")
    public void resourceTest(String url, String saveAs) throws IOException {
        FileCopyUtils.copy(
                resourceLoader.getResource(url).getInputStream(),
                Files.newOutputStream(path.resolve(saveAs))
        );
    }
}
