package com.kubaspatny.nuntius.service;

import com.kubaspatny.nuntius.dao.GenericDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Author: Kuba Spatny
 * Web: kubaspatny.cz
 * E-mail: kuba.spatny@gmail.com
 * Date: 8/4/14
 * Time: 10:22 PM
 * Copyright 2014 Jakub Spatny
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class AuthService extends AbstractUserDetailsAuthenticationProvider {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractUserDetailsAuthenticationProvider.class);
    private GenericDao genericDAO;
    private TransactionTemplate transactionTemplate;

    public AuthService() {
        this.setUserCache(new NullUserCache());
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails ud, UsernamePasswordAuthenticationToken upat) throws AuthenticationException {
        // do nothing
    }

    /**
     * @param username
     * @param upat
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected UserDetails retrieveUser(final String username, final UsernamePasswordAuthenticationToken upat) throws AuthenticationException {
//        //only public methods can be marked as transactional
//        return (UserDetails) transactionTemplate.execute(new TransactionCallback() {
//
//            @Override
//            public Object doInTransaction(TransactionStatus status) {
//                try {
//                    UserDetails ud = null;
//
//                    com.cvut.spatnjak.sin.teachus.bo.User u;
//                    try {
//                        u = genericDAO.getByPropertyUnique("username", username, com.cvut.spatnjak.sin.teachus.bo.User.class);
//                    } catch (EmptyResultDataAccessException erdaex) {
//                        throw new BadCredentialsException("Uzivatel neexistuje");
//                    }
//                    String password = (String) upat.getCredentials();
//                    if (u == null || !u.getPassword().equals(password)) {
//                        AuthenticationException e = new BadCredentialsException("Neplatne uzivatelske udaje");
//                        throw e;
//                    } else {
//                        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
//                        auths.add(new SimpleGrantedAuthority("ROLE_USER"));
//                        if(u.isAdmin()){
//                            auths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//                        }
//                        ud = new User(u.getUsername(), u.getPassword(), auths);
//                    }
//                    return ud;
//                } catch(AuthenticationException e){
//                    status.setRollbackOnly();
//                    throw e;
//                }catch (Exception e) {
//                    LOG.error("Error occured during retrieveUser call", e);
//                    status.setRollbackOnly();
//                    throw new RuntimeException(e);
//                }
//            }
//        });
        return null;
    }

    public void setGenericDAO(GenericDao genericDAO) {
        this.genericDAO = genericDAO;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

}
