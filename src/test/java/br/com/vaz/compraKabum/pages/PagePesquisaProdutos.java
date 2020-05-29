package br.com.vaz.compraKabum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagePesquisaProdutos extends FormCadastro {

	public PagePesquisaProdutos(WebDriver navegador) {
		super(navegador);
	}

	WebDriverWait wait = new WebDriverWait(navegador, 30);

	protected static final String DIRETORIO = "C:/Ecommerce/Projeto-Gherkin-Cucumber/compraOnline/target/evidencias/";
	String screenshotArquivo;

	public PagePesquisaProdutos buscaDeProdutos(String itens) throws InterruptedException {

		String[] produtos = itens.split(",");

		for (int i = 0; i < produtos.length; i++) {

			wait.until(ExpectedConditions
					.elementToBeClickable(
					By.xpath("//div[@id='header_busca']//form[@name='busca']//input[@class='sprocura']")))
					.sendKeys(produtos[i].trim());
			
			System.out.println(produtos[i]);

			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@id='header_busca']//input[@id='bt-busca']"))).click();

			adicaoProdutoCarrinho();

		}

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='Corpo_comprejunto']/div[1]/div[2]/div[2]/a/div/span"))).click();
		return new PageListaProdutos(navegador);

	}

	public void adicaoProdutoCarrinho() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='listagem-produtos']/div/div[4]/div/div[2]/div[2]/a[1]/img"))).click();
		Thread.sleep(2500);
	}

}
