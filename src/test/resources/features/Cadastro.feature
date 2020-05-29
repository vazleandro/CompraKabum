# language: pt
@cadastroCliente
Funcionalidade: Cadastrar usuario ao realizar primeiro acesso a loja
  Como um usuário
  Eu quero me cadastrar a loja no primeiro acesso
  Para realizar compras de produtos.

  Esquema do Cenário: Deve realizar cadastro do usuario no primeiro acesso a loja
    Dado que o usuario realizar o primeiro acesso a loja
    Quando clicar em Login
    Então o site deve realizar o cadastro completo do usuario para os generos <genero>

    Exemplos: 
      | genero      |
      | "Masculino" |
      | "Feminino"  |