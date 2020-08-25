package com.tgt.igniteplus.profileservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.igniteplus.profileservice.model.Profile;
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
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProfileControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProfileController profileController ;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(profileController).build();
    }

    @Test
    public void getAllUsers() throws Exception {
        Profile profile = new Profile();
        profile.setEmail("testcase@gmail.com");
        profile.setUserId("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        profile.setFirstName("test");
        profile.setLastName("case");
        profile.setMobile("1234567897");
        profile.setPassword("password");
        profile.setDefaultAddress("Bangalore");
        profile.setDefaultCard("4444444444444444");
        List<Profile> allUsers=singletonList(profile);
        given(profileController.getAllUsers()).willReturn(allUsers);
        mockMvc.perform(get("/api/user")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void registerUser() throws Exception{
        Profile profile = new Profile();
        profile.setEmail("testcase@gmail.com");
        profile.setUserId("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        profile.setFirstName("test");
        profile.setLastName("case");
        profile.setMobile("1234567897");
        profile.setPassword("password");
        profile.setDefaultAddress("Bangalore");
        profile.setDefaultCard("4444444444444");

        String mail = new String();
        given(profileController.registerUser(profile.getEmail())).willReturn(mail);
        mockMvc.perform(get("/api/register/testcase@gmail.com")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createUser() throws Exception {
        Profile profile = new Profile();
        profile.setEmail("testcase@gmail.com");
        profile.setUserId("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        profile.setFirstName("test");
        profile.setLastName("case");
        profile.setMobile("1234567897");
        profile.setPassword("password");
        profile.setDefaultAddress("");
        profile.setDefaultCard("");
        String message=new String();
        given(profileController.createUser(profile)).willReturn(profile);
        mockMvc.perform(post("/api/user")
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
    public void getUserByEmailId() throws Exception {
        Profile profile = new Profile();
        profile.setEmail("testcase@gmail.com");
        profile.setUserId("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        profile.setFirstName("test");
        profile.setLastName("case");
        profile.setMobile("1234567897");
        profile.setPassword("password");
        profile.setDefaultAddress("");
        profile.setDefaultCard("");
        given(profileController.getUserByEmailId(profile.getEmail())).willReturn(Optional.of(profile));
        mockMvc.perform(get("/api/user/testcase@gmail.com")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

  //  @Test
//    public void deleteUserByEmailId() throws Exception {
//        Profile profile = new Profile();
//        profile.setEmail("testcase@gmail.com");
//        profile.setUserId("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
//        profile.setFirstName("test");
//        profile.setLastName("case");
//        profile.setMobile("1234567897");
//        profile.setPassword("password");
//        profile.setDefaultAddress("");
//        profile.setDefaultCard("");
//        String message="user deleted";
//        given(profileController.deleteUserById(profile.getEmail())).willReturn(null);
//        mockMvc.perform(delete("/user/testcase@gmail.com")
//                .contentType(APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }

    @Test
    public void updateUserById() throws Exception{
        Profile profile = new Profile();
        profile.setEmail("testcase@gmail.com");
        profile.setUserId("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        profile.setFirstName("test");
        profile.setLastName("case");
        profile.setMobile("1234567897");
        profile.setPassword("password");
        profile.setDefaultAddress("");
        profile.setDefaultCard("");
        given(profileController.updateUserById(profile.getEmail(),profile)).willReturn(profile);
        mockMvc.perform(put("/api/user/testcase@gmail.com")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void updateDefaultAddressByUserId() throws Exception{
        Profile profile = new Profile();
        profile.setEmail("testcase@gmail.com");
        profile.setUserId("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        profile.setFirstName("test");
        profile.setLastName("case");
        profile.setMobile("1234567897");
        profile.setPassword("password");
        profile.setDefaultAddress("");
        profile.setDefaultCard("");
        given(profileController.updateDefaultAddressByUserId(profile.getEmail(),profile.getDefaultAddress())).willReturn(profile);
        mockMvc.perform(put("/api/user/address/testcase@gmail.com")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void updateDefaultWalletByUserId() throws Exception{
        Profile profile = new Profile();
        Wallet wallet=new Wallet();
        profile.setEmail("testcase@gmail.com");
        profile.setUserId("8bffcb0d-e44e-4331-9911-7f3a5be08f0a");
        profile.setFirstName("test");
        profile.setLastName("case");
        profile.setMobile("1234567897");
        profile.setPassword("password");
        profile.setDefaultAddress("");
        profile.setDefaultCard("");
        given(profileController.updateDefaultWalletByUserId(profile.getEmail(),wallet.getWalletId())).willReturn(profile);
        mockMvc.perform(put("/api/user/wallet/testcase@gmail.com")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}