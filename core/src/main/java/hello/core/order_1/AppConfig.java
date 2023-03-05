package hello.core.order_1;

import hello.core.discount_1.DiscountPolicy;
import hello.core.discount_1.FixDiscountPolicy;
import hello.core.discount_1.RateDiscountPolicy;
import hello.core.user.MemoryUserRepository;
import hello.core.user.UserService;
import hello.core.user.UserServiceImpl;

public class AppConfig {
    public UserService userService() {
        return new UserServiceImpl(userRepository()); // MemoryUserRepository 객체를 생성하고 그 참조값에 UserServiceImpl을 생성하면서 생성자로 전달한다.
                                                                // UserServiceImpl 입장에서는 의존관계를 마치 외부에서 주입해주는 것 같다고 해서 DI(의존관계 주입, 의존성 주입)라고 한다.
        // ctrl + alt + m -> extract method(리펙토링) -> 각자의 역할을 알 수 있다.
    }
    private MemoryUserRepository userRepository() {
        return new MemoryUserRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(userRepository(), discountPolicy());

    }
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy(); // 정액 할인
          return new RateDiscountPolicy(); // 정룰 할인
    }

}

