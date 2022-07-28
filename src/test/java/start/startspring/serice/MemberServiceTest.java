package start.startspring.serice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import start.startspring.domain.Member;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    @Autowired
    public MemberServiceTest(MemberService memberService) {
        this.memberService = memberService;
    }

    MemberService memberService;

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원예외(){
        //given
        Member member1 = new Member();
        member1.setName("sping");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);

        //then
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}