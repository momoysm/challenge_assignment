package com.sparta.challenge_assignment.assignment;

import com.sparta.challenge_assignment.entity.Member;
import com.sparta.challenge_assignment.entity.Role;
import com.sparta.challenge_assignment.entity.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class Problem {

    @PersistenceContext
    private EntityManager em;

    @Test
    @Transactional
    @DisplayName("Problem1")
    void problem1_fail() throws Exception {
        // team insert
        Team team = Team.builder()
                .name("wooteco")
                .build();

        em.persist(team);

        // member 생성자로 team 정보 입력
        Member member = Member.builder()
                .name("kth990303")
                .team(team)
                .role(Role.ADMIN)
                .build();

        em.persist(member);

        System.out.println("=================================");
        List<Member> findMembers = team.getMembers();
        for (Member findMember : findMembers) {
            System.out.println(findMember.getName());// 1번
        }
        System.out.println("=================================");

        Team findTeam = em.find(Team.class, team.getId());
        List<Member> teamMembers = findTeam.getMembers();
        teamMembers.get(0).setName("kth990202");

        System.out.println(member.getName());// 2번
    }

    @Test
    @Transactional
    @DisplayName("Problem solve")
    void problem1_solve() throws Exception {
        Team team = Team.builder()
                .name("wooteco")
                .build();

        em.persist(team);

        // member 생성자로 team 정보 입력
        Member member = Member.builder()
                .name("kth990303")
                .team(team)
                .role(Role.ADMIN)
                .build();

        team.addMember(member);
        em.persist(member);

        System.out.println("=================================");
        List<Member> findMembers = team.getMembers();
        for (Member findMember : findMembers) {
            System.out.println(findMember.getName());
        }
        System.out.println("=================================");

        Team findTeam = em.find(Team.class, team.getId());
        List<Member> teamMembers = findTeam.getMembers();
        teamMembers.get(0).setName("kth990202");

        System.out.println(member.getName());// 2번
    }

}
