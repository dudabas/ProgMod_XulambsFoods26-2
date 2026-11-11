
public class PedidoEntrega extends Pedido {

    public static final int MAX_PIZZAS = 8;

    private ETaxaEntrega taxaEntrega;
    private double distanciaEntrega;

    public PedidoEntrega(double distancia) {

        super();

        if (distancia < 0.1)
            throw new IllegalArgumentException();

        distanciaEntrega = distancia;
        taxaEntrega = ETaxaEntrega.definirEntrega(distancia);
    }

    @Override
    protected void verificarInclusao() {

        super.verificarInclusao();
    }

    @Override
    public int adicionarProduto(IProdutoPedido produto) {

        if (produto instanceof Pizza
                && quantidadePizzas() >= MAX_PIZZAS) {

            throw new IllegalStateException(
                "Limite de pizzas por pedido atingido."
            );
        }

        return super.adicionarProduto(produto);
    }

    @Override
    public double precoAPagar() {
        return valorProdutos() + taxaEntrega.valorTaxa();
    }

    @Override
    public String toString() {

        String linhaEntrega = String.format(
            "TAXA ENTREGA: R$ %.2f (%.1f km)",
            taxaEntrega.valorTaxa(),
            distanciaEntrega
        );

        String precoFinal = String.format(
            "\nVALOR DO PEDIDO: R$ %.2f",
            precoAPagar()
        );

        StringBuilder relat = new StringBuilder(cabecalho());

        relat.append("PEDIDO PARA ENTREGA\n");
        relat.append(detalhesPedido());
        relat.append("\n");
        relat.append(linhaEntrega);
        relat.append(precoFinal);

        return relat.toString();
    }
}

