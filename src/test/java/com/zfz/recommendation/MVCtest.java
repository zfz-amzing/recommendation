package com.zfz.recommendation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MVCtest {
    // 声明一个模拟请求的对象
    private MockMvc mockMvc;
    // 需要一个web容器
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void testLogin() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/login").param("username","admin")
                .param("password","123")).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void testRegister() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/register").param("username","laowang")
        .param("password", "123")).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

}
