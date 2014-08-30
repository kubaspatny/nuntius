package com.kubaspatny.nuntius.dto;

import com.kubaspatny.nuntius.bo.AndroidDevice;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Kuba Spatny
 * Web: kubaspatny.cz
 * E-mail: kuba.spatny@gmail.com
 * Date: 8/29/14
 * Time: 9:29 PM
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
public class AndroidDeviceDto extends AbstractDto {

    private String mRegistrationId;
    private String mUsername;

    public AndroidDeviceDto(Long id, String mRegistrationId, String mUsername) {
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

    public static AndroidDeviceDto convert(AndroidDevice device){
        if(device == null) return null;
        return new AndroidDeviceDto(device.getId(), device.getmRegistrationId(), device.getmUsername());
    }

    public static List<AndroidDeviceDto> convert(List<AndroidDevice> devices){

        List<AndroidDeviceDto> deviceDtos = new ArrayList<AndroidDeviceDto>();
        if(devices == null) return deviceDtos;
        for(AndroidDevice d : devices){
            deviceDtos.add(convert(d));
        }
        return deviceDtos;

    }

    public static AndroidDevice convert(AndroidDeviceDto deviceDto){
        if(deviceDto == null) return null;

        return new AndroidDevice(deviceDto.getId(), deviceDto.getmRegistrationId(), deviceDto.getmUsername());
    }

    public static List<String> getRegistrationIds(List<AndroidDeviceDto> devices){

        List<String> result = new ArrayList<String>();
        if(devices == null) return null;

        for(AndroidDeviceDto d : devices){
            result.add(d.getmRegistrationId());
        }

        return result;

    }



}
