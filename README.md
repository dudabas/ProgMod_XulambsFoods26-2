# Xulambs Pizza → Xulambs Foods (base para a Iteração 6)

Repositório de partida da disciplina **Programação Modular** (CDIA – Campus Lourdes), 2026-2.

Esta versão contém o sistema **Xulambs Pizza** até a etapa com:
- pizzas, bordas e pedidos;
- pedidos **local** e para **entrega**;
- tratamento de **exceções**.

**Não** inclui ainda bebidas, sobremesas nem a interface de produto da Iteração 6 — isso fará parte da atividade.

---

# 🍕 Xulambs Pizza 🍕

## Versão 0.1

**Xulambs Pizza** é uma pizzaria que será inaugurada em breve, com grandes expectativas. Inicialmente, o negócio precisa **automatizar o cálculo do preço de venda** das pizzas. O modelo de vendas segue uma **lógica simplificada**: 

  - Não existem pizzas de sabores pré-definidos.
  - A pizza tem preço inicial de `R$29`.
  - O cliente pode adicionar até `8` ingredientes em uma pizza. Adicionais têm custo fixo: cada um custa `R$5`.
  - O sistema precisa registrar vendas de pizzas isoladas e emitir um cupom de venda (relatório) para cada pizza vendida. O cupom deve conter a descrição da pizza e detalhamento do valor pago.

## Versão 0.2

A pizzaria percebeu que é melhor agrupar as vendas de pizzas em **pedidos**.
  
  - As pizzas só podem ser vendidas quando incluídas em pedidos.
  - Um pedido pode receber novas pizzas até que seja fechado.
  - O pedido deve ser identificado por um número único, armazenar sua data e gerar um cupom de venda que inclui detalhes de cada pizza e o valor total a ser pago pelo cliente.

## Versão 0.3

Para atender um desejo de muitos de seus clientes, a Xulambs Pizza incluiu uma opção no cardápio: **bordas recheadas** nas pizzas. Uma pizza só pode ter um tipo de borda:
  - Borda tradicional: sem acréscimos.
  - De requeijão: acréscimo de `R$7`.
  - De cheddar: acréscimo de `R$10`.
  - De chocolate: acréscimo de `R$8`.

## Versão 0.4

A pizzaria quer ampliar seus negócios realizando _pedidos para entrega_ de pizzas. Os pedidos para entrega terão **limite de 8 pizzas**. Eles incluem um **valor de taxa de entrega** no preço cobrado, a depender da distância de entrega: 

  - Até `4km`: `R$0` (isento).
  - De `4,01` até `8km`: `R$5`.
  - Acima de `8km`: `R$8`.

### Melhoria: 0.41

Percebendo que a inclusão da _taxa de serviço_ no valor de `10%` do valor das pizzas em um pedido local iria prejudicar a execução dos pedidos para entrega, é necessário realizar a _refatoração_ do código. Tornamos a classe `Pedido` para abstrata, com o método abstrato `precoAPagar()`. As classes filhas `PedidoLocal` e `PedidoEntrega` sobrescrevem este método com suas regras próprias.

### Melhoria: 0.42

Com o objetivo de tornar o fluxo de execução mais seguro, foram adicionadas algumas exceções nas classes de `Pizza` e `Pedidos`. O app foi atualizado com tratamento parcial de exceções.
