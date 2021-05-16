package com.acc.training.accountapi.controller;

import java.util.List;

import com.acc.training.accountapi.model.Account;
import com.acc.training.accountapi.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @Operation(summary = "Get a account by its account number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the accounts", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Account.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Account not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @RequestMapping(path = "/getAllAccounts", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getAccounts() {

        List<Account> response = service.findAllAccounts();

        System.out.println("Response: " + response.size());

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @Operation(summary = "Create Account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "account created successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Account.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account response = service.saveAccount(account);

        System.out.println("Response: " + response.getAccountName());

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
