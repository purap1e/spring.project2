package com.example.spring.project2.repositories;

import com.example.spring.project2.entities.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RequestRepository extends JpaRepository<ApplicationRequest,Long> {
    List<ApplicationRequest> findAllByHandledIs(Boolean b);

    @Query(nativeQuery = true, value = "SELECT * FROM requests where handled == ? ")
    List<ApplicationRequest> findALLByHandled(Boolean handled);
}
