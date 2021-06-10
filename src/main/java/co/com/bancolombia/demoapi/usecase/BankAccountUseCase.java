package co.com.bancolombia.demoapi.usecase;

import co.com.bancolombia.demoapi.model.BankAccount;
import co.com.bancolombia.demoapi.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@ApplicationScope
public class BankAccountUseCase {

    private Map<Integer, BankAccount> mapData = new HashMap<>();
    @Autowired
    private BankAccountService service;

    @PostConstruct
    private void init() {

        BankAccount bancolombia01 = new BankAccount("1000-01", "CUENTA_AHORRO","Bancolombia");
        BankAccount bancolombia02 = new BankAccount("2000-02", "CUENTA_AHORRO","Bancolombia");
        mapData.put(bancolombia01.getId(), bancolombia01);
        mapData.put(bancolombia02.getId(), bancolombia02);

        service.save(bancolombia01);
        service.save(bancolombia02);
    }

    public List<BankAccount> getBankAccounts(){
        return service.findAll();
    }

    public BankAccount getBankAccountById(int id){
        final BankAccount byId = service.getById(id);
        if(byId == null){
            throw new RuntimeException();
        }
        return byId;
    }

    public void addBankAccount(BankAccount bankAccount){
        service.save(bankAccount);
    }

    public void updateBankAccount(BankAccount bankAccount){
        getBankAccountById(bankAccount.getId());
        service.save(bankAccount);
    }

    public BankAccount deleteBankAccount(Integer bankAccountId){
        final BankAccount byId = getBankAccountById(bankAccountId);
        service.delete(byId);
        return byId;
    }

}
