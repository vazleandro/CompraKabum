package br.com.vaz.compraKabum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.vaz.compraKabum.utils.Web;

public class FormCadastro extends BasePages {

	public FormCadastro(WebDriver navegador) {
		super(navegador);
	}

	public FormCadastro formulario(String args) throws InterruptedException {

		if (args.equals("Masculino")) {

			navegador.findElement(By.xpath("//*[@id=\"textfield9\"]")).sendKeys("Manoel");
			navegador.findElement(By.xpath("//*[@id=\"textfield10\"]")).sendKeys("da Silva Souza");
		} else {
			navegador.findElement(By.xpath("//*[@id=\"textfield9\"]")).sendKeys("Luciana");
			navegador.findElement(By.xpath("//*[@id=\"textfield10\"]")).sendKeys("da Silva");

		}

		navegador.findElement(By.xpath("//input[@name='rg_ie']")).sendKeys("888886669");

		Web.select(navegador, "select4", "22");
		Web.select(navegador, "select5", "Janeiro");
		Web.select(navegador, "select6", "1988");
		// Web.select(navegador, "select7", "Masculino");
		Web.select(navegador, "select7", args);

		Web.clear(navegador, "textfield21");
		navegador.findElement(By.id("textfield21")).sendKeys("19");

		Web.clear(navegador, "textfield27");
		navegador.findElement(By.id("textfield27")).sendKeys("32324596");

		Web.clear(navegador, "textfield28");
		navegador.findElement(By.id("textfield28")).sendKeys("18");

		Web.clear(navegador, "textfield29");
		navegador.findElement(By.id("textfield29")).sendKeys("996781235");

		navegador.findElement(By.id("textfield23")).sendKeys("4300");
		navegador.findElement(By.id("textfield18")).sendKeys(" CASA");

		navegador.findElement(By.id("textfield25")).sendKeys("Próximo ao supermecado Extra Abolicao");

		Web.select(navegador, "select10", "Não");
		Web.select(navegador, "select11", "Google");

		navegador.findElement(By.id("checkbox0")).click();

		return new PagePesquisaProdutos(navegador);

	}
}
