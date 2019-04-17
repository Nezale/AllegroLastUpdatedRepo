package com.example.demo.Repo;

import com.example.demo.repo.Repo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.awt.*;

import static org.junit.Assert.*;

public class RepoControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp(){
        super.setUp();
    }

    @Test
    public void getLastUpdatedRepoTest() throws Exception {
        String uri = "/last-updated";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        assertEquals(200, status);

        String content = mvcResult.getResponse().getContentAsString();

        Repo repo = super.mapFromJson(content, Repo.class);
        assertNotNull(repo);

    }

}
