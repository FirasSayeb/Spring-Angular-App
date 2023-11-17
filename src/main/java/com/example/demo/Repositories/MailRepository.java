package com.example.demo.Repositories;

import com.example.demo.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Mail,Integer> {


}
