package ru.forum.control;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.forum.Main;
import ru.forum.model.Post;
import ru.forum.service.PostService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class PostControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessagePost() throws Exception {
        when(postService.findById(1)).thenReturn(Post.of("post"));
        mockMvc.perform(get("/post/{id}", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageEdit() throws Exception {
        when(postService.findById(1)).thenReturn(Post.of("post"));
        mockMvc.perform(get("/edit/{id}", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageNew() throws Exception {
        mockMvc.perform(get("/new"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("new"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageSave() throws Exception {
        this.mockMvc.perform(post("/save")
                .param("name", "New post"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(postService).save(argument.capture());
        assertThat(argument.getValue().getName(), is("New post"));
    }
}