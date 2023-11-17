package com.example.demo.Controllers;


import com.example.demo.Class.Creteria;
import com.example.demo.Class.MigrationOrder;
import com.example.demo.Repositories.MigrationOrderRepository;
import com.example.demo.Services.MigrationOrderService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MigrationOrderCotroller {
    @Autowired
    MigrationOrderService migrationOrderService;
    @Autowired
    MigrationOrderRepository migrationOrderRepository;



  /*  @RequestMapping("/MigrationOrders")
    public List<MigrationOrder> getMigrationOrders() {
        return migrationOrderService.getMigrationOrders();
    }
*/

   @PostMapping(value = "/MigrationOrder")
    public MigrationOrder getMigrationOrder(@RequestBody MigrationOrder migrationOrder) {

       MigrationOrder migration = migrationOrderRepository.findByMSISDN(migrationOrder.MSISDN);

       return (migration);

   }

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private Creteria migrationOrderDao;

    @GetMapping("/search")
    @Transactional
    public ResponseEntity<List<MigrationOrder>> searchMigrationOrders(
            @RequestParam(required = false) Integer orderId,
            @RequestParam(required = false) String dueDate,
            @RequestParam(required = false) String coCode,
            @RequestParam(required = false) String offerInitDes,
            @RequestParam(required = false) String offerTargetDes,
            @RequestParam(required = false) String msisdn) {

        List<MigrationOrder> migrationOrders = migrationOrderDao.search(orderId, dueDate, coCode, offerInitDes, offerTargetDes, msisdn);
        return ResponseEntity.ok(migrationOrders);
    }
}






