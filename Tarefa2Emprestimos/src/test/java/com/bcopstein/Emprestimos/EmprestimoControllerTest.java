package com.bcopstein.Emprestimos;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest
class EmprestimoControllerTest {

    @InjectMocks
    private EmprestimoController emprestimoController;

    @Test
    void emprestimoJurosSimples() {
        EmprestimoDTO dtoComp = new EmprestimoDTO(true,false,1000,0.035,5,
                1285.0, 257.0);
        assertThat(emprestimoController.emprestimoJurosSimples(1000.0,5,0.035)).isEqualToComparingFieldByFieldRecursively(dtoComp);

    }

    @Test
    void emprestimoJurosCompostos() {
    }
}