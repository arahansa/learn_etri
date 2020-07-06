package com.arahansa.springbootlevel1magicuser.service;

import com.arahansa.springbootlevel1magicuser.domain.Member;
import com.arahansa.springbootlevel1magicuser.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberService implements UserDetailsService {

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


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("멤버 서비스 : "+username);
        Member byUsername = repository.findByUsername(username);
        System.out.println("로그인된 멤버 : "+byUsername);
        return byUsername;
    }
}
