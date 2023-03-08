package hello.core.order_1;

import hello.core.discount_1.DiscountPolicy;
import hello.core.user.User;
import hello.core.user.UserRepository;

public class OrderServiceImpl implements OrderService {
    private final UserRepository userRepository;
    private final DiscountPolicy discountPolicy;
    public OrderServiceImpl(UserRepository userRepository, DiscountPolicy discountPolicy) {
        this.userRepository = userRepository;
        this.discountPolicy = discountPolicy;
        // OrderServiceImpl은 생성자를 통해 어떤 구현 객체를 주입할지는 AppConfig에서 결정한다.
        // UserRepository DiscountPolicy 객체의 의존관계가 주입된다.
    }
    @Override
    public Order createOrder(Long userId, String productName, int productPrice) {
        User user = userRepository.askById(userId);
        int discountPrice = discountPolicy.discount(user, productPrice);
        return  new Order(userId, productName, productPrice, discountPrice);
    }
    public UserRepository getUserRepository() {
        return userRepository;
    }
}
