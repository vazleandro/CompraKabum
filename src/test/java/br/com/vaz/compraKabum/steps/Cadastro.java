package br.com.vaz.compraKabum.steps;

import org.openqa.selenium.WebDriver;

import br.com.vaz.compraKabum.pages.FormCadastro;
import br.com.vaz.compraKabum.pages.PageInicial;
import br.com.vaz.compraKabum.utils.Web;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class Cadastro {

	private WebDriver navegador;

	@Dado("^que o usuario realizar o primeiro acesso a loja$")
	public void que_o_usuario_realizar_o_primeiro_acesso_a_loja() throws Throwable {

		navegador = Web.createChrome("https://www.kabum.com.br");

	}

	@Quando("^clicar em Login$")
	public void clicar_em_Login() throws Throwable {

		new PageInicial(navegador)
		.cadastrar()
		.realizarCadastro();

	}

	@Então("^o site deve realizar o cadastro completo do usuario para os generos \"([^\"]*)\"$")
	public void oSiteDeveRealizarOCadastroCompletoDoUsuarioParaOsGeneros(String genero) throws Throwable {
		new FormCadastro(navegador)
		.formulario(genero);
		navegador.quit();

	}
}
