package com.kubaspatny.nuntius.rest;

import com.kubaspatny.nuntius.service.IAndroidDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Kuba Spatny
 * Web: kubaspatny.cz
 * E-mail: kuba.spatny@gmail.com
 * Date: 8/29/14
 * Time: 9:46 PM
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

@RestController
@RequestMapping("/push/android")
public class GCMRegistrationController {

    public static final String REGISTRATION_ID = "com.kubaspatny.nuntius.gcm.registrationID";
    public static final String USERNAME = "com.kubaspatny.nuntius.gcm.username";

    @Autowired
    private IAndroidDeviceService androidDeviceService;

    //@RequestMapping(value = "/register", method = RequestMethod.POST)
    @RequestMapping(value = "/register")
    public ResponseEntity<String> register(@RequestParam(value=REGISTRATION_ID, required=true) String registrationId,
                                           @RequestParam(value=USERNAME, required=false) String username) {

        try {

            if(registrationId == null || registrationId.trim().isEmpty()) return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

            androidDeviceService.registerDevice(registrationId, username);

        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>(HttpStatus.OK);

    }

}
