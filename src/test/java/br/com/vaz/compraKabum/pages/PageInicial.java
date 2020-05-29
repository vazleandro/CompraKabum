package br.com.vaz.compraKabum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageInicial extends BasePages {

	public PageInicial(WebDriver navegador) {
		super(navegador);
	}

	public PageIdentificacao cadastrar() throws InterruptedException {

		navegador.findElement(By.xpath("//*[@id='menuTopo2']/ul/li[1]/a")).click();

		return new PageIdentificacao(navegador);
	}
}