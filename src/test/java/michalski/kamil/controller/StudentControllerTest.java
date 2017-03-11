package michalski.kamil.controller;

import net.minidev.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentControllerTest {


    JSONObject dataSet = new JSONObject();


    @Autowired
    private WebApplicationContext webApplicationContext;


    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        dataSet.put("name", "kamil");
        dataSet.put("surname", "kowalczyk");

    }

    @Test(expected = Exception.class)
    public void shouldReturnHttpStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/students/4")).
                andExpect(MockMvcResultMatchers.status().is(500));
    }

    @Test()
    public void shouldReturnHttpStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/students")).
                andExpect(MockMvcResultMatchers.status().is(200));
    }


    @Test
    public void shouldReturnProperStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students/1"))
                .andExpect(jsonPath("$.name", is("Jarek")));
    }


    @Test
    public void shouldReturnListOfThreeStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students"))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void list() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/students").content(String.valueOf(dataSet)).contentType(org.springframework.http.MediaType.APPLICATION_JSON));
        mockMvc.perform(MockMvcRequestBuilders.get("/students"))
                .andExpect(jsonPath("$", hasSize(4)));

    }

}