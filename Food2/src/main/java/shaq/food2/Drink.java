package shaq.food2;

public class Drink extends Menu{
    protected String flavor;
    protected String ingredients;

    public Drink(String name, int price,  String flavor, String ingredients) {
        super(name, price);
        this.flavor = flavor;
        this.ingredients = ingredients;
    }


    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
