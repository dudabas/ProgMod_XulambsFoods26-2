public enum ETaxaEntrega {
    CURTA(4, 0),
    MEDIA(8, 5),
    LONGA(Double.POSITIVE_INFINITY, 8);

    private double distancia;
    private double valor;

    ETaxaEntrega(double distancia, double valor){
        this.distancia = distancia;
        this.valor = valor;
    }

    public static ETaxaEntrega definirEntrega(double distancia){
        ETaxaEntrega[] distancias = ETaxaEntrega.values();
        int posicao = 0;
        while (distancia > distancias[posicao].distancia) {
            posicao++;            
        }
        return distancias[posicao];
    }
   
    public double valorTaxa(){
        return  valor;
    }
}
