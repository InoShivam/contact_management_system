package com.cms.repository;

import com.cms.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ContactRepository extends JpaRepository<ContactEntity, Long> {


    @Query("SELECT ce FROM ContactEntity ce WHERE active=true AND ( ce.firstName IN (:firstName) OR coalesce(:firstName) IS null) "
            + "AND ( ce.lastName IN (:lastName) OR coalesce(:lastName) IS null) "
            + "AND ( ce.email IN (:email) OR coalesce(:email) IS null) ")
    List<ContactEntity> findContactByFilter(String firstName, String lastName, String email);
}
