package study.datajpa.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.domain.member.Member;
import study.datajpa.domain.member.MemberJpaRepository;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberJpaRepositoryTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;
    
    @Test
    public void testMember() throws Exception {
        //given
        Member memberA = new Member("memberA");
        Member savedMember = memberJpaRepository.save(memberA);

        //when

        Member findMember = memberJpaRepository.find(memberA.getId());
        //then

        Assertions.assertThat(findMember.getUsername()).isEqualTo(savedMember.getUsername());
        Assertions.assertThat(findMember.getId()).isEqualTo(savedMember.getId());
        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    public void deleteMember() throws Exception {
        //given

        Member memberA = new Member("memberA");
        Member savedMember = memberJpaRepository.save(memberA);


        //when

        //then

    }
}