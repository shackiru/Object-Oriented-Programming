package com.example.foodcourt;

public class Model
{
    public class Menu
    {
        protected String whatType;
        protected int price;

        public Menu(String whatType, int price)
        {
            this.whatType = whatType;
            this.price = price;
        }

        public String getWhatType()
        {
            return whatType;
        }

        public void setWhatType(String whatType)
        {
            this.whatType = whatType;
        }

        public int getPrice()
        {
            return price;
        }

        public void setPrice(int price)
        {
            this.price = price;
        }
    }
    public class Food extends Menu
    {
        protected String foodName;
        protected String foodType;
        protected String foodOrigin;

        public Food(String whatType, int price, String foodName, String foodType, String foodOrigin)
        {
            super(whatType, price);
            this.foodName = foodName;
            this.foodType = foodType;
            this.foodOrigin = foodOrigin;
        }

        public String getFoodName()
        {
            return foodName;
        }

        public void setFoodName(String foodName)
        {
            this.foodName = foodName;
        }

        public String getFoodType()
        {
            return foodType;
        }

        public void setFoodType(String foodType)
        {
            this.foodType = foodType;
        }

        public String getFoodOrigin()
        {
            return foodOrigin;
        }

        public void setFoodOrigin(String foodOrigin)
        {
            this.foodOrigin = foodOrigin;
        }
    }
    public class Drink extends Menu
    {
        private String drinkName;
        private String drinkFlavor;
        private String drinkIngredients;

        public Drink(String whatType, int price, String drinkName, String drinkFlavor, String drinkIngredients)
        {
            super(whatType, price);
            this.drinkName = drinkName;
            this.drinkFlavor = drinkFlavor;
            this.drinkIngredients = drinkIngredients;
        }

        public String getDrinkName()
        {
            return drinkName;
        }

        public void setDrinkName(String drinkName)
        {
            this.drinkName = drinkName;
        }

        public String getDrinkFlavor()
        {
            return drinkFlavor;
        }

        public void setDrinkFlavor(String drinkFlavor)
        {
            this.drinkFlavor = drinkFlavor;
        }

        public String getDrinkIngredients()
        {
            return drinkIngredients;
        }

        public void setDrinkIngredients(String drinkIngredients)
        {
            this.drinkIngredients = drinkIngredients;
        }
    }

    public class Order
    {
        private Menu menuItem;
        private int quantity;
        private String size;
        private String topping;

        public Order(Menu menuItem, int quantity, String size, String topping)
        {
            this.menuItem = menuItem;
            this.quantity = quantity;
            this.size = size;
            this.topping = topping;
        }

        public Menu getMenuItem()
        {
            return menuItem;
        }

        public void setMenuItem(Menu menuItem)
        {
            this.menuItem = menuItem;
        }

        public int getQuantity()
        {
            return quantity;
        }

        public void setQuantity(int quantity)
        {
            this.quantity = quantity;
        }

        public String getSize()
        {
            return size;
        }

        public void setSize(String size)
        {
            this.size = size;
        }

        public String getTopping()
        {
            return topping;
        }

        public void setTopping(String topping)
        {
            this.topping = topping;
        }
    }

}
