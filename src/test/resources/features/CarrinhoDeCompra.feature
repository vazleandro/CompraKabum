# language: pt
@E2E
Funcionalidade: Cliente deve adicionar produtos no carrinho e realizar exlusão na sequencia dos produtos mais caros e finalizar a venda
  Como um usuário
  Eu quero realizar a busca de X produtos e na sequencia realizar a exclusao dos X itens mais caros.
  Para que eu possa finalizar a venda

  Cenário: Cliente deseja adicionar produtos no carrinho e na sequencia realizar a exclusao dos produtos mais caros.
    Dado que o usuario realizou a inclusao de 5 produtos no carrinho
      """
      tv,cabos,impressora,celular,fone de ouvido
           
      """
    Quando realizar a exclusao dos 4 produtos mais caros
    Então deve devo realizar o fechamento da venda e gerar um boleto para pagamento
