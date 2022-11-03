package com.bcopstein.Emprestimos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmprestimoTest {

    @Test
    void custoTotalEmprestimoJurosSimples(){
        CalculoDeJuros calc = new CalculoDeJuros();
        Emprestimo emprestimoJS = new Emprestimo.Builder(calc).jurosSimples().build();

        Assertions.assertEquals(1285.0, emprestimoJS.custoTotal());
    }

    @Test
    void custoTotalEmprestimoJurosCompostos(){
        CalculoDeJuros calc = new CalculoDeJuros();
        Emprestimo emprestimoJS = new Emprestimo.Builder(calc).jurosCompostos().build();
        Assertions.assertEquals(1306.1819376531253, emprestimoJS.custoTotal());
    }
    @Test
    void valorParcelaTeste(){
        CalculoDeJuros calc = new CalculoDeJuros();
        Emprestimo emprestimoJS = new Emprestimo.Builder(calc).jurosSimples().build();
        Assertions.assertEquals(257,emprestimoJS.valorParcela());
    }
    @Test
    void valorParcelaCompTeste(){
        CalculoDeJuros calc = new CalculoDeJuros();
        Emprestimo emprestimoJS = new Emprestimo.Builder(calc).jurosCompostos().build();
        Assertions.assertEquals(261.23,emprestimoJS.valorParcela());
    }
}