package br.ce.cucumberferrer.entities;

import java.util.Date;

public class NotaAlguel {
    private int preco;
    private Date dataEntrega;
    private Integer pontuacao;

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date time) {
        dataEntrega = time;
    }

    public Integer getPontuacao() { return pontuacao;  }

    public void setPontuacao(int pontuacao) { this.pontuacao = pontuacao;  }

}
