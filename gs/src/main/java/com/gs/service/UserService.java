package com.gs.service;

import com.gs.domain.User;
import com.gs.domain.UserBilling;
import com.gs.domain.UserPayment;
import com.gs.domain.UserShipping;
import com.gs.domain.security.PasswordResetToken;
import com.gs.domain.security.UserRole;

import java.util.Set;

public interface UserService {
    PasswordResetToken getPasswordResetToken(final String token);

    void createPasswordResetTokenForUser(final User user, final String token);

    User findByUsername(String username);

    User findByEmail(String email);

    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User save(User user);

    void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);

    void setUserDefaultPayment(Long userPaymentId, User user);

    void updateUserShipping(UserShipping userShipping, User user);

    void setUserDefaultShipping(Long id, User user);

    User findById(Long id) throws Exception;
}
