package com.sparta.challenge_assignment.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private final List<Member> members = new ArrayList<>();

    @Builder
    public Team(String name) {
        this.name = name;
    }

    public void addMember (Member member){
        members.add(member);
        member.setTeam(this);
    }

}
