package br.com.vaz.compraKabum.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Web {

	private static final String BASE_URL_CONSULTA_MUNICIPIOS = "http://servicodados.ibge.gov.br/api/v1/localidades/municipios/";
	private static final String BASE_URL_CONSULTA_CEP = "http://apps.widenet.com.br/busca-cep/api/cep.json";

	public static WebDriver createChrome(String site) {

		/** abrindo o navegador **/

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();
		
		/** navegar para a pagina **/

		navegador.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		navegador.get(site);
		navegador.manage().window().maximize();

		return navegador;
	}

	public static WebDriver clear(WebDriver navegador, String id) {

		navegador.findElement(By.id(id)).clear();

		return navegador;
	}

	public static WebDriver select(WebDriver navegador, String id, String conteudo) {

		Select selecao = new Select(navegador.findElement(By.id(id)));
		selecao.selectByVisibleText(conteudo);
		return navegador;

	}

	public static String geraCPF() {
		String iniciais = "";
		Integer numero;
		for (int i = 0; i < 9; i++) {
			numero = new Integer((int) (Math.random() * 10));
			iniciais += numero.toString();
		}
		return iniciais + calcDigVerif(iniciais);
	}

	private static String calcDigVerif(String num) {
		Integer primDig, segDig;
		int soma = 0, peso = 10;
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
		if (soma % 11 == 0 | soma % 11 == 1)
			primDig = new Integer(0);
		else
			primDig = new Integer(11 - (soma % 11));
		soma = 0;
		peso = 11;
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
		soma += primDig.intValue() * 2;
		if (soma % 11 == 0 | soma % 11 == 1)
			segDig = new Integer(0);
		else
			segDig = new Integer(11 - (soma % 11));
		return primDig.toString() + segDig.toString();
	}

	public static String consultaMunicipio(int codigoMunicipio) {

		String uriBase = BASE_URL_CONSULTA_MUNICIPIOS + codigoMunicipio;
		return uriBase;
	}

	public static String consultaCep(String cep) {
		String uriBase = BASE_URL_CONSULTA_CEP;
		return uriBase;
	}
	
}
