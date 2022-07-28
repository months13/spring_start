package start.startspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import start.startspring.repository.MemberRepository;
import start.startspring.repository.MemoryMemberRepository;
import start.startspring.serice.MemberService;

@Configuration
public class SpringConfig {

//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//
//    }
}
