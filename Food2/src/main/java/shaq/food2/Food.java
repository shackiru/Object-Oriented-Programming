package shaq.food2;

public class Food extends Menu{
    protected String name;
    protected String type;
    protected String origin;

    public Food(String name, int price, String type, String origin) {
        super(name, price);
        this.type = type;
        this.origin = origin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
