package com.example.demo.Services;

import com.example.demo.Class.MigrationOrder;
import com.example.demo.Repositories.MigrationOrderRepository;
import com.example.demo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MigrationOrderService {
    @Autowired
    MigrationOrderRepository migrationOrderRepository;

    public List<MigrationOrder> getMigrationOrders(){
        List<MigrationOrder> migrationOrderList=new ArrayList<>();
        migrationOrderRepository.findAll().forEach(m->{
            migrationOrderList.add(m);
        });
        return migrationOrderList;
    }
    /*
    public MigrationOrder getMigrationOrder(String MSISDN, String COCODE, String OFFER_INIT, String OFFER_TARGET, String DUEDATE){
       MigrationOrder m = migrationOrderRepository.getMigration(MSISDN, COCODE,  OFFER_INIT,  OFFER_TARGET, DUEDATE);
        return m;
    }
*/

        @Autowired
        private EntityManager entityManager;

        public List<MigrationOrder> searchCustomers(MigrationOrder searchDTO) {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<MigrationOrder> query = criteriaBuilder.createQuery(MigrationOrder.class);
            Root<MigrationOrder> root = query.from(MigrationOrder.class);

            List<Predicate> predicates = new ArrayList<>();

            if (searchDTO.ORDER_ID !=null) {
                predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("ORDER_ID")), searchDTO.ORDER_ID));
            }

            if (StringUtils.hasText(searchDTO.DUEDATE)) {
                predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("DUEDATE")), searchDTO.DUEDATE));
            }

            if (StringUtils.hasText(searchDTO.MSISDN)) {
                predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("MSISDN")), searchDTO.MSISDN));
            }

            if (StringUtils.hasText(searchDTO.OFFER_INIT_DES)) {
                predicates.add(criteriaBuilder.equal(root.get("OFFER_INIT_DES"), searchDTO.OFFER_INIT_DES));
            }
            if (StringUtils.hasText(searchDTO.OFFER_TARGET_DES)) {
                predicates.add(criteriaBuilder.equal(root.get("OFFER_TARGET_DES"), searchDTO.OFFER_TARGET_DES));
            }
            if (StringUtils.hasText(searchDTO.COCODE)) {
                predicates.add(criteriaBuilder.equal(root.get("COCODE"), searchDTO.COCODE));
            }
            query.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));

            TypedQuery<MigrationOrder> typedQuery = entityManager.createQuery(query);
            return typedQuery.getResultList();
        }
    }


