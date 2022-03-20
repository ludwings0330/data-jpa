package study.datajpa.domain.member;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {
    String name;

    public MemberDto(Member member) {
        this.name = member.getUsername();
    }
}
