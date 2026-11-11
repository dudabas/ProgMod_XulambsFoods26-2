/** 
* MIT License
*
* Copyright(c) 2024-26 João Caram <caram@pucminas.br>
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
*/


import java.time.LocalDate;
import java.util.LinkedList;

public abstract class Pedido {

    private static int ultimoPedido;

    private LocalDate data;
    protected LinkedList<IProdutoPedido> produtos;
    private int idPedido;
    private boolean aberto;

    public Pedido() {
        ultimoPedido++;
        data = LocalDate.now();
        produtos = new LinkedList<>();
        idPedido = ultimoPedido;
        aberto = true;
    }

    protected void verificarInclusao() {
        if (!aberto)
            throw new PedidoFechadoException(idPedido);
    }

    public int adicionarProduto(IProdutoPedido produto) {

        if (produto == null)
            throw new IllegalArgumentException(
                "Produto não foi criado corretamente. Não será adicionado ao pedido"
            );

        verificarInclusao();
        produtos.add(produto);

        return produtos.size();
    }

    // Mantém compatibilidade com códigos que ainda adicionam pizzas.
    public int adicionarPizza(Pizza pizza) {
        return adicionarProduto(pizza);
    }

    public void fecharPedido() {
        aberto = false;
    }

    public int getID() {
        return idPedido;
    }

    public abstract double precoAPagar();

    protected double valorProdutos() {

        double preco = 0d;

        for (IProdutoPedido produto : produtos) {
            preco += produto.getPreco();
        }

        return preco;
    }

    protected int quantidadePizzas() {

        int quantidade = 0;

        for (IProdutoPedido produto : produtos) {
            if (produto instanceof Pizza)
                quantidade++;
        }

        return quantidade;
    }

    protected String cabecalho() {

        String estado = aberto ? "aberto" : "fechado";

        return String.format(
            "Pedido nº %d - %s (%s) com %d produtos\n",
            idPedido, data, estado, produtos.size()
        );
    }

    protected String detalhesPedido() {

        StringBuilder detalhes = new StringBuilder();

        for (IProdutoPedido produto : produtos) {

            detalhes.append(
                String.format("----\n%s\n", produto.getDescricao())
            );
        }

        return detalhes.toString();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Pedido))
            return false;

        Pedido outro = (Pedido) obj;

        return idPedido == outro.idPedido
            && data.equals(outro.data);
    }

    @Override
    public int hashCode() {
        return idPedido;
    }
}
