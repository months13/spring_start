package start.startspring.serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.startspring.domain.Member;
import start.startspring.repository.MemberRepository;
import start.startspring.repository.MemoryMemberRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {


    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member>  findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


}
