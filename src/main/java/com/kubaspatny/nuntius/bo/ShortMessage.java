package com.kubaspatny.nuntius.bo;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

/**
 * Author: Kuba Spatny
 * Web: kubaspatny.cz
 * E-mail: kuba.spatny@gmail.com
 * Date: 8/4/14
 * Time: 11:09 PM
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

@Entity
public class ShortMessage extends AbstractBusinessObject {

    @Column(nullable = false, columnDefinition="TEXT")
    private String mMessageBody;

    @Column(nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime mMessageTimeStamp;

    public ShortMessage() {
    }

    private ShortMessage(Long id, String messageBody, DateTime messageTimestamp){
        this.id = id;
        this.mMessageBody = messageBody;
        this.mMessageTimeStamp = messageTimestamp;
    }

    public String getmMessageBody() {
        return mMessageBody;
    }

    public void setmMessageBody(String mMessageBody) {
        this.mMessageBody = mMessageBody;
    }

    public DateTime getmMessageTimeStamp() {
        return mMessageTimeStamp;
    }

    public void setmMessageTimeStamp(DateTime mMessageTimeStamp) {
        this.mMessageTimeStamp = mMessageTimeStamp;
    }

    public static class ShortMessageBuilder {

        private Long id;
        private String messageBody;
        private DateTime messageTimestamp;

        public ShortMessageBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ShortMessageBuilder setMessageBody(String messageBody) {
            this.messageBody = messageBody;
            return this;
        }

        public ShortMessageBuilder setMessageTimestamp(DateTime messageTimestamp){
            this.messageTimestamp = messageTimestamp;
            return this;
        }

        public ShortMessage build(){
            return new ShortMessage(id, messageBody, messageTimestamp);
        }
    }


}
