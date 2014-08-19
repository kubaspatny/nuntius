package com.kubaspatny.nuntius.service;

import com.kubaspatny.nuntius.bo.ShortMessage;
import com.kubaspatny.nuntius.dto.ShortMessageDto;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Author: Kuba Spatny
 * Web: kubaspatny.cz
 * E-mail: kuba.spatny@gmail.com
 * Date: 8/4/14
 * Time: 11:37 PM
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

@Component("shortMessageService")
public class ShortMessageService extends AbstractDataAccessService implements IShortMessageService {


    @Override
    public List<ShortMessageDto> getAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ShortMessageDto getById(Long messageId) {
        return ShortMessageDto.convert(genericDao.getById(messageId, ShortMessage.class));
    }

    @Override
    public List<ShortMessageDto> getLatest10() {
        List<ShortMessage> messages = genericDao.getTopN("id", 10, ShortMessage.class);
        return ShortMessageDto.convert(messages);
    }

    @Override
    public Long add(String messageBody) {

        DateTime timestamp = DateTime.now(DateTimeZone.UTC);
        ShortMessage message = new ShortMessage.ShortMessageBuilder().setMessageBody(messageBody)
                                                                     .setMessageTimestamp(timestamp)
                                                                     .build();
        return genericDao.saveOrUpdate(message).getId();
    }

    @Override
    public void update(ShortMessageDto messageDto) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(Long messageID) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
