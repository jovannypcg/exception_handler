package mx.jovannypcg.exceptionhandler.controller;

import mx.jovannypcg.exceptionhandler.controller.exception.ContentNotAllowedException;
import mx.jovannypcg.exceptionhandler.domain.Comment;
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
public class CommentControllerTests {
    private static String username = "jovannypcg";
    private static Long postId = 234L;
    private static final String COMMENTS_ROUTE = "/users/" + username + "/posts/" + postId + "/comments";

    private Comment comment;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CommentController commentController;

    @Before
    public void init() {
        comment = new Comment();
        comment.setContent("News about terrorism including commentary and" +
                "archival articles published in The New York Times.");
    }

    @Test
    public void create_shouldReturnBadRequestDueToContentNotAllowedException() throws Exception {
        this.mockMvc.perform(post(COMMENTS_ROUTE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void create_shouldThrowContentNotAllowedException() {
        assertThatExceptionOfType(ContentNotAllowedException.class)
                .isThrownBy(() -> commentController.create(username, postId, comment));
    }
}
