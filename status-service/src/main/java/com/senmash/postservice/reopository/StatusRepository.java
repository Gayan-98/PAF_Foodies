package com.senmash.postservice.reopository;


import com.senmash.postservice.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StatusRepository extends JpaRepository<Status,Integer> {
}
