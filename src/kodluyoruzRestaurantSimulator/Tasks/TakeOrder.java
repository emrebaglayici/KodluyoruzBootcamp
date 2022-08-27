package kodluyoruzRestaurantSimulator.Tasks;



import kodluyoruzRestaurantSimulator.Meal.Meals;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TakeOrder implements Callable {


    private FutureTask<ArrayList<Meals>> orderMealsFuture;

    public FutureTask<ArrayList<Meals>> getOrderMealsFuture() {
        return orderMealsFuture;
    }

    public TakeOrder(FutureTask<ArrayList<Meals>> orderMealsFuture) {
        this.orderMealsFuture = orderMealsFuture;
    }

    //Take order future task starts and returns same type
    @Override
    public Object call() throws ExecutionException, InterruptedException {
        if (getOrderMealsFuture().get().size() == 1)
            System.out.println("Waiter took order from customer -> " + getOrderMealsFuture().get().get(0).name());
        else
            System.out.println("Waiter took order from customer -> " + getOrderMealsFuture().get().get(0).name() + " and " + getOrderMealsFuture().get().get(1).name());

        return getOrderMealsFuture().get();
    }
}
