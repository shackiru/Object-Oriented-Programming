package shaq.food2;

public class Order
{
    protected Menu menus;
    int total;
    protected int quantity;
    protected String size;
    protected String topping;

    public Order(Menu menus, int total, int quantity, String size, String topping) {
        this.menus = menus;
        this.total = total;
        this.quantity = quantity;
        this.size = size;
        this.topping = topping;
    }

    public Menu getMenus() {
        return menus;
    }

    public void setMenus(Menu menus) {
        this.menus = menus;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }
}
