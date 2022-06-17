package com.hetacz.springtests.visa;

import com.hetacz.springtests.BaseTest;
import com.hetacz.springtests.entity.User;
import com.hetacz.springtests.pages.visa.VisaRegistrationPO;
import com.hetacz.springtests.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.List;

@Slf4j
public class UserVisaTest extends BaseTest {

    @Autowired
    private UserRepository repository;

    @Autowired
    private VisaRegistrationPO visaRegistrationPO;

    @Test
    public void visaTest() {
        System.out.println(repository.findAll().size());
        repository
                .findById(85)
                .ifPresent(el -> System.out.println(el.getFirstName()));
    }

    @Test
    public void visaTest2() {
        List<User> users = repository.findAll()
                .stream()
                .limit(3)
                .toList();
        users.forEach(user -> {
            visaRegistrationPO.goTo();
            visaRegistrationPO.isAt();
            visaRegistrationPO.fillData(user.getFirstName(),
                    user.getLastName(),
                    user.getFromCountry(),
                    user.getToCountry(),
                    user.getDob().toLocalDate(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getComments()
            );
            visaRegistrationPO.submit();
            System.out.println(visaRegistrationPO.getRequestNumber());
        });
    }

    @Test
    public void visaTest3() {
        List<User> users = repository.findByFirstNameStartingWith("Mi")
                .stream()
                .toList();
        users.forEach(user -> {
            visaRegistrationPO.goTo();
            visaRegistrationPO.isAt();
            visaRegistrationPO.fillData(user.getFirstName(),
                    user.getLastName(),
                    user.getFromCountry(),
                    user.getToCountry(),
                    user.getDob().toLocalDate(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getComments()
            );
            visaRegistrationPO.submit();
            System.out.println(visaRegistrationPO.getRequestNumber());
        });
    }

    @Test
    public void visaTest4() {
        repository
                .findByDobBetween(Date.valueOf("1995-01-01"), Date.valueOf("1999-01-01"))
                .stream()
                .map(User::getFirstName)
                .forEach(System.out::println);
    }

    @DataProvider(name = "getDates") // dont paralellize as creation of Webdriver has already happend
    public User[] getDates() {
        return repository
                .findByDobBetween(Date.valueOf("1995-01-01"), Date.valueOf("1999-01-01"))
                .stream()
                .limit(3)
                .toArray(User[]::new);
    }

    @Test(dataProvider = "getDates")
    public void visaTestDP1(@NotNull User user) {
        visaRegistrationPO.goTo();
        visaRegistrationPO.isAt();
        visaRegistrationPO.fillData(
                user.getFirstName(),
                user.getLastName(),
                user.getFromCountry(),
                user.getToCountry(),
                user.getDob().toLocalDate(),
                user.getEmail(),
                user.getPhone(),
                user.getComments()
        );
        visaRegistrationPO.submit();
        System.out.println(visaRegistrationPO.getRequestNumber());
    }

    @DataProvider(name = "getParametrizedDates") // don't parallelize as creation of Webdriver has already happened
    public User[] getParametrizedDates(@NotNull ITestContext testContext) {
        return repository
                .findByDobBetween(
                        Date.valueOf(testContext.getCurrentXmlTest().getParameter("dobFrom")),
                        Date.valueOf(testContext.getCurrentXmlTest().getParameter("dobTo"))
                ).toArray(User[]::new);
    }

    @Test(dataProvider = "getParametrizedDates")
    public void visaTestDP2(@NotNull User user) {
        visaRegistrationPO.goTo();
        visaRegistrationPO.isAt();
        visaRegistrationPO.fillData(
                user.getFirstName(),
                user.getLastName(),
                user.getFromCountry(),
                user.getToCountry(),
                user.getDob().toLocalDate(),
                user.getEmail(),
                user.getPhone(),
                user.getComments()
        );
        visaRegistrationPO.submit();
        System.out.println(visaRegistrationPO.getRequestNumber());
    }
}
