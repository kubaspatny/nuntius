package com.kubaspatny.nuntius.rest;

import com.kubaspatny.nuntius.dto.AndroidDeviceDto;
import com.kubaspatny.nuntius.dto.ShortMessageDto;
import com.kubaspatny.nuntius.service.IAndroidDeviceService;
import com.kubaspatny.nuntius.service.IShortMessageService;
import com.kubaspatny.nuntius.utils.GCMMessage;
import com.kubaspatny.nuntius.utils.GCMUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Kuba Spatny
 * Web: kubaspatny.cz
 * E-mail: kuba.spatny@gmail.com
 * Date: 8/14/14
 * Time: 10:13 AM
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
@RequestMapping("/msg")
public class MessageRestController {

    private final static String DEBUG_TAG = "MessageRestController";

    @Autowired
    private IShortMessageService shortMessageService;

    @Autowired
    private IAndroidDeviceService androidDeviceService;

    @RequestMapping(value = "/message/{id}", method = RequestMethod.GET, produces = "text/plain")
    public String getMessageById(@PathVariable String id) {

        Long id_value = null;

        try  {
            id_value = Long.parseLong(id);

            ShortMessageDto message = shortMessageService.getById(id_value);
            if(message != null){
                return message.getmMessageBody();
            }

        } catch (NumberFormatException e){
            // log message
            return "Wrong ID format.";
        }

        return "Message with id " + id + " doesn't exist.";

    }

    @RequestMapping(value = "/message-json/{id}", method = RequestMethod.GET, produces = "application/json")
    public ShortMessageDto getMessageJSONById(@PathVariable String id) {

        Long id_value = null;

        try  {
            id_value = Long.parseLong(id);

            ShortMessageDto message = shortMessageService.getById(id_value);
            if(message != null){
                return message;
            }

        } catch (NumberFormatException e){
            // log message
            return null;
        }

        return null;

    }

    @RequestMapping(value = "/message/new/{value}", method = RequestMethod.GET)
    public String addMessage(@PathVariable String value) {

        try {
            if(value != null && shortMessageService != null) shortMessageService.add(value);
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return "500 Internal Server Error - Message couldn't be added.";
        }

        return "200 OK";
    }

    //@RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequestMapping(value = "/add")
    public ResponseEntity<String> add(@RequestParam(value="message", required=false, defaultValue="") String value) {

        try {
            if(value != null && shortMessageService != null) {

                if(value.isEmpty()) return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

                Long newMessageID = shortMessageService.add(value);

                if(newMessageID == null) System.out.println("newMessageID == null"); // ************************************

                // this should be done asynchronously via some listener for new message
                ShortMessageDto m = shortMessageService.getById(newMessageID);

                if(m == null) System.out.println("m == null"); // ************************************

                Map<String, String> values = new HashMap<String, String>();
                values.put("message", m.getmMessageBody());

                if(values == null) System.out.println("values == null"); // ************************************

                List<String> registrationIds = AndroidDeviceDto.getRegistrationIds(androidDeviceService.getAll());

                if(registrationIds == null) System.out.println("registrationIds == null"); // ************************************

                GCMUtils.sendNotification(values, registrationIds);

//                GCMMessage message = new GCMMessage();
//                message.addData("message", m.getmMessageBody());
//
//                for(String regID : registrationIds){
//                    message.addRegId(regID);
//                }

//                GCMUtils.post(message);

                // --------------------------------------------------------------------

            }
        } catch (Exception e){
            System.out.println(DEBUG_TAG + ":");
            e.printStackTrace();
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>(HttpStatus.OK);

    }


}
