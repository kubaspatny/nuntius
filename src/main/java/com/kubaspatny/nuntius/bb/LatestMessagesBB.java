package com.kubaspatny.nuntius.bb;

import com.kubaspatny.nuntius.dto.ShortMessageDto;
import com.kubaspatny.nuntius.service.IShortMessageService;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import java.util.List;

/**
 * Author: Kuba Spatny
 * Web: kubaspatny.cz
 * E-mail: kuba.spatny@gmail.com
 * Date: 8/13/14
 * Time: 10:24 PM
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

@Component("latestMessagesBB")
@Scope("request")
public class LatestMessagesBB {

    @Autowired
    private IShortMessageService messageService;

    private List<ShortMessageDto> messages;

    public List<ShortMessageDto> getMessages() {

        if(messages == null) {
            messages = messageService.getLatest10();
        }

        return messages;
    }

    public void setMessages(List<ShortMessageDto> messages) {
        this.messages = messages;
    }

    public void refresh(){
        messages = messageService.getLatest10();
    }

    public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Complete!", "Missiles fired!");
        System.out.println("showMessage() called!");
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }

}
