package com.tgt.igniteplus.profileservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.igniteplus.profileservice.controller.AddressController;
import com.tgt.igniteplus.profileservice.model.Address;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class AddressControllerTest {

    private MockMvc mockMvc;

    @Mock

    private AddressController addressController ;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(addressController).build();
    }

    @Test
    public void getAllAddress() throws Exception {
        Address address= new Address();
        address.setUserid("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        address.setAddressId("8922b8a0-cf4c-43fa-abca-fd55c78e7d10");
        address.setAddressLine1(" #65 6th main ");
        address.setAddressLine2("yelahanka");
        address.setCity("Bangalore");
        address.setCountry("India");
        address.setState("Karnataka");
        address.setZipcode((long)560065);

        List<Address> allAddress=singletonList(address);
        given(addressController.getAllAddress()).willReturn(allAddress);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/address")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllAddressByUserId() throws Exception{
        Address address= new Address();
        address.setUserid("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        address.setAddressId("8922b8a0-cf4c-43fa-abca-fd55c78e7d10");
        address.setAddressLine1(" #65 6th main ");
        address.setAddressLine2("yelahanka");
        address.setCity("Bangalore");
        address.setCountry("India");
        address.setState("Karnataka");
        address.setZipcode((long)560065);
        List<Address> addresses=singletonList(address);
        given(addressController.getAllAddressesByUserId(address.getUserid())).willReturn(addresses);
        mockMvc.perform(get("/api/address/8bffcb0d-e44e-4331-9911-7f3a5be08f0a")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createAddress() throws Exception {
        Address address= new Address();
        address.setUserid("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        address.setAddressId("8922b8a0-cf4c-43fa-abca-fd55c78e7d10");
        address.setAddressLine1(" #65 6th main ");
        address.setAddressLine2("yelahanka");
        address.setCity("Bangalore");
        address.setCountry("India");
        address.setState("Karnataka");
        address.setZipcode((long)560065);
        String message=new String();
        given(addressController.createAddress(address)).willReturn(address);
        mockMvc.perform(post("/api/address")
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
    public void getAddressByUserIdAddressId() throws Exception {
        Address address= new Address();
        address.setUserid("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        address.setAddressId("8922b8a0-cf4c-43fa-abca-fd55c78e7d10");
        address.setAddressLine1(" #65 6th main ");
        address.setAddressLine2("yelahanka");
        address.setCity("Bangalore");
        address.setCountry("India");
        address.setState("Karnataka");
        address.setZipcode((long)560065);
        given(addressController.getAddressByUserIdAddressId(address.getUserid(),address.getAddressId())).willReturn(address);
        mockMvc.perform(get("/api/address/8bffcb0d-e44e-4331-9911-7f3a5be08f0a/8922b8a0-cf4c-43fa-abca-fd55c78e7d10")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateAddressByUserIdAddressId() throws Exception{
        Address address= new Address();
        address.setUserid("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        address.setAddressId("8922b8a0-cf4c-43fa-abca-fd55c78e7d10");
        address.setAddressLine1(" #65 6th main ");
        address.setAddressLine2("yelahanka");
        address.setCity("Bangalore");
        address.setCountry("India");
        address.setState("Karnataka");
        address.setZipcode((long)560065);
        given(addressController.updateAddressByUserIdAddressId(address.getUserid(),address.getAddressId(),address)).willReturn(address);
        mockMvc.perform(put("/api/address/8bffcb0d-e44e-4331-9911-7f3a5be08f0a/8922b8a0-cf4c-43fa-abca-fd55c78e7d10")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void deleteAddressByUserIdWalletId() throws Exception {
        Address address= new Address();
        address.setUserid("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        address.setAddressId("8922b8a0-cf4c-43fa-abca-fd55c78e7d10");
        address.setAddressLine1(" #65 6th main ");
        address.setAddressLine2("yelahanka");
        address.setCity("Bangalore");
        address.setCountry("India");
        address.setState("Karnataka");
        address.setZipcode((long)560065);
        //given(addressController.deleteAddressByUserIdWalletId(address.getUserid(),address.getAddressId())).willReturn(null);
        mockMvc.perform(delete("/api/address/8bffcb0d-e44e-4331-9911-7f3a5be08f0a/8922b8a0-cf4c-43fa-abca-fd55c78e7d10")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}