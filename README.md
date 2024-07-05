# TESTE PRÁTICO PROGRAMAÇÃO
![imageProject](imageProject.jpg)
## Descrição do Projeto

Este projeto em Java simula a gestão de funcionários de uma indústria, atendendo aos seguintes requisitos:

1. **Classe Pessoa**: com os atributos `nome` (String) e `dataNascimento` (LocalDate).
2. **Classe Funcionário**: estendendo a classe Pessoa, com os atributos `salario` (BigDecimal) e `funcao` (String).
3. **Classe Principal**: responsável por executar as seguintes ações:
    1. Inserir todos os funcionários, na mesma ordem e com as informações fornecidas.
    2. Remover o funcionário "João" da lista.
    3. Imprimir todos os funcionários com todas suas informações, com:
        - Datas no formato `dd/MM/yyyy`.
        - Valores numéricos formatados com separador de milhar como ponto e decimal como vírgula.
    4. Aumentar o salário dos funcionários em 10% e atualizar a lista de funcionários com o novo valor.
    5. Agrupar os funcionários por função em um `Map`, sendo a chave a `funcao` e o valor a `lista de funcionários`.
    6. Imprimir os funcionários, agrupados por função.
    7. Imprimir os funcionários que fazem aniversário nos meses 10 e 12.
    8. Imprimir o funcionário com a maior idade, exibindo os atributos: nome e idade.
    9. Imprimir a lista de funcionários por ordem alfabética.
    10. Imprimir o total dos salários dos funcionários.
    11. Imprimir quantos salários mínimos cada funcionário recebe, considerando que o salário mínimo é R$1212,00.
