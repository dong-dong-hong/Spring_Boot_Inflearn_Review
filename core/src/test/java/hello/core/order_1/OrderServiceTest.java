package hello.core.order_1;

import hello.core.user.Rank;
import hello.core.user.User;
import hello.core.user.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class OrderServiceTest {
    UserService userservice;
    OrderService orderService;
    @BeforeEach
    public void beforeEach() {
        AppConfig2 appConfig = new AppConfig2();
        userservice = appConfig.userService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder() {
        Long userId = 1L;
        User user = new User(userId, "memberA" , Rank.SLIVER);
        userservice.join(user);

        userId = 2L;
        User user2 = new User(userId, "memberB" , Rank.GOLD);
        userservice.join(user2);

        Order order = orderService.createOrder(1L, "ProductA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        Order order2 = orderService.createOrder(2L , "ProductB" , 20000);
        Assertions.assertThat(order2.getDiscountPrice()).isEqualTo(4000);
    }
}
