package com.example.codeclan.CheckMate.repositories;

import com.example.codeclan.CheckMate.models.ReceivedCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivedCheckRepository extends JpaRepository<ReceivedCheck, Long> {
}
