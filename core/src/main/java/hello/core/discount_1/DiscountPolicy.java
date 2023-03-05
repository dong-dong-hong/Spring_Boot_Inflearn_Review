package hello.core.discount_1;

import hello.core.user.User;

public interface DiscountPolicy {

    int discount(User user, int price);
}
