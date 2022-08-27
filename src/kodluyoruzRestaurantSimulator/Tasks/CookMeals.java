package kodluyoruzRestaurantSimulator.Tasks;


import kodluyoruzRestaurantSimulator.Meal.Meals;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CookMeals implements Callable {

    private FutureTask<ArrayList<Meals>> takeOrderFuture;

    public CookMeals(FutureTask<ArrayList<Meals>> takeOrderFuture) {
        this.takeOrderFuture = takeOrderFuture;
    }

    public FutureTask<ArrayList<Meals>> getTakeOrderFuture() {
        return takeOrderFuture;
    }


    //Chef cooks foods with their preparation time.
    @Override
    public Object call() throws Exception {
        if (getTakeOrderFuture().get().size() == 1) {
            Thread.sleep(getTakeOrderFuture().get().get(0).getPreparedTime());
            System.out.println("Chef is cooking the foods ->" + getTakeOrderFuture().get().get(0).name());
        }
        if (getTakeOrderFuture().get().size() == 2) {
            Thread.sleep(getTakeOrderFuture().get().get(0).getPreparedTime());
            System.out.println("Chef is cooking the foods ->" + getTakeOrderFuture().get().get(0).name());
            Thread.sleep(getTakeOrderFuture().get().get(1).getPreparedTime());
            System.out.println("Chef is cooking the foods ->" + getTakeOrderFuture().get().get(1).name());
        }
        System.out.println("Meals are cooked");
        return getTakeOrderFuture().get();
    }

}
