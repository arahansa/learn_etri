package com.arahansa.springbootlevel1magicuser.service;

import com.arahansa.springbootlevel1magicuser.domain.Member;
import com.arahansa.springbootlevel1magicuser.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberService {

    public void createDummy() {
        for (int i = 0; i < 200; i++) {
            Member member = new Member();
            member.setUsername("user" + i + "@naver.com");
            member.setPassword("1234");
            repository.save(member);
        }
    }

    public Page<Member> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Autowired
    private MemberRepository repository;

    public List<Member> findAll() {
        return repository.findAll();
    }

    public Member save(Member member) {
        return repository.save(member);
    }


}
