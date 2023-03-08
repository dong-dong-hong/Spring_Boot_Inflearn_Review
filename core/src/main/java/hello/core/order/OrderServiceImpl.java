package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.discount.DiscountPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class OrderServiceImpl implements OrderService {
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    // 참고 : @Autowired의 기본 동작은 주입할 대상이 없으면 오류가 발생한다.
    // 주입할 대상이 없어도 동작하게 하려면 @Autowired(require = false)로 지정하면 된다.

    // 참고: 자바빈 프로터티, 자바에서는 과거부터 필드의 값을 직접 변경하지 않고,
    // setXxx, getXxx라는 메서드를 통해서 값을 읽거나 수정하는 규칙을 만들었는 데,
    // 그것이 자바빈 프로터티 규약이다. 더 자세한 내용은 자바빈 프로터티를 검색해보자.

    @Autowired // 생성자에서 여러 의존관계도 한번에 주입받을 수 있다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.disCount(member, itemPrice);

        return new Order(memberId , itemName, itemPrice ,discountPrice);
    }
    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
