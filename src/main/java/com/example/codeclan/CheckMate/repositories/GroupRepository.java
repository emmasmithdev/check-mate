package com.example.codeclan.CheckMate.repositories;

import com.example.codeclan.CheckMate.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
