package com.Semi_Projrct.Ciyt.repository;

import com.Semi_Projrct.Ciyt.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String username);

    Member findByUsernameAndPassword(String username, String password);

    Member findByNickname(String nickname);

}
