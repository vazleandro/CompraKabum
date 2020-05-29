package br.com.vaz.compraKabum.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageListaProdutos extends PagePesquisaProdutos {

	public PageListaProdutos(WebDriver navegador) {
		super(navegador);

	}

	//Map<String, Integer> mapsequenciaItem = new HashMap<String, Integer>();
	Map<String, Double> mapListaProduto = new HashMap<String, Double>();

	WebDriverWait wait = new WebDriverWait(navegador, 30);

	public PageListaProdutos excluirItens(int qtdItensExluir, int qtdItensCarrinho) throws InterruptedException {

		String codigoItemString = null;
		int contador = 2;
		int i = 1;
		//int sequenciaItem = 0;

		List<Double> listaValores = new ArrayList<Double>(mapListaProduto.values());
		
		qtdItensCarrinho += contador;

		carregaHashMap(qtdItensCarrinho);

		while (i < qtdItensExluir) {

			listaValores = new ArrayList<Double>(mapListaProduto.values());
			Collections.sort(listaValores);

			for (Entry<?, ?> mapProduto : mapListaProduto.entrySet()) {

				if (mapProduto.getValue().equals(listaValores.get(listaValores.size() - 1))) {

					codigoItemString = (String) mapProduto.getKey();
					System.out.println("MAP Produto:-> " + mapListaProduto + " codigo do item a ser deletado:-> "
							+ codigoItemString);
					
					wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//*[@id='CorpoCarrinho']//div[@class='box-title box-title--column']//a[@data-id="+codigoItemString+"]"))).click();

				}
			}
		
			mapListaProduto.remove(codigoItemString);
			
			/*

			for (Entry<?, ?> mapSeqItens : mapsequenciaItem.entrySet()) {

				if ((!codigoItemString.equals(null)) && (mapSeqItens.getKey().equals(codigoItemString))) {

					sequenciaItem = (Integer) mapSeqItens.getValue();

					wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//*[@id=\"CorpoCarrinho\"]/div[1]/table/tbody/tr["
									+ sequenciaItem + "]/td[2]/div/div[3]/a[@data-id=\"" + codigoItemString + "\"]")))
					//*[@id="CorpoCarrinho"]//div[@class="box-title box-title--column"]//a[@data-id="89749"]		
					.click();

				}

			}
			*/
			
			carregaHashMap(qtdItensCarrinho - i);
			i++;
			
			//mapsequenciaItem.remove(codigoItemString);
		}

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='CorpoCarrinho']/div[5]/div/a/span"))).click();
												
		return new PageFinalizarCompra(navegador);
		
	}

	public void carregaHashMap(int qtdItensCarrinho) {

		String precoString = null;
		String codigoItemString = null;
		double precoDouble = 0;

		for (int contador = 2; contador < qtdItensCarrinho; contador++) {

			WebElement codigoItem = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//*[@id='CorpoCarrinho']/div[1]/div[" + contador + "]/div[1]/div[2]/a")));

			WebElement valorItem = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='CorpoCarrinho']/div[1]/div[" + contador + "]")));

			codigoItemString = codigoItem.getAttribute("data-id");
			codigoItemString = codigoItemString.replaceAll("\\D", "");

			precoString = valorItem.getAttribute("data-valor");
			precoDouble = Double.parseDouble(precoString);

			System.out.println(">>Codigo " + codigoItemString + ">> ValorItem " + precoDouble);

			mapListaProduto.put(codigoItemString, precoDouble);
			// mapsequenciaItem.put(codigoItemString, contador);

		}
	}
}
