package com.studbaza.baza.controllers;

import com.studbaza.baza.BazaApplication;
import com.studbaza.baza.config.BeanConfig;
import com.studbaza.baza.model.Event;
import com.studbaza.baza.model.EventDao;
import com.studbaza.baza.model.EventDaoImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@WebMvcTest(EventController.class)
public class EventControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    EventDaoImpl repository;

    /**
     * Performs get on "/addEvent". Expects addEventForm to be returned and Event in model.
     */
    @Test
    public void addEventGETMethodShouldReturnAddEventFormAndEventInModel() throws Exception {

        this.mockMvc.perform(get("/addEvent")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("addEventForm")).andExpect(model().attributeExists("event"));

    }

    @Test
    public void addEventPOSTMethodHasErrors() throws Exception {
        this.mockMvc.perform(post("/addEvent")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("addEventForm"));
    }

    @Test
    public void addEventPOSTMethodHasNoErrors() throws Exception {
        Event event = new Event();
        event.setContent("dupa");
        this.mockMvc.perform(post("/addEvent").param("event")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("addEventResult"));
    }





}
