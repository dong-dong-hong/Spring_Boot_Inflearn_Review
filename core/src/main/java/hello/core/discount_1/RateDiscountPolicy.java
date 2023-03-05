package hello.core.discount_1;

import hello.core.user.Rank;
import hello.core.user.User;

public class RateDiscountPolicy implements DiscountPolicy{// alt + enter -> 메소드 구현

    private int discountPercent = 10;
    private int discountPercent2 = 20;


    @Override
    public int discount(User user, int price) {
       if(user.getRank() == Rank.SLIVER) {
           return price * discountPercent / 100;
       }else if(user.getRank() == Rank.GOLD) {
           return price * discountPercent2 / 100;
       }else{
           return 0;
       }
    }
    // ctrl + shift + T -> test 클래스 만들기 단축키

}
