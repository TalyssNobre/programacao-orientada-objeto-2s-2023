package br.ucb.poo;

import java.beans.Transient;

public class pessoaTeste {
    pessoa pessoa;

    @BeforeEach
    public void setup(){
        this.pessoa = new pessoa();
    }

    @Test
    public void dizer dizerOlaTest(){
        assertEquals ("Ola, maven", pessoa.dizerOla());
    }
    
}
