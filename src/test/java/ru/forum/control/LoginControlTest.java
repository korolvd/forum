package ru.forum.control;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.forum.Main;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class LoginControlTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage()  throws Exception {
        this.mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(model().attribute("errorMessage", is(nullValue())));
    }

    @Test
    @WithMockUser
    public void shouldReturnErrorMessage()  throws Exception {
        this.mockMvc.perform(get("/login")
                        .param("error", "true"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(model().attribute("errorMessage", is("Username or Password is incorrect!")));
    }

}