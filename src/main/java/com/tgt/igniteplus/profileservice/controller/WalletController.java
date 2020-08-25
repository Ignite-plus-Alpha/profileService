package com.tgt.igniteplus.profileservice.controller;

import com.tgt.igniteplus.profileservice.exceptions.AddressNotFoundException;
import com.tgt.igniteplus.profileservice.exceptions.MaxLimitReached;
import com.tgt.igniteplus.profileservice.exceptions.WalletNotFoundException;
import com.tgt.igniteplus.profileservice.model.Address;
import com.tgt.igniteplus.profileservice.model.Wallet;
import com.tgt.igniteplus.profileservice.services.WalletServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class WalletController {
    @Autowired
    private WalletServices walletService;
    @Value("${limit.max}")
    private int max;

    @ApiOperation(value = "get all wallets in db")
    @GetMapping("/wallet")
    public List<Wallet> getAllWallets() {
        return walletService.getAllWallet();
    }

    @ApiOperation(value = "get all wallets of a user by their userId")
    @GetMapping("/wallet/{userId}")
    public List<Wallet> getAllWalletsByUserId(@PathVariable("userId")String userId) {
        try {
            return walletService.getWalletsByUserID( userId );
        } catch (WalletNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }
    @ApiOperation(value = "get particular wallet of a user by their userId and wallet id")
    @GetMapping("/wallet/{userId}/{walletid}")
    public Wallet getWalletByUserIdWalletId(@PathVariable("userId")String userId, @PathVariable("walletid")String walletId) throws WalletNotFoundException {
        return walletService.getWalletByUserIdWalletId(userId, walletId );
    }

    @ApiOperation(value = "create a wallet")
    @PostMapping("/wallet")
    public Wallet createWallet( @RequestBody Wallet wallet) throws MaxLimitReached {
        String userId=wallet.getUserid();
        if(getAllWalletsByUserId(userId).size()==max) throw new MaxLimitReached("can not add more than 5 wallet");

        return walletService.createWallet(wallet);
    }

    @ApiOperation(value = "update particular wallet of a user by their userId and wallet id")
    @PutMapping("/wallet/{userId}/{walletId}")
    public Wallet updateWalletByUserIdWalletId(@PathVariable("userId") String userId,@PathVariable("walletId") String walletId,@RequestBody Wallet wallet) throws WalletNotFoundException{
        return walletService.updateWalletByUserIdWalletId(userId,walletId, wallet);
    }

    @ApiOperation(value = "delete particular wallet of a user by their userId and wallet id")
    @DeleteMapping("/wallet/{userId}/{walletId}")
    public void deleteWalletByUserIdWalletId(@PathVariable("userId") String userId,@PathVariable("walletId") String walletId) throws WalletNotFoundException{
        walletService.deleteWalletByUserIdWalletId(userId, walletId);
    }
}