package com.acc.training.accountapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "account", schema = "acn")
public class Account {

    @Id
    @Schema(description = "account number", example = "12345", required = true)
    @NotBlank
    @Size(min = 5, max = 8)
    private Integer accountNumber;

    @Schema(description = "Name of the account.", example = "Abercrombie & Fitch", required = true)
    @NotBlank
    @Column(name = "accountName", nullable = false)
    private String accountName;

    @Schema(description = "Account type - Personal/Business/Other", example = "Business", required = true)
    @Column(name = "accountType", nullable = false)
    private String accountType;

    public Account() {

    }

    public Account(Integer accountNumber, String accountName, String accountType) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
    }

    public Integer getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

}
