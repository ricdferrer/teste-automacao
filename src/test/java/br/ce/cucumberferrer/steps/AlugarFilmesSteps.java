package br.ce.cucumberferrer.steps;

import br.ce.cucumberferrer.entities.Filme;
import br.ce.cucumberferrer.entities.NotaAlguel;
import br.ce.cucumberferrer.entities.TipoAluguel;
import br.ce.cucumberferrer.services.AluguelService;
import br.ce.cucumberferrer.utils.DateUtils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AlugarFilmesSteps {

    private Filme filme;
    private final AluguelService aluguel = new AluguelService();
    private NotaAlguel nota;
    private String erro;
    private TipoAluguel tipoAluguel = TipoAluguel.COMUM;

    @Dado("um filme com estoque de {int} unidades")
    public void umFilmeComEstoqueDeUnidades(Integer int1) {
        filme = new Filme();
        filme.setEstoque(int1);
    }

    @Dado("que o preço do aluguel seja R$ {int}")
    public void queOPrecoDoAluguelSeja(Integer int1) {
        filme.setAluguel(int1);
    }

    @Quando("alugar")
    public void alugar() {
        try {
            nota = aluguel.alugar(filme, tipoAluguel);

        } catch (RuntimeException e) {
            erro = e.getMessage();
        }
    }

    @Então("o preço do aluguel será R$ {int}")
    public void oPrecoDoAluguelSera(Integer int1) {
        Assert.assertEquals(int1.intValue(), nota.getPreco());
    }

    @Então("^a data de entrega será em (\\d+) dias?$")
    public void aDataDeEntregaSeraEmDia(Integer int1) {
        Date dataEsperada = DateUtils.obterDataDiferencaDias(int1);
        Date dataReal = nota.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd/MMMM/yyyy");
        Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
    }

    @Então("o estoque do filme será {int} unidade")
    public void oEstoqueDoFilmeSeraUnidade(Integer int1) {
        Assert.assertEquals(int1, filme.getEstoque());
    }

    @Então("não será possível por falta de estoque")
    public void naoSeraPossivelPorFaltaDeEstoque() {
        Assert.assertEquals("Filme sem estoque", erro);
    }

    @Dado("^que o tipo do aluguel seja (extendido|comum|semanal)$")
    public void queOTipoDoAluguelSejaTipo(String tipo) {

        tipoAluguel = tipo.equalsIgnoreCase("semanal") ? TipoAluguel.SEMANAL : tipo.equalsIgnoreCase("extendido") ? TipoAluguel.EXTENDIDO : TipoAluguel.COMUM;
    }

    @Então("a pontuação será de {int} pontos")
    public void aPontuacaoSeraDePontos(Integer int1) {
        Assert.assertEquals(int1, nota.getPontuacao());
    }

}
