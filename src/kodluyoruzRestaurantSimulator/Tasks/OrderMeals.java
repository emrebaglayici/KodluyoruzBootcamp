package kodluyoruzRestaurantSimulator.Tasks;

import kodluyoruzRestaurantSimulator.Meal.Meals;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class OrderMeals implements Callable {
    public int generateMealId() {
        //Between 1 and 10
        return (int) ((Math.random() * (11 - 1)) + 1);
    }

    public int generateMealCount() {
        //Between 1 and 2
        return (int) ((Math.random() * (3 - 1)) + 1);
    }

    //Avoiding code repetition , I create method for one and two meals cases.
    public void oneMealChoosing(ArrayList<Meals> meals, int firstMealId) {
        addMeals(meals, firstMealId);
    }

    public void secondMealChoosing(ArrayList<Meals> meals, int secondMealId) {
        addMeals(meals, secondMealId);
    }


    //Add meals to the arraylist.
    public void addMeals(ArrayList<Meals> meals, int mealId) {
        switch (mealId) {
            case 1 -> meals.add(Meals.SALAD);
            case 2 -> meals.add(Meals.SOUP);
            case 3 -> meals.add(Meals.MEATBALL);
            case 4 -> meals.add(Meals.PASTA);
            case 5 -> meals.add(Meals.CHIKENWINGS);
            case 6 -> meals.add(Meals.BURGER);
            case 7 -> meals.add(Meals.PAELLA);
            case 8 -> meals.add(Meals.PIZZA);
            case 9 -> meals.add(Meals.BAKLAVA);
            case 10 -> meals.add(Meals.FANTA);
        }
    }

    @Override
    public Object call() {
        //Order Meals Future Task starting in here.
        System.out.println("Started ordering");
        ArrayList<Meals> meals = new ArrayList<>();
        int randomOrderCount = generateMealCount();
        if (randomOrderCount == 1) {
            int firstMealId = generateMealId();
            System.out.println("1 Meal ordered situation and meal number is : " + firstMealId);
            oneMealChoosing(meals, firstMealId);
        }
        if (randomOrderCount == 2) {
            int firstMealId = generateMealId();
            int secondMealId = generateMealId();
            System.out.println("2 Meals ordered situation and meal numbers are : " + firstMealId + " " + secondMealId);
            oneMealChoosing(meals, firstMealId);
            secondMealChoosing(meals, secondMealId);
        }
        if (randomOrderCount == 1)
            System.out.println("Customer's orders are : " + meals.get(0).name());
        else
            System.out.println("Customer's orders are : " + meals.get(0).name() + " and " + meals.get(1).name());
        //Returns meals list.
        return meals;
    }
}
