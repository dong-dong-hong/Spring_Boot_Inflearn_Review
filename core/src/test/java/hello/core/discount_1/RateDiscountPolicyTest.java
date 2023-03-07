package hello.core.discount_1;

import hello.core.user.Rank;
import hello.core.user.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*; // 이게 나온 시점부터 생략가능하다.
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("SLIVER는 10% 할인이 되어야한다.") // 영어인 코드를 한글로 설명하여 이해를 돕는다.
    void sliver_possible() {
        User user = new User(1L,"userSliver", Rank.SLIVER);

      int discount = discountPolicy.discount(user, 10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("Gold는 20% 할인이 되어야한다.")
    void gold_possible() {
        User user = new User(2L,"userGold", Rank.GOLD);

        int discount = discountPolicy.discount(user, 10000);

        assertThat(discount).isEqualTo(2000);
    }

    @Test
    @DisplayName("SLIVER,GOLD가 아니고 BRONZE인 경우에는 할인이 되지 않아야 한다.")
    void discount_impossible() {
        User user = new User(3L,"userBRONZE", Rank.BRONZE);

        int discount = discountPolicy.discount(user, 10000);

        assertThat(discount).isEqualTo(0);
        // Assertions alt+enter -> 인터페이스 메소드를 불러오는거나 , static import(Assertions.assertThat -> assertThat)하는 단축키
    }
}