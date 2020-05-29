package br.com.vaz.compraKabum.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.vaz.compraKabum.pages.PageFinalizarCompra;
import br.com.vaz.compraKabum.pages.PageInicial;
import br.com.vaz.compraKabum.pages.PageListaProdutos;
import br.com.vaz.compraKabum.utils.Web;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;

public class CarrinhoDeCompraSteps {
	private WebDriver navegador;
	private int qtdItensCarrinho = 0;

	@Dado("^que o usuario realizou a inclusao de (\\d+) produtos no carrinho$")
	public void queOUsuarioRealizouAInclusaoDeProdutosNoCarrinho(int qtdItens, String itens) throws Throwable {

		qtdItensCarrinho = qtdItens;
		navegador = Web.createChrome("https://www.kabum.com.br");
		new PageInicial(navegador)
		.cadastrar()
		.login()
		.buscaDeProdutos(itens);

	}

	@Quando("^realizar a exclusao dos (\\d+) produtos mais caros$")
	public void realizarAExclusaoDosProdutosMaisCaros(int qtdItensExluir) throws Throwable {

		new PageListaProdutos(navegador)
		.excluirItens(qtdItensExluir, qtdItensCarrinho);
	}

	@Então("^deve devo realizar o fechamento da venda e gerar um boleto para pagamento$")
	public void deveDevoRealizarOFechamentoDaVendaEGerarUmBoletoParaPagamento() throws Throwable {

		new PageFinalizarCompra(navegador)
		.formaDePagamentoBoleto()
		.confirmaPedido();

		String pedidoRealizado = navegador.findElement(By.xpath("//*[@id='bloco-layout-checkout']/div[2]/div[1]/div/div/h1")).getText();
		assertEquals("Pedido realizado com sucesso", pedidoRealizado);

		navegador.quit();

	}

}
