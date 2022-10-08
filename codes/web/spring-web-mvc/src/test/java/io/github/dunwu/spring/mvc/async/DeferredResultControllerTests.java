package io.github.dunwu.spring.mvc.async;

import io.github.dunwu.spring.mvc.AbstractContextControllerTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

public class DeferredResultControllerTests extends AbstractContextControllerTests {

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void responseBody() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/async/deferred-result/response-body"))
                                          .andExpect(status().isOk()).andExpect(request().asyncStarted())
                                          .andExpect(request().asyncResult("Deferred result")).andReturn();

        this.mockMvc.perform(asyncDispatch(mvcResult)).andExpect(status().isOk())
                    .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                    .andExpect(content().string("Deferred result"));
    }

    @Test
    public void view() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/async/deferred-result/model-and-view"))
                                          .andExpect(status().isOk()).andExpect(request().asyncStarted())
                                          .andExpect(request().asyncResult(instanceOf(ModelAndView.class))).andReturn();

        this.mockMvc.perform(asyncDispatch(mvcResult)).andExpect(status().isOk())
                    .andExpect(forwardedUrl("/WEB-INF/views/views/html.jsp"))
                    .andExpect(model().attributeExists("javaBean"));
    }

    @Test
    public void exception() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/async/deferred-result/exception"))
                                          .andExpect(status().isOk())
                                          .andExpect(request().asyncStarted())
                                          .andExpect(request().asyncResult(instanceOf(IllegalStateException.class)))
                                          .andReturn();

        this.mockMvc.perform(asyncDispatch(mvcResult)).andExpect(status().isOk())
                    .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                    .andExpect(content().string("Handled exception: DeferredResult error"));
    }

}
