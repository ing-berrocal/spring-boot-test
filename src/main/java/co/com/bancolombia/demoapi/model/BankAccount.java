package co.com.bancolombia.demoapi.model;

import javax.persistence.*;

@Entity
@Table(schema = "public",name = "tbl_bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "account_name")
    private String accountName;

    public BankAccount(){}

    public BankAccount(String accountName, String accountType, String bankName) {
        this.bankName = bankName;
        this.accountType = accountType;
        this.accountName = accountName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getBankName() {
        return bankName;
    }
}
