package studio.aroundhub.onehourproject.member.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import studio.aroundhub.onehourproject.member.repository.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired private MemberRepository memberRepository;

    @Test
    public void crudTest() {
        Member member = Member.builder()
                .id("flature")
                .name("플래처")
                .phoneNumber("010-0000-0000")
                .build();

        // create test
        memberRepository.save(member);

        // get test
        Member foundMember = memberRepository.findById(1L).get();
    }
}
