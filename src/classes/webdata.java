/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author reham
 */
public class webdata {
    String Username;
    String Name;
    String Password;
    String PasswordGenerator;
    String passwordweb;
    String website;
    String category;
    String passwordgenerator;
    String bankName;
    String AccountHolder;
    int cardNumber;
    int CVV;
    int securityCode;

    public webdata(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }
 public String getUsername() {
        return Username;
    }

    public void setUsername (String Username) {
        this.Username = Username;
    }
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPasswordGenerator() {
        return PasswordGenerator;
    }

    public void setPasswordGenerator(String PasswordGenerator) {
        this.PasswordGenerator = PasswordGenerator;
    }


    public String getPasswordweb() {
        return passwordweb;
    }

    public void setPasswordweb(String passwordweb) {
        this.passwordweb = passwordweb;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPasswordgenerator() {
        return passwordgenerator;
    }

    public void setPasswordgenerator(String passwordgenerator) {
        this.passwordgenerator = passwordgenerator;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountHolder() {
        return AccountHolder;
    }

    public void setAccountHolder(String AccountHolder) {
        this.AccountHolder = AccountHolder;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public webdata(String bankName, String AccountHolder, int cardNumber, int CVV, int securityCode) {
        this.bankName = bankName;
        this.AccountHolder = AccountHolder;
        this.cardNumber = cardNumber;
        this.CVV = CVV;
        this.securityCode = securityCode;
    }

    public webdata(String Name, String Password, String PasswordGenerator) {
        this.Name = Name;
        this.Password = Password;
        this.PasswordGenerator = PasswordGenerator;
    }

    public webdata(String Username, String passwordweb, String website, String category, String passwordgenerator) {
        this.Username = Username;
        this.passwordweb = passwordweb;
        this.website = website;
        this.category = category;
        this.passwordgenerator = passwordgenerator;
    }
    
}