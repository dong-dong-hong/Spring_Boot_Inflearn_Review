package hello.core.xml_1;

import hello.core.member.MemberService;
import hello.core.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext2 {
    // xml이랑 AppConfig랑 완전 같다.
    @Test
    void xmlAppContext() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig2.xml"); // class 파일에서 xml로 바뀌는 것밖에 없다
        UserService userService = ac.getBean("userService", UserService.class);
        assertThat(userService).isInstanceOf(UserService.class);
    }
}
