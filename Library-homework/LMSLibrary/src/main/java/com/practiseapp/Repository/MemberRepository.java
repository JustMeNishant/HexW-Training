package com.practiseapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practiseapp.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
