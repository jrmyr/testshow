package de.myrnet.testshow;

import de.myrnet.testshow.domain.UserEntity;
import de.myrnet.testshow.domain.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepo userRepoMock;

    @BeforeEach
    public void beforeEach() {
        when(userRepoMock.findAll()).thenReturn(List.of(
                new UserEntity(UUID.randomUUID(), "Hans", "Hamster", 43),
                new UserEntity(UUID.randomUUID(), "Else", "Schmitt", 23)
        ));
    }

    @ParameterizedTest
    @CsvSource({"0,Hans,Hamster", "1,Else,Schmitt"})
    void getUsers_json_ok_1(int position, String prename, String lastname) throws Exception {
        mockMvc
                .perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[" + position + "].prename").value(prename))
                .andExpect(jsonPath("$.[" + position + "].lastname").value(lastname))
                ;
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hamster", "Schmitt" /*, "Gollum"*/})
    void getUsers_basic_ok_3(String input) throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(get("/users"))
                .andExpect(status().isOk())
                .andReturn();
        String responseBody = mvcResult.getResponse().getContentAsString();

        assertThat(responseBody, containsString(input));
    }

    @Test
    void getUsers_basic_ok_2() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(get("/users"))
                .andExpect(status().isOk())
                .andReturn();
        String responseBody = mvcResult.getResponse().getContentAsString();

        assertAll(
                () -> assertTrue(responseBody.contains("Hamster")),
                () -> assertTrue(responseBody.contains("Schmitt"))
        );
    }

    @Test
    void getUsers_basic_ok_1() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(get("/users"))
                .andExpect(status().isOk())
                .andReturn();
        String responseBody = mvcResult.getResponse().getContentAsString();

        assertTrue(responseBody.contains("Hans"));
        assertTrue(responseBody.contains("Else"));
    }
}
