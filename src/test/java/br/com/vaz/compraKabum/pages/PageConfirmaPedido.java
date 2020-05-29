package br.com.vaz.compraKabum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.vaz.compraKabum.utils.Generator;
import br.com.vaz.compraKabum.utils.Screenshot;

public class PageConfirmaPedido extends PageFinalizarCompra {

	public PageConfirmaPedido(WebDriver navegador) {
		super(navegador);

	}

	public PageConfirmaPedido confirmaPedido() throws InterruptedException {

		navegador.findElement(By.xpath("//*[@id='CorpoPagamento']/div[6]/div[2]/button")).click();

		screenshotArquivo = DIRETORIO + Generator.dataHoraParaArquivo() + ".png";
		Screenshot.tirar(navegador, screenshotArquivo);

		return this;
	}

}
