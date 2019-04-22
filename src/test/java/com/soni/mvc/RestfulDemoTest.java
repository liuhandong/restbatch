package com.soni.mvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.Matchers.*;
//import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.soni.config.PersonJobConfig;
import com.soni.repository.CustomizedRepository;
import com.soni.web.init.WebAppInitializer;

import junit.framework.TestCase;
/**
 * Junit4中的新断言 https://blog.csdn.net/smxjant/article/details/78206435
 * https://blog.csdn.net/Victor_Cindy1/article/details/52126161
 * @author handong.liu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebAppInitializer.class)
@WebAppConfiguration
public class RestfulDemoTest {
	@Autowired 
    private WebApplicationContext ctx;

    private MockMvc mockMvc;
	
	@Before 
	public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

	@Test
    public void testShowHome() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/home"))
                .andExpect(status().isOk());
    }
}
