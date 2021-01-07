package de.myrnet.testshow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Map;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ControllerTestWithDb {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ParameterizedTest
    @CsvSource({"Hans,Hamster", "Else,Schmitt"})
    void getUsers_fromDb(String prename, String lastname) throws Exception {
        mockMvc
                .perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[?(@.prename==\"" + prename + "\")].lastname").value(lastname))
        ;
    }

    @Test
    void addUser_ok() throws Exception {
        addUserRequest("Karl", "Winter")
                .andExpect(status().isOk());

        Map<String, Object> dbUserProps = jdbcTemplate.queryForMap("select * from users where lastname = 'Winter'");
        assertAll(
                () -> assertThat(dbUserProps.get("prename").toString(), is("Karl")),
                () -> assertThat(dbUserProps.get("age").toString(), is("100"))
        );
    }

    private ResultActions addUserRequest(String prename, String lastname) throws Exception {
        return mockMvc
                .perform(post("/user/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"id\": \"" + UUID.randomUUID() + "\"," +
                                "  \"prename\": \"" + prename + "\"," +
                                "  \"lastname\": \"" + lastname + "\"," +
                                "  \"age\": 100" +
                                "}")
                );
    }

}
