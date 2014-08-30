package com.kubaspatny.nuntius.service;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Author: Kuba Spatny
 * Web: kubaspatny.cz
 * E-mail: kuba.spatny@gmail.com
 * Date: 8/30/14
 * Time: 7:35 PM
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

@Service
public class GCMService {

    private final static String API_KEY = "AIzaSyA0hsNkTrDBezCPU83Atd2vtUvtbF4zVFA";
    public final static String DEBUG_TAG = "GCMService";

    @Async
    public void sendGCMNotification(Map<String, String> values, List<String> devices){

        Sender sender = new Sender(API_KEY);
        Message message = new Message.Builder().setData(values).build();

        try {
            MulticastResult result = sender.send(message, devices, 4);
        } catch (IOException e){
            System.out.println(DEBUG_TAG + ": " + e.getLocalizedMessage());
        }

    }

    @Async
    public void doAsyncTask(){
        System.out.println("Starting async task.");

        try {
            Thread.sleep(10000);
        } catch (Exception e){
        }

        System.out.println("Ending async task.");

    }

}
