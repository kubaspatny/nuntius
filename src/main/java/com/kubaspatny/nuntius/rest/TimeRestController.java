package com.kubaspatny.nuntius.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Author: Kuba Spatny
 * Web: kubaspatny.cz
 * E-mail: kuba.spatny@gmail.com
 * Date: 8/14/14
 * Time: 10:47 AM
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
@RequestMapping("/time")
public class TimeRestController {

    @RequestMapping(value = "/localTime", method = RequestMethod.GET, produces = "text/plain")
    public String getLocalTime() {

        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("Europe/Prague"));
        return formatTime(cal.get(Calendar.HOUR_OF_DAY)) + ":" + formatTime(cal.get(Calendar.MINUTE)) + ":" + formatTime(cal.get(Calendar.SECOND));

    }

    private String formatTime(int time){
        if(time < 10){
            return "0" + time;
        }

        return time + "";
    }

}
