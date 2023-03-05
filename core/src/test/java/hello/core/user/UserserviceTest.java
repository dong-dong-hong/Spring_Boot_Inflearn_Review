package hello.core.user;

import hello.core.order_1.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserserviceTest {
    UserService userService;
    @BeforeEach // 각 테스트 실행전에 무조건 실행되는 것
    public void BeforeEach() {
        AppConfig appConfig = new AppConfig();
        userService = appConfig.userService();
    }

    @Test // JUnit에서 테스트 할 대상을 표시한다.
    void join() {
        // given : 어떤 값이 주어질 때
        User user = new User(1L, "User1", Rank.SLIVER);
        User user2 = new User(2L, "User2", Rank.GOLD);
        // when : 무엇을 했을 때
        userService.join(user);
        User askUser = userService.AskRank(1L);
        userService.join(user2);
        User askUser2 = userService.AskRank(2L);
        // then : 어떤 값을 원할 때
        Assertions.assertThat(user).isEqualTo(askUser);
        Assertions.assertThat(user2).isEqualTo(askUser2);
        // assertThat(user).isEqualTo(askUser);
        // user이 askUser을 만족하는지 ask
    }
}
