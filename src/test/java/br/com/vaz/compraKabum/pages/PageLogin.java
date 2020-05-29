package br.com.vaz.compraKabum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin extends FormCadastro {

	public PageLogin(WebDriver navegador) {
		super(navegador);

	}

	public PageLogin Logar(WebDriver navegador) throws InterruptedException {

		navegador.findElement(By.id("textfield12")).sendKeys("testercucumber11@gmail.com");
		navegador.findElement(By.id("textfield15")).sendKeys("Laa123");
		navegador.findElement(By.xpath("//*[@id=\"Table_3\"]/tbody/tr[2]/td/p[5]/input")).click();
		
		return this;
	}

}
