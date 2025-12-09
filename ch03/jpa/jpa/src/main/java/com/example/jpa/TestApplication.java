package com.example.jpa;

import com.example.jpa.model.Article;
import com.example.jpa.model.Member;
import com.example.jpa.model.MemberStats;
import com.example.jpa.repository.ArticleRepository;
import com.example.jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;


import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;


@Component
@Slf4j
@RequiredArgsConstructor
public class TestApplication implements ApplicationRunner {

    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        var member1 = Member.builder()
                .name("윤서준")
                .email("SeojunYoon@hanbit.co.kr")
                .age(10).build();
        log.info("SAVE 윤서준");
        memberRepository.save(member1);
        log.info("SAVED {}", member1);

        var member2 = Member.builder()
                .name("윤광철")
                .email("KwangcheolYoon@hanbit.co.kr")
                .age(43).build();
        log.info("SAVE 윤광철");
        memberRepository.save(member2);
        log.info("SAVED {}", member2);

        log.info("READ 윤서준");
        member1 = memberRepository.findById(member1.getId()).orElseThrow();

        log.info("UPDATE 윤서준");
        member1.setAge(11);
        memberRepository.save(member1);
        log.info("UPDATED {}", member1);

        log.info("UPDATE 윤광철");
        memberRepository.save(member2);
        log.info("UPDATED {}", member2);

        log.info("애플리케이션 종료");

        /*
        memberRepository.save(Member.builder()
                .name("윤광철")
                .email("KwangcheolYoon@hanbit.co.kr")
                .age(43).build());

        var member = Member.builder()
                    .name("윤서준")
                    .email("SeojunYoon@hanbit.co.kr")
                    .age(10).build();
        memberRepository.save(member);

        var article = Article.builder()
                    .title("방학 첫날이다")
                    .description("오늘은 열심히 방학 숙제를 했다")
                    .member(member).build();

        articleRepository.save(article);

        List<Member> memberList = memberRepository.findAllByName("윤서준");
        for(Member m : memberList) {
            log.info("{}", m);
        }

        List<Object[]> memberStatsObject = memberRepository.getMemberStatsObject();

        for(Object[] obj : memberStatsObject) {
            String name = (String)obj[0];
            String email = (String)obj[1];
            Long count = (Long)obj[2];
            log.info("getMemberStatsObject : {} {} {}", name, email, count);
        }

        List<MemberStats> memberStatsList = memberRepository.getMemberStats();
        for(MemberStats memberStats : memberStatsList) {
            log.info("{}", memberStats);
        }

        articleRepository.findAll();
        log.info("{}", article);

        Pageable pageable = PageRequest.of(0, 10, Sort.by(DESC, "id"));
        int updateResult = memberRepository.setMemberAge(13);
        log.info("UPDATE_RESULT {}", updateResult);

         */
    }
}
