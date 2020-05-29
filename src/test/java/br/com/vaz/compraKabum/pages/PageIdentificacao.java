package br.com.vaz.compraKabum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.vaz.compraKabum.utils.Web;

public class PageIdentificacao extends PageInicial {

	public PageIdentificacao(WebDriver navegador) {
		super(navegador);
	}

	PageLogin loga = new PageLogin(navegador);

	public FormCadastro realizarCadastro() throws InterruptedException {

		navegador.findElement(By.xpath("//*[@id=\"textfield\"]")).sendKeys("teste@yahoo.com.br");
		navegador.findElement(By.xpath("//*[@id=\"textfield2\"]")).sendKeys("123456789#");
		navegador.findElement(By.xpath("//*[@id=\"textfield3\"]")).sendKeys("123456789#");
		navegador.findElement(By.xpath("//*[@id=\"cpfCnpj\"]")).sendKeys(Web.geraCPF());

		Web.clear(navegador, "textfield4");
		navegador.findElement(By.id("textfield4")).sendKeys("13042");

		Web.clear(navegador, "textfield5");
		navegador.findElement(By.id("textfield5")).sendKeys("105");
		navegador.findElement(By.xpath("//*[@id=\"Table_3\"]/tbody/tr[2]/td/input[2]")).click();

		return new FormCadastro(navegador);
	}

	public PagePesquisaProdutos login() throws InterruptedException {
		loga.Logar(navegador);
		return new PagePesquisaProdutos(navegador);

	}

}
