package kodluyoruzRestaurantSimulator.Tasks;


import kodluyoruzRestaurantSimulator.Meal.Meals;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ServeMeals implements Callable {
    private FutureTask<ArrayList<Meals>> serveCookedMeals;

    public ServeMeals(FutureTask<ArrayList<Meals>> serveCookedMeals) {
        this.serveCookedMeals = serveCookedMeals;
    }

    public FutureTask<ArrayList<Meals>> getServeCookedMeals() {
        return serveCookedMeals;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("Waiter serving the preparedFood " + getServeCookedMeals().get());
        System.out.println("Customer eating");
        int firstTime = 0, secondTime = 0;
        if (getServeCookedMeals().get().size() == 1) {
            firstTime = getServeCookedMeals().get().get(0).getConsumptionTime();
            Thread.sleep(firstTime);
        }
        if (getServeCookedMeals().get().size() == 2) {
            firstTime = getServeCookedMeals().get().get(0).getConsumptionTime();
            secondTime = getServeCookedMeals().get().get(1).getConsumptionTime();
            Thread.sleep(firstTime);
            Thread.sleep(secondTime);
        }
        System.out.println("Customer ate and gone");
        return getServeCookedMeals().get();
    }
}
