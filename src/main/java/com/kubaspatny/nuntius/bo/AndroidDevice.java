package com.kubaspatny.nuntius.bo;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Author: Kuba Spatny
 * Web: kubaspatny.cz
 * E-mail: kuba.spatny@gmail.com
 * Date: 8/29/14
 * Time: 9:25 PM
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
public class AndroidDevice extends AbstractBusinessObject {

    @Column(nullable = false)
    private String mRegistrationId;

    @Column(nullable = true)
    private String mUsername;

    public AndroidDevice() {
    }

    public AndroidDevice(String mRegistrationId, String mUsername) {
        this.mRegistrationId = mRegistrationId;
        this.mUsername = mUsername;
    }

    public AndroidDevice(Long id, String mRegistrationId, String mUsername) {
        this.id = id;
        this.mRegistrationId = mRegistrationId;
        this.mUsername = mUsername;
    }

    public String getmRegistrationId() {
        return mRegistrationId;
    }

    public void setmRegistrationId(String mRegistrationId) {
        this.mRegistrationId = mRegistrationId;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }
}
