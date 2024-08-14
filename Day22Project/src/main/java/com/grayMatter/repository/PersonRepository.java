package com.grayMatter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grayMatter.entity.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {

}
