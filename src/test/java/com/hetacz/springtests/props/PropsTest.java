package com.hetacz.springtests.props;

import com.hetacz.springtests.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class PropsTest extends BaseTest {

    @Autowired
    private ResourceLoader loader;

    @Test
    public void propsTest() throws IOException {
        Properties properties = PropertiesLoaderUtils.loadProperties(loader.getResource("my.properties"));
        log.info(String.valueOf(properties));
    }
}
