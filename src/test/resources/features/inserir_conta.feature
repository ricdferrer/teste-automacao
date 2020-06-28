Feature: Cadastro de contas

  Como um usuário
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada

  Scenario: Deve inserir uma conta com sucesso
    Given que estou acessando a aplicação
    When informo o usuário "a@a"
    And a senha "a"
    And seleciono entrar
    Then visualizo a página inicial
    When seleciono Contas
    And seleciono Adicionar
    And informo a conta "Conta de Teste"
    And seleciono Salvar
    Then a conta é inserida com sucesso

  Scenario: Não deve inserir uma conta sem nome
    Given que estou acessando a aplicação
    When informo o usuário "a@a"
    And a senha "a"
    And seleciono entrar
    Then visualizo a página inicial
    When seleciono Contas
    And seleciono Adicionar
    And seleciono Salvar
    Then sou notificar que o nome da conta é obrigatório

  Scenario: Não deve inserir uma conta com nome já existente
    Given que estou acessando a aplicação
    When informo o usuário "a@a"
    And a senha "a"
    And seleciono entrar
    Then visualizo a página inicial
    When seleciono Contas
    And seleciono Adicionar
    And informo a conta "Conta de Teste"
    And seleciono Salvar
    Then sou notificado que já existe uma conta com esse nome