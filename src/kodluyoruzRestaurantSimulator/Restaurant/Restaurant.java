package kodluyoruzRestaurantSimulator.Restaurant;
import kodluyoruzRestaurantSimulator.Meal.Meals;
import kodluyoruzRestaurantSimulator.Tasks.*;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Restaurant {
    public void open() {
        //Creation of each executors with required numbers.
        ExecutorService customerExecutorService = Executors.newFixedThreadPool(5);
        ExecutorService waiterExecutorService = Executors.newFixedThreadPool(3);
        ExecutorService chefExecutorService = Executors.newFixedThreadPool(2);

        //When I try to infinite loop , the logs will not show up well. I think times of meals are short.
        //That is why I use limited loop.
        for (int i = 0; i < 5; i++) {
            FutureTask<ArrayList<Meals>> orderMeals = new FutureTask<>(new OrderMeals());
            FutureTask<ArrayList<Meals>> takeOrder = new FutureTask<>(new TakeOrder(orderMeals));
            FutureTask<ArrayList<Meals>> cookMeals = new FutureTask<>(new CookMeals(takeOrder));
            FutureTask<ArrayList<Meals>> takeCookedMeals = new FutureTask<>(new TakeCookedMeals(cookMeals));
            FutureTask<ArrayList<Meals>> serveMeals = new FutureTask<>(new ServeMeals(takeCookedMeals));


            customerExecutorService.submit(orderMeals);
            waiterExecutorService.submit(takeOrder);
            chefExecutorService.submit(cookMeals);
            waiterExecutorService.submit(takeCookedMeals);
            waiterExecutorService.submit(serveMeals);
        }
        customerExecutorService.shutdown();
        waiterExecutorService.shutdown();
        chefExecutorService.shutdown();

    }

}
