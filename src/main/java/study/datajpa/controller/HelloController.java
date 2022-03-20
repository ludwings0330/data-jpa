package study.datajpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.datajpa.domain.member.Member;
import study.datajpa.domain.member.MemberDto;
import study.datajpa.domain.member.MemberRepository;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final MemberRepository memberRepository;

    @GetMapping("/hello")
    public String helloController() {
        return "hello";
    }

    @GetMapping("/members")
    public Page<Member> list(Pageable pageable) {
        final Page<Member> page = memberRepository.findAll(pageable);
        return page;
    }

    @GetMapping("/members")
    public Page<Member> listV2(@PageableDefault(page = 0, size=12, sort="username",
            direction = Sort.Direction.DESC) Pageable pageable) {
        final Page<Member> page = memberRepository.findAll(pageable);

        return page;
    }

    @GetMapping("/members")
    public Page<Member> listV3(@PageableDefault(page = 0, size=12, sort="username",
            direction = Sort.Direction.DESC) Pageable pageable) {
        final Page<Member> page = memberRepository.findAll(pageable);
        final Page<MemberDto> pageDto = page.map(MemberDto::new);
        return page;
    }
}
