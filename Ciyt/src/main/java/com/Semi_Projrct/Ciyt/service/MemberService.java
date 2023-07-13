package com.Semi_Projrct.Ciyt.service;

import com.Semi_Projrct.Ciyt.domain.Member;
import com.Semi_Projrct.Ciyt.repository.MemberRepository;

import java.util.List;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원가입
     */
//    public Long join(Member member) {
//        validateDuplicateMember(member); //중복 회원 검증 memberRepository.save(member);
//        return member.getId();
//    }
//    private void validateDuplicateMember(Member member) {
//        memberRepository.findByName(member.getUsername())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });
//    }
//
//        /**
//         *전체 회원 조회
//         */
//        public List<Member> findMembers () {
//            return memberRepository.findAll();
//        }
//
//        public Optional<Member> findOne (Long memberid){
//            return memberRepository.findById(memberid);
//        }
    public boolean isValidUser(String userName, String userPassword) {
        Member member = memberRepository.findByUsernameAndPassword(userName, userPassword);
        return member != null;
    }
    public Member createMember(String username, String password, String nickname, String email) {
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        member.setNickname(nickname);
        member.setEmail(email);

        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public Member getMemberByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    public void deleteMemberById(Long id) {
        memberRepository.deleteById(id);
    }
}