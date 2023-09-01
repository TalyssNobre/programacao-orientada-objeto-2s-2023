package atividade3;

import java.util.ArrayList;
import java.util.List;

public class estoque {
    private List<objeto> objetos;

    public estoque() {
        objetos = new ArrayList<>();
    }

    public void adicionarObjeto(objeto objeto) {
        objetos.add(objeto);
    }

    public void removerobjeto(objeto objeto) {
        objetos.remove(objeto);
    }

    public List<objeto> listarObjetos() {
        return objetos;
    }
}
