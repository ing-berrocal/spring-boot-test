package co.com.bancolombia.demoapi.usecase;

import co.com.bancolombia.demoapi.model.BankAccount;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@ApplicationScope
public class BankAccountUseCase {

    private Map<Integer, BankAccount> mapData = new HashMap<>();

    @PostConstruct
    private void init() {

        BankAccount bancolombia01 = new BankAccount(1, "1000-01", "CUENTA_AHORRO","Bancolombia");
        BankAccount bancolombia02 = new BankAccount(2, "2000-02", "CUENTA_AHORRO","Bancolombia");
        mapData.put(bancolombia01.getId(), bancolombia01);
        mapData.put(bancolombia02.getId(), bancolombia02);
    }

    public List<BankAccount> getBankAccounts(){
        return new ArrayList<>(mapData.values());
    }

    public BankAccount getBankAccountById(int id){
        return mapData.get(id);
    }

    public void addBankAccount(BankAccount bankAccount){
        mapData.put(bankAccount.getId(),bankAccount);
    }

    public void updateBankAccount(BankAccount bankAccount){
        if(mapData.containsKey(bankAccount.getId())){
            mapData.put(bankAccount.getId(),bankAccount);
        }
    }

    public BankAccount deleteBankAccount(Integer bankAccountId){
        return mapData.remove(bankAccountId);
    }
}
