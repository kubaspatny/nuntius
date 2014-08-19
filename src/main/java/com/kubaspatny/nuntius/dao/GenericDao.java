package com.kubaspatny.nuntius.dao;

import com.kubaspatny.nuntius.bo.AbstractBusinessObject;

import java.util.List;

/**
 * Author: Kuba Spatny
 * Web: kubaspatny.cz
 * E-mail: kuba.spatny@gmail.com
 * Date: 8/4/14
 * Time: 10:26 PM
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
public interface GenericDao {

    public <ENTITY> List<ENTITY> getAll(Class<ENTITY> entity_class);

    public <ENTITY> List<ENTITY> getPage(int from, int maxResults, Class<ENTITY> entity_class);

    public <ENTITY extends AbstractBusinessObject> void removeById(long id, Class<ENTITY> entity_class);

    public Long getCount(Class entity_class);

    public <ENTITY extends AbstractBusinessObject> void remove(ENTITY o);

    public <ENTITY extends AbstractBusinessObject> ENTITY saveOrUpdate(ENTITY o);

    public <ENTITY> ENTITY getById(Long id, Class<ENTITY> entity_class);

    public <ENTITY> List<ENTITY> getAllOrderedDesc(String property, Class<ENTITY> entity_class);

    public <ENTITY> List<ENTITY> getAllOrderedAsc(String property, Class<ENTITY> entity_class);

    public <ENTITY> List<ENTITY> getByProperty(String property, Object value, Class<ENTITY> entity_class);

    public <ENTITY> List<ENTITY> searchByProperty(String property, Object value, Class<ENTITY> entity_class);

    public <ENTITY> List<ENTITY> getByPropertyTopN(String property, Object value, int number, String orderProperty, Class<ENTITY> entity_class);

    public <ENTITY> ENTITY getByPropertyUnique(String property, Object value, Class<ENTITY> entity_class);

    public <ENTITY> List<ENTITY> getPage(int first, int rows, String sortBy, boolean ascending, Class<ENTITY> entity_class);

    public <ENTITY> List<ENTITY> getTopN(String property, int number, Class<ENTITY> entity_class);

}
