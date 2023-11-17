package com.example.demo.Class;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class Creteria {

    private final EntityManager entityManager;

    public Creteria(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<MigrationOrder> search(Integer orderId, String dueDate, String coCode, String offerInitDes,
                                       String offerTargetDes, String msisdn) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MigrationOrder> query = builder.createQuery(MigrationOrder.class);
        Root<MigrationOrder> root = query.from(MigrationOrder.class);

        List<Predicate> predicates = new ArrayList<>();
        if (orderId != null) {
            predicates.add(builder.equal(root.get("ORDER_ID"), orderId));
        }
        if (dueDate != null) {
            predicates.add(builder.equal(root.get("DUEDATE"), dueDate));
        }
        if (coCode != null) {
            predicates.add(builder.equal(root.get("COCODE"), coCode));
        }
        if (offerInitDes != null) {
            predicates.add(builder.equal(root.get("OFFER_INIT_DES"), offerInitDes));
        }
        if (offerTargetDes != null) {
            predicates.add(builder.equal(root.get("OFFER_TARGET_DES"), offerTargetDes));
        }
        if (msisdn != null) {
            predicates.add(builder.equal(root.get("MSISDN"), msisdn));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
