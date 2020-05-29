package br.com.vaz.compraKabum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFinalizarCompra extends PageListaProdutos {

	public PageFinalizarCompra(WebDriver navegador) {
		super(navegador);

	}

	WebDriverWait wait = new WebDriverWait(navegador, 20);

	public PageConfirmaPedido formaDePagamentoBoleto() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='botao-tab1']"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("botao-boleto-pagar"))).click();

		return new PageConfirmaPedido(navegador);
	}
}
