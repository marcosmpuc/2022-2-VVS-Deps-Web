package com.bcopstein.Emprestimos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculoDeJurosTest {

    @Test
    void setSeguroFalse() {
        CalculoDeJuros calc = new CalculoDeJuros();
        calc.setSeguro(false);
        Assertions.assertFalse(calc.comSeguro());
    }
    @Test
    void seguroTrue() {
        CalculoDeJuros calc = new CalculoDeJuros();
        Assertions.assertTrue(calc.comSeguro());
    }

    @Test
    void setTaxaSeguro() {
    }

    @Test
    void getTaxaSeguro() {
    }

    @ParameterizedTest
    @CsvSource({
            "1000,5,6,30060",
            "6000,3,3,54180"
    })
    void jurosSimplesComSeguroTeste(double valor, double taxa, int nroParcelas, double resp) {
        CalculoDeJuros calc = new CalculoDeJuros();
        Assertions.assertEquals(resp, calc.jurosEmprestimoJurosSimples(valor,taxa,nroParcelas));
    }

    @ParameterizedTest
    @CsvSource({
            "1000,5,6,30000",
            "6000,3,3,54000"
    })
    void jurosSimplesSemSeguroTeste(double valor, double taxa, int nroParcelas, double resp) {
        CalculoDeJuros calc = new CalculoDeJuros();
        calc.setSeguro(false);
        Assertions.assertEquals(resp, calc.jurosEmprestimoJurosSimples(valor,taxa,nroParcelas));
    }

    @ParameterizedTest
    @CsvSource({
            "10000,0.05,24,30489.34",
            "20000,0.05,30,94869.82"
    })
    void jurosCompostosComSeguroTeste(double valor, double taxa, int nroParcelas, double resp) {
        CalculoDeJuros calc = new CalculoDeJuros();
        Assertions.assertEquals(resp, calc.jurosEmprestimoJurosCompostos(valor,taxa,nroParcelas));
    }
}