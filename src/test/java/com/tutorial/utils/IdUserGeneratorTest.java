package com.tutorial.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
        "file:src/main/webapp/WEB-INF/applicationContext.xml",
        "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"
})
public class IdUserGeneratorTest {

    @Inject
    @Qualifier(value = "idGenerator")
    private IdUserGenerator idGenerator;

    @Test
    public void getUniqueUserID() throws Exception {
        System.out.println("GENERATE ID : " + idGenerator.getUniqueUserID());
    }

}