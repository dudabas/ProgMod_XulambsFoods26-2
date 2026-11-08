public class MaximoDeIngredientesException extends IllegalStateException {

    private int ingredientesRestantes;

    public MaximoDeIngredientesException(int restantes, int total){
        super("Máximo de ingredientes ("+total+") não pode ser ultrapassado");
        ingredientesRestantes = restantes;
    }

    public void completarPizza(Pizza pizza){
        pizza.adicionarIngredientes(ingredientesRestantes);
    }
    
}
