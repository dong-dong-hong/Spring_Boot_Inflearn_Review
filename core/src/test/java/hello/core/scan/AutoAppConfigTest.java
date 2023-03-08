package hello.core.scan;

import hello.core.member.MemberService;
import hello.core.order.AutoAppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {
    @Test
    void basicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

        // AnnotationConfigApplicationContext를 사용하는 것은 기존과 동일하다.
        // 설정 정보로 AutoAppConfig 클래스를 넘겨준다.
        // 설정해보면 기존과 같이 잘 동작하는 것을 확인할 수 있다.
    }
}
