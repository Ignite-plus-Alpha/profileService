package com.tgt.igniteplus.profileservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.igniteplus.profileservice.model.Wallet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class WalletControllerTest {

    private MockMvc mockMvc;

    @Mock
    private WalletController walletController ;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(walletController).build();
    }

    @Test
    public void getAllWallets() throws Exception {
        Wallet wallet = new Wallet();
        wallet.setUserid("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        wallet.setWalletId("789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5");
        wallet.setCardholderName("Name");
        wallet.setCardNumber((long) 444446447);
        wallet.setExpiryDate("");
        wallet.setUpiId("name@oksbi");
        List<Wallet> allWallet=singletonList(wallet);
        given(walletController.getAllWallets()).willReturn(allWallet);
        mockMvc.perform(get("/api/wallet")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllWalletsByUserId() throws Exception{
        Wallet wallet = new Wallet();
        wallet.setUserid("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        wallet.setWalletId("789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5");
        wallet.setCardholderName("Name");
        wallet.setCardNumber((long) 444446447);
        wallet.setExpiryDate("");
        wallet.setUpiId("name@oksbi");
        List<Wallet> wallets=singletonList(wallet);
        given(walletController.getAllWalletsByUserId(wallet.getUserid())).willReturn(wallets);
        mockMvc.perform(get("/api/address/8bffcb0d-e44e-4331-9911-7f3a5be08f0a")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createWallet() throws Exception {
        Wallet wallet = new Wallet();
        wallet.setUserid("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        wallet.setWalletId("789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5");
        wallet.setCardholderName("Name");
        wallet.setCardNumber((long) 444446447);
        wallet.setExpiryDate("");
        wallet.setUpiId("name@oksbi");
        String message=new String();
        given(walletController.createWallet(wallet)).willReturn(wallet);
        mockMvc.perform(post("/api/wallet")
                .content(asJsonString(message))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getWalletByUserIdWalletId() throws Exception {
        Wallet wallet = new Wallet();
        wallet.setUserid("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        wallet.setWalletId("789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5");
        wallet.setCardholderName("Name");
        wallet.setCardNumber((long) 444446447);
        wallet.setExpiryDate("");
        wallet.setUpiId("name@oksbi");
        given(walletController.getWalletByUserIdWalletId(wallet.getUserid(),wallet.getWalletId())).willReturn(wallet);
        mockMvc.perform(get("/api/wallet/8bffcb0d-e44e-4331-9911-7f3a5be08f0a/789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateWalletByUserIdWalletId() throws Exception{
        Wallet wallet = new Wallet();
        wallet.setUserid("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        wallet.setWalletId("789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5");
        wallet.setCardholderName("Name");
        wallet.setCardNumber((long) 444446447);
        wallet.setExpiryDate("");
        wallet.setUpiId("name@oksbi");
        given(walletController.updateWalletByUserIdWalletId(wallet.getUserid(),wallet.getWalletId(),wallet)).willReturn(wallet);
        mockMvc.perform(put("/api/wallet/8bffcb0d-e44e-4331-9911-7f3a5be08f0a/789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

//    @Test
//    public void deleteWalletByUserIdWalletId() throws Exception {
//        Wallet wallet = new Wallet();
//        wallet.setUserid("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
//        wallet.setWalletId("789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5");
//        wallet.setCardholderName("Name");
//        wallet.setCardNumber((long) 444446447);
//        wallet.setExpiryDate("");
//        wallet.setUpiId("name@oksbi");
//        given(walletController.deleteWalletByUserIdWalletId(wallet.getUserid(),wallet.getWalletId())).willReturn(null);
//
//        mockMvc.perform(delete("/api/wallet/8bffcb0d-e44e-4331-9911-7f3a5be08f0a/789c5ea5-6fb4-4dc7-a84c-5bc209cf64c5")
//                .contentType(APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
}