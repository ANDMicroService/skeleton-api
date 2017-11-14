package com.andmicroservice.skeleton.resources;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestResource.class)
public class TestResourceTest {

    private MockMvc mockMvc;

    @Before public void setUp() {
        MockitoAnnotations.initMocks(this);
        TestResource testResource = new TestResource();
        this.mockMvc = MockMvcBuilders.standaloneSetup(testResource).build();
    }

    @Test
    public void testApi() throws Exception {
        this.mockMvc
                .perform(get("/test").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("TestResource is up and running!")));
    }
}
