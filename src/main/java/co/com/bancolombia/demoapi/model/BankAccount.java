package co.com.bancolombia.demoapi.model;

public class BankAccount {

    private int id;
    private String bankName;
    private String accountType;
    private String accountName;

    public BankAccount(int id, String bankName, String accountType, String accountName) {
        this.id = id;
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
