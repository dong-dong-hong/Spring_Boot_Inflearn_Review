package hello.core.discount_1;

import hello.core.user.Rank;
import hello.core.user.User;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixNumber = 1000; // 1000원 할인
    private int discountFixNumber2 = 2000; // 2000원 할인

    @Override
    public int discount(User user, int price) {
        if(user.getRank() == Rank.SLIVER) {
            return discountFixNumber;
        }else if(user.getRank() == Rank.GOLD) {
            return discountFixNumber2;
        }else{
            return 0;
        }
    }
}
