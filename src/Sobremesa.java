
public enum Sobremesa implements IProdutoPedido {

    BRIGADEIRO("Brigadeiro na colher", 8.0),
    PUDIM("Pudim de leite condensado", 10.0),
    DOCE_DE_LEITE("Doce de leite no pires", 9.0);

    private String descricao;
    private double preco;

    Sobremesa(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return String.format("%s - R$ %.2f", descricao, preco);
    }
}

