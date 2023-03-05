package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 애플리케이션에 설정 구성 정보
public class AppConfig { // MemoryMemberRepository의 역할이 전혀 보이지 않는다.
    @Bean // spring container에 등록이 된다.
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository()); // 생성자 주입
    } // ctrl + alt + m -> extract method(리펙토링) -> 각자의 역할을 알 수 있다.
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy(); // 정액 할인
        return new RateDiscountPolicy(); // 정률 할인
    }
}
