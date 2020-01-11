package com.gs.service.impl;

import com.gs.repo.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @Mock
    private UserPaymentRepository userPaymentRepository;

    @Mock
    private UserShippingRepository userShippingRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @InjectMocks
    private UserServiceImpl service;

    @BeforeAll
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getPasswordResetToken() {


    }

    @Test
    void createPasswordResetTokenForUser() {
    }

    @Test
    void findByUsername() {
    }

    @Test
    void findByEmail() {
    }

    @Test
    void createUser() {
    }

    @Test
    void save() {
    }

    @Test
    void updateUserBilling() {
    }

    @Test
    void setUserDefaultPayment() {
    }

    @Test
    void updateUserShipping() {
    }

    @Test
    void setUserDefaultShipping() {
    }

    @Test
    void findById() {
    }
}