package org.senac.aula01.vo;

public class ValorMedioMarca {

    private String nome;

    private Double valorMedio;

    public ValorMedioMarca(String nome, Double valorMedio) {
        this.nome = nome;
        this.valorMedio = valorMedio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorMedio() {
        return valorMedio;
    }

    public void setValorMedio(Double valorMedio) {
        this.valorMedio = valorMedio;
    }
}
