package org.senac.aula01.vo;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

public class ErroValidacao {

    private List<String> mensagens = new ArrayList<>();

    public void add(String mensagem) {
        ///
        this.mensagens.add(mensagem);
    }

    public List<String> getMensagens() {
        return mensagens;
    }
}
