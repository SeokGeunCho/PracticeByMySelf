package studio.aroundhub.onehourproject.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.aroundhub.onehourproject.member.repository.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
