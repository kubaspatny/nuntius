package com.kubaspatny.nuntius.dto;

import com.kubaspatny.nuntius.bo.ShortMessage;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Author: Kuba Spatny
 * Web: kubaspatny.cz
 * E-mail: kuba.spatny@gmail.com
 * Date: 8/4/14
 * Time: 11:28 PM
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
public class ShortMessageDto extends AbstractDto {

    private String mMessageBody;
    private DateTime mMessageTimestamp;

    public ShortMessageDto(Long id, String messageBody, DateTime messageTimestamp){
        this.id = id;
        this.mMessageBody = messageBody;
        this.mMessageTimestamp = messageTimestamp;
    }

    public String getmMessageBody() {
        return mMessageBody;
    }

    public void setmMessageBody(String mMessageBody) {
        this.mMessageBody = mMessageBody;
    }

    public DateTime getmMessageTimestamp() {
        return mMessageTimestamp;
    }

    public void setmMessageTimestamp(DateTime mMessageTimestamp) {
        this.mMessageTimestamp = mMessageTimestamp;
    }

    public String getTimestampString(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        return dateTimeFormatter.print(this.mMessageTimestamp.toDateTime(DateTimeZone.forID("Europe/Prague")));
    }

    public static ShortMessageDto convert(ShortMessage message){
        if(message == null) return null;
        return new ShortMessageDto(message.getId(), message.getmMessageBody(), message.getmMessageTimeStamp());
    }

    public static List<ShortMessageDto> convert(List<ShortMessage> messages){
        List<ShortMessageDto> messageDtos = new ArrayList<ShortMessageDto>();
        for(ShortMessage m : messages){
            messageDtos.add(ShortMessageDto.convert(m));
        }
        return messageDtos;
    }

    public static ShortMessage convertToBusinessObject(ShortMessageDto messageDto){
        if(messageDto == null) return null;

        return new ShortMessage.ShortMessageBuilder().setId(messageDto.getId())
                                    .setMessageBody(messageDto.getmMessageBody())
                                    .setMessageTimestamp(messageDto.getmMessageTimestamp())
                                    .build();
    }
}
