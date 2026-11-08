public class PedidoFechadoException extends IllegalStateException{

    public PedidoFechadoException(int codigo){
        String msg = "Pedido nº"+codigo+" fechado"; 
        super(msg+". Não pode ser alterado.");
    }
}