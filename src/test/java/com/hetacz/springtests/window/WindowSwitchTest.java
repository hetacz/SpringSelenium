package com.hetacz.springtests.window;

import com.hetacz.springtests.BaseTest;
import com.hetacz.springtests.framework.service.WindowHandle;
import com.hetacz.springtests.pages.window.MainPage;
import com.hetacz.springtests.pages.window.PageA;
import com.hetacz.springtests.pages.window.PageB;
import com.hetacz.springtests.pages.window.PageC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@TestPropertySource(properties = "browser=firefox")
public class WindowSwitchTest extends BaseTest {

    @Autowired
    private MainPage mainPage;

    @Autowired
    private PageA pageA;

    @Autowired
    private PageB pageB;

    @Autowired
    private PageC pageC;

    @BeforeClass
    public void setup() {
        mainPage.goTo();
        mainPage.isAt();
        mainPage.launchAllWindows();
    }

    @Test(dataProvider = "getData")
    public void switchTest(int index) {
        pageA.addToArea("%d\n".formatted(index));
        pageB.addToArea("%d\n".formatted(index * 2));
        pageC.addToArea("%d\n".formatted(index * 3));
    }

    @DataProvider
    public Integer[] getData() {
        return new Integer[] {3,4,1,5,6,2};
    }
}
