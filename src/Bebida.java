
public enum Bebida implements IProdutoPedido {

    AGUA_DA_CASA("Água da casa", 0.0),
    AGUA_COM_GAS("Água com gás", 4.0),
    CHA_COM_GAS("Chá com gás", 6.0),
    SUCO("Sucos", 9.0),
    CERVEJA("Cerveja", 15.0),
    VINHO("Taça de vinho", 15.0);

    private String descricao;
    private double preco;

    Bebida(String descricao, double preco) {
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

