package com.arahansa.springbootlevel1magicuser.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void successMemberIndex() throws Exception {
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/member"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().hasNoErrors())
                .andExpect(view().name("member"));
        MvcResult mvcResult = resultActions.andReturn();

        Map<String, Object> model = mvcResult.getModelAndView().getModel();
        assertThat(model.get("member")).isNotNull();
    }

    @Test
    public void postFaildWithIllegalEmailAddress() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/member")
                .param("username", "실패값").param("password", "1234"))
                .andExpect(model().hasErrors())
                .andExpect(model().attributeHasErrors("member"));
    }


}