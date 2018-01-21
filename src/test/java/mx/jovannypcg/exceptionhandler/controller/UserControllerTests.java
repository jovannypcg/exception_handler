package mx.jovannypcg.exceptionhandler.controller;

import mx.jovannypcg.exceptionhandler.controller.exception.UserNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class UserControllerTests {
    private static final String USERS_ROUTE = "/users";

    private String username = "jovannypcg";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserController userController;

    @Test
    public void get_shouldReturnNotFoundStatusDueToUserNotFoundException() throws Exception {
        this.mockMvc.perform(get(USERS_ROUTE + "/" + username))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void get_shouldThrowUserNotFoundException() {
        assertThatExceptionOfType(UserNotFoundException.class).isThrownBy(() -> userController.get(username));
    }
}
