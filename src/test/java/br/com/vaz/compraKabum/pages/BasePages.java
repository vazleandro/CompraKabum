package br.com.vaz.compraKabum.pages;

import org.openqa.selenium.WebDriver;

public class BasePages {

	protected WebDriver navegador;

	public BasePages(WebDriver navegador) {
		this.navegador = navegador;
	}
}
