package mx.jovannypcg.exceptionhandler.controller;

import mx.jovannypcg.exceptionhandler.controller.exception.ContentNotAllowedException;
import mx.jovannypcg.exceptionhandler.domain.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class PostControllerTests {
    private static String username = "jovannypcg";
    private static final String POSTS_ROUTE = "/users/" + username + "/posts";
    private Post post;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostController postController;

    @Before
    public void init() {
        post = new Post();
        post.setContent("Our breaking political news keeps you covered " +
                "on the latest in US politics including Congress, " +
                "state governors, and the White House.");
    }

    @Test
    public void create_shouldReturnBadRequestDueToContentNotAllowedException() throws Exception {
        this.mockMvc.perform(post(POSTS_ROUTE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void create_shouldThrownContentNotAllowedException() {
        assertThatExceptionOfType(ContentNotAllowedException.class)
                .isThrownBy(() -> postController.create(username, post));
    }
}
