package com.kubaspatny.nuntius.service;

import com.kubaspatny.nuntius.bo.AndroidDevice;
import com.kubaspatny.nuntius.dto.AndroidDeviceDto;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: Kuba Spatny
 * Web: kubaspatny.cz
 * E-mail: kuba.spatny@gmail.com
 * Date: 8/29/14
 * Time: 9:41 PM
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

@Component("androidDeviceService")
public class AndroidDeviceService extends AbstractDataAccessService implements IAndroidDeviceService {


    @Override
    public List<AndroidDeviceDto> getAll() {
        return AndroidDeviceDto.convert(genericDao.getAll(AndroidDevice.class));
    }

    @Override
    public AndroidDeviceDto getById(Long Id) {
        return AndroidDeviceDto.convert(genericDao.getById(Id, AndroidDevice.class));
    }

    @Override
    public Long registerDevice(String registrationID, String username) {
        AndroidDevice newDevice = new AndroidDevice(registrationID, username);
        return genericDao.saveOrUpdate(newDevice).getId();
    }

    @Override
    public void update(AndroidDeviceDto deviceDto) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void unregisterDevice(Long Id) {
        genericDao.removeById(Id, AndroidDevice.class);
    }
}
