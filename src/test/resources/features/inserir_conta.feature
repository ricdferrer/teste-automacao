Feature: Cadastro de contas

  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa acessar minha aplicação

  Scenario: Deve inserir uma conta com sucesso
    Given que estou acessando a aplicação
    When informo o usuário "a@a"
    And a senha "a"
    And seleciono entrar
    Then visualizo a página inicial
    When seleciono Contas
    And seleciono Adicionar
    And informo a conta "Conta de Teste Automação"
    And seleciono Salvar
    Then a conta é inserida com sucesso