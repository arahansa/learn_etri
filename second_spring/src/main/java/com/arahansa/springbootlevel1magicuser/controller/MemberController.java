package com.arahansa.springbootlevel1magicuser.controller;

import com.arahansa.springbootlevel1magicuser.domain.Member;
import com.arahansa.springbootlevel1magicuser.domain.MemberAuthority;
import com.arahansa.springbootlevel1magicuser.repository.MemberRepository;
import com.arahansa.springbootlevel1magicuser.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/dummy")
    @ResponseBody
    public String dummy(){
        memberService.createDummy();
        return "OK";
    }

    @Autowired
    PasswordEncoder passwordEncoder;



    @PostConstruct
    public void setup(){
        memberRepository.deleteAll();
        Member arahansa = new Member();
        arahansa.setUsername("arahansa@naver.com");
        arahansa.setPassword(passwordEncoder.encode("1234"));

        arahansa.setAuthorities(Arrays.asList(MemberAuthority.ROLE_ADMIN, MemberAuthority.ROLE_USER));
        memberRepository.save(arahansa);

        Member tester = new Member();
        tester.setUsername("tester@naver.com");
        tester.setPassword(passwordEncoder.encode("1234"));
        tester.setAuthorities(Arrays.asList(MemberAuthority.ROLE_USER));
        memberRepository.save(tester);
    }

    // /member
    @GetMapping
    public String index(Pageable pageable, Model model){
        log.info("page : {}", pageable);
        model.addAttribute("page", memberService.findAll(pageable));
        model.addAttribute("member", new Member());
        return "member";
    }

    @PostMapping
    public String create(@Valid Member member, BindingResult bindingResult, Model model){
        log.info("member : {}", member);
        if(bindingResult.hasErrors()){
            model.addAttribute("member", member);
            return "member";
        }
        memberService.save(member);
        return "redirect:/member";
    }



}
