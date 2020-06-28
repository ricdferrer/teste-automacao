package br.ce.cucumberferrer.services;

import br.ce.cucumberferrer.entities.Filme;
import br.ce.cucumberferrer.entities.NotaAlguel;
import br.ce.cucumberferrer.entities.TipoAluguel;
import br.ce.cucumberferrer.utils.DateUtils;

public class AluguelService {

    public NotaAlguel alugar(Filme filme, TipoAluguel tipo) {
        if (filme.getEstoque() == 0) throw new RuntimeException("Filme sem estoque");

        NotaAlguel nota = new NotaAlguel();

        switch (tipo) {
            case COMUM -> {
                nota.setPreco(filme.getAluguel());
                nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
                nota.setPontuacao(1);
            }
            case EXTENDIDO -> {
                nota.setPreco(filme.getAluguel() * 2);
                nota.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
                nota.setPontuacao(2);
            }
            case SEMANAL -> {
                nota.setPreco(filme.getAluguel() * 3);
                nota.setDataEntrega(DateUtils.obterDataDiferencaDias(7));
                nota.setPontuacao(3);
            }
        }

        filme.setEstoque(filme.getEstoque() - 1);

        return nota;
    }

}
