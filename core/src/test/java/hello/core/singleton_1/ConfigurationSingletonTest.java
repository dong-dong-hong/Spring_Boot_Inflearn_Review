package hello.core.singleton_1;

import hello.core.user.UserRepository;
import hello.core.user.UserServiceImpl;
import hello.core.order_1.AppConfig2;
import hello.core.order_1.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig2.class);

        UserServiceImpl userService = ac.getBean("userService", UserServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        UserRepository userRepository = ac.getBean("userRepository", UserRepository.class);

        UserRepository userRepository1 = userService.getUserRepository();
        UserRepository userRepository2 = orderService.getUserRepository();


        System.out.println("userService -> userRepository = " + userRepository1);
        System.out.println("userService -> userRepository = " + userRepository2);
        System.out.println("userRepository = " + userRepository);

        assertThat(userService.getUserRepository()).isSameAs(userRepository);
        assertThat(orderService.getUserRepository()).isSameAs(userRepository);
    }
    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig2.class);
        AppConfig2 bean = ac.getBean(AppConfig2.class);

        System.out.println("bean = " + bean.getClass());
    }
}
