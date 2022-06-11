package com.hetacz.springtests.framework.config.scope;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

public class BrowserScope extends SimpleThreadScope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object object = super.get(name, objectFactory);
        try {
            ((WebDriver) object).getWindowHandles();
        } catch (NoSuchSessionException e) {
            super.remove(name);
            object = super.get(name, objectFactory);
        }
        return object;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }
}
