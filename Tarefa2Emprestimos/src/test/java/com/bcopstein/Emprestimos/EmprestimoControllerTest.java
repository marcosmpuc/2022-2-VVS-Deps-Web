package com.bcopstein.Emprestimos;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class EmprestimoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void emprestimoJurosSimples() throws Exception {
        RequestBuilder rb = MockMvcRequestBuilders.get("/emprestimo/jurosSimples?valor=1000&parcelas=5&taxa=0.035");
        MvcResult result = this.mockMvc.perform(rb).andReturn();

        EmprestimoDTO espDto = new EmprestimoDTO(true,false,1000,0.035,5,
                1285.0, 257.0);

        Gson gson = new Gson();
        String espJasonS = gson.toJson(espDto);
        Assertions.assertEquals(espJasonS, result.getResponse().getContentAsString());
    }

    @Test
    void emprestimoJurosCompostos() {
    }
}