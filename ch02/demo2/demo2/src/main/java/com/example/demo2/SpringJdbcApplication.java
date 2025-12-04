package com.example.demo2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SpringJdbcApplication implements ApplicationRunner {
    private final MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Create
        Member member = Member.builder().name("정혁")
                                        .email("HyeokJung@hanbit.co.kr")
                                        .age(10).build();
        memberRepository.save(member);

        // Update
        member.setAge(11);
        memberRepository.save(member);

        // find all members
        var members = memberRepository.findAll();
        log.info("{}", members);

        // find member by id
        var member1 = memberRepository.findById(1L);
        log.info("{}", member1);
    }
}
