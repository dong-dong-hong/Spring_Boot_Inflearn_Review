package hello.core;

import hello.core.order_1.AppConfig;
import hello.core.order_1.Order;
import hello.core.order_1.OrderService;
import hello.core.user.Rank;
import hello.core.user.User;
import hello.core.user.UserService;


public class OrderApp02 {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
       UserService userService = appConfig.userService();
       OrderService orderService = appConfig.orderService();

        long userId = 1L;
        User user = new User(userId, "memberA" , Rank.SLIVER);
        userService.join(user);

        Order order = orderService.createOrder(userId, "ProductA", 10000);

        User user2 = new User(userId, "memberB", Rank.GOLD);
        userService.join(user2);
        
       Order order2 = orderService.createOrder(userId, "ProductB", 20000);

        System.out.println("Order = " + order);
        System.out.println("order.calPrice() = " + order.calPrice());
        System.out.println("Order2 = " + order2);
        System.out.println("order2.calPrice() = " + order2.calPrice());
    }
}
