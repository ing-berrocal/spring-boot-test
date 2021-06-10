package co.com.bancolombia.demoapi.service;

import co.com.bancolombia.demoapi.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountService extends JpaRepository<BankAccount,Integer>{
}
