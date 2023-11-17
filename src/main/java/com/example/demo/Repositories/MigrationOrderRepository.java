package com.example.demo.Repositories;

import com.example.demo.Class.MigrationOrder;
import com.example.demo.Class.Tab;
import com.example.demo.model.Dates;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MigrationOrderRepository extends JpaRepository<MigrationOrder,Integer> {



    @Query(value = "SELECT new com.example.demo.Class.Tab(COUNT(*)/(SELECT COUNT(*)  FROM  MigrationOrder) * 100,status) FROM  MigrationOrder  where DUEDATE between :date1 and :date2 group by status")
 List<Tab> getStatus(@Param("date1") String date1, @Param("date2") String date2 );
MigrationOrder findByMSISDN(String num);


    MigrationOrder findByCOCODE(String cocode);
}
