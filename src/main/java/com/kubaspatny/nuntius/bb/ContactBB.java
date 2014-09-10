package com.kubaspatny.nuntius.bb;

import com.kubaspatny.nuntius.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Author: Kuba Spatny
 * Web: kubaspatny.cz
 * E-mail: kuba.spatny@gmail.com
 * Date: 9/10/14
 * Time: 9:16 PM
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

@Component("contactBB")
@Scope("request")
public class ContactBB {

    @Autowired
    private EmailService emailService;

    private String name;
    private String email;
    private String subject;
    private String text;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void sendEmail(){

        if(isNullOrEmpty(name) || isNullOrEmpty(email) || isNullOrEmpty(subject) ||isNullOrEmpty(text)) return;

        emailService.sendAsyncEmail(email, subject, text);

        name = "";
        email = "";
        subject = "";
        text = "";

    }

    private boolean isNullOrEmpty(String text){
        return (text == null || text.trim().isEmpty());
    }
}
