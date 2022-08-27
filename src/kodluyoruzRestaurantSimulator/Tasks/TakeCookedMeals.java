package kodluyoruzRestaurantSimulator.Tasks;

import kodluyoruzRestaurantSimulator.Meal.Meals;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TakeCookedMeals implements Callable {
    private FutureTask<ArrayList<Meals>> cookedMeals;

    public TakeCookedMeals(FutureTask<ArrayList<Meals>> cookedMeals) {
        this.cookedMeals = cookedMeals;
    }

    public FutureTask<ArrayList<Meals>> getCookedMeals() {
        return cookedMeals;
    }

    //Just a simulation of taking prepared order and return cooked meals
    @Override
    public Object call() throws Exception {
        if (cookedMeals.get().size() == 1)
            System.out.println("Waiter took prepared order from the chef " + cookedMeals.get().get(0).name());
        else
            System.out.println("Waiter took prepared order from the chef " + cookedMeals.get().get(0).name() +
                    " and " + cookedMeals.get().get(1).name());
        return cookedMeals.get();
    }
}
