package co.com.bancolombia.demoapi.controller;

import co.com.bancolombia.demoapi.model.BankAccount;
import co.com.bancolombia.demoapi.usecase.BankAccountUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/bankaccount", produces = MediaType.APPLICATION_JSON_VALUE)
public class BankAccountController {

    @Autowired
    private BankAccountUseCase useCase;

    @GetMapping
    public List getListBankAccount(){
        return useCase.getBankAccounts();
    }

    @GetMapping(path = "/{id}")
    public BankAccount getBankAccountById(@PathVariable("id") Integer id){

        return useCase.getBankAccountById(id);
    }

    @PostMapping
    public ResponseEntity addBankAccount(@RequestBody BankAccount bankAccount){
        useCase.addBankAccount(bankAccount);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity editBankAccount(@RequestBody BankAccount bankAccount){
        useCase.updateBankAccount(bankAccount);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity deleteBankAccount(@PathVariable("id") Integer id){
        useCase.deleteBankAccount(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
