package com.example.restful.controller;

import com.example.restful.dto.ArticleRequest;
import com.example.restful.dto.MemberRequest;
import com.example.restful.dto.MemberResponse;
import com.example.restful.model.Member;
import com.example.restful.repository.MemberRepository;
import com.example.restful.service.ArticleService;
import com.example.restful.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.restful.dto.ArticleResponse;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final ArticleService articleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<MemberResponse> postBatch(@RequestBody List<MemberRequest> memberRequests) {
        return memberService.createBatch(memberRequests);
    }

    @GetMapping
    public List<MemberResponse> getAll() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public MemberResponse get(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @PutMapping("/{id}")
    public MemberResponse put(@PathVariable("id") Long id, @RequestBody MemberRequest memberRequest) {
        return memberService.update(id, memberRequest);
    }

    @PatchMapping("/{id}")
    public MemberResponse patch(@PathVariable("id") Long id, @RequestBody MemberRequest memberRequest) {
        return memberService.patch(id, memberRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        memberService.deleteById(id);
    }

    @PostMapping("/{id}/articles")
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleResponse postArticle(@PathVariable("id") Long id, @RequestBody ArticleRequest articleRequest) {
        return articleService.create(id, articleRequest);
    }

    @GetMapping("/{id}/articles")
    public void getArticle(@PathVariable("id") Long id, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        request.getSession()
                .getServletContext()
                .getRequestDispatcher("/api/articles?memberId=" + id)
                .forward(request, response);
    }


}
