package hello;

import hello.core.order_1.AppConfig;
import hello.core.user.Rank;
import hello.core.user.User;
import hello.core.user.UserService;
import hello.core.user.UserServiceImpl;

public class UserApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig(); // AppConfig를 이용해서 userService를 이용한다.
        UserService userService = appConfig.userService();
        User user = new User(1L, "User1" , Rank.SLIVER);
        userService.join(user);

        User findUser = userService.AskRank(1L);

        User user2 = new User(2L, "User2", Rank.GOLD);
        userService.join(user2);

        User findUser2 = userService.AskRank(2L);

        System.out.println("first user = " + user.getName());
        System.out.println("find user = " + findUser.getName());

        System.out.println("second user2 = " + user2.getName());
        System.out.println("find user2 = " + findUser2.getName());
    }
}
