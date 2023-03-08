package hello.core.beanfind_1;

import hello.core.user.UserService;
import hello.core.user.UserServiceImpl;
import hello.core.order_1.AppConfig2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest2 {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig2.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        UserService userService =  ac.getBean("userService", UserService.class);
        assertThat(userService).isInstanceOf(UserServiceImpl.class);
    }
    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        UserService userService =  ac.getBean(UserService.class);
        assertThat(userService).isInstanceOf(UserServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        UserServiceImpl userService =  ac.getBean("userService", UserServiceImpl.class);
        assertThat(userService).isInstanceOf(UserServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회x")
    void findBeanByNameX() {
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("meme", UserService.class));
    }
}
