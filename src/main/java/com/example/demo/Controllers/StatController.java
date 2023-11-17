package com.example.demo.Controllers;


import com.example.demo.Class.Tab;
import com.example.demo.Repositories.MigrationOrderRepository;
import com.example.demo.model.Dates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

public class StatController {
    @Autowired
    MigrationOrderRepository migrationOrderRepository;

    @GetMapping   (value = "/statistiques/{date}")
    List<Tab> getStat(@PathVariable String date) throws  Exception{
        String d=(String) date.toString();
        System.err.println("\n "+" la date est de type string :"+d);
        return migrationOrderRepository.getStatus("2022-05-19",d);
    }




}
