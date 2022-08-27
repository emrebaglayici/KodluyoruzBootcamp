package kodluyoruzRestaurantSimulator.Meal;

public enum Meals {
    SALAD(1, 200, 300),
    SOUP(2, 250, 300),
    MEATBALL(3, 250, 400),
    PASTA(4, 150, 250),
    CHIKENWINGS(5, 250, 300),
    BURGER(6, 300, 500),
    PAELLA(7, 500, 400),
    PIZZA(8, 350, 500),
    BAKLAVA(9, 100, 200),
    FANTA(10, 25, 100);

    //I declare all meals as an enum.
    private int id;
    private int preparedTime;
    private int consumptionTime;

    Meals(int id, int preparedTime, int consumptionTime) {
        this.id = id;
        this.preparedTime = preparedTime;
        this.consumptionTime = consumptionTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPreparedTime() {
        return preparedTime;
    }

    public void setPreparedTime(int preparedTime) {
        this.preparedTime = preparedTime;
    }

    public int getConsumptionTime() {
        return consumptionTime;
    }

    public void setConsumptionTime(int consumptionTime) {
        this.consumptionTime = consumptionTime;
    }

}
