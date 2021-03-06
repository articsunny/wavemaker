/*
 *  Copyright (C) 2008-2012 VMware, Inc. All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.wavemaker.tools.apt;

import java.util.HashMap;
import java.util.Map;
import javax.lang.model.type.DeclaredType;

import com.wavemaker.json.type.TypeDefinition;
import com.wavemaker.json.type.TypeState;

public class CompileTypeState implements TypeState {

    private final Map<String, TypeDefinition> knownTypes = new HashMap<String, TypeDefinition>();
    private String baseClassName;

    @Override
    public void addType(TypeDefinition typeDefinition) {
        this.knownTypes.put(typeDefinition.getTypeName(), typeDefinition);
    }

    @Override
    public TypeDefinition getType(String typeName) {

        if (this.knownTypes.containsKey(typeName)) {
            return this.knownTypes.get(typeName);
        } else {
            return null;
        }
    }

    @Override
    public boolean isTypeKnown(String typeName) {

        return this.knownTypes.containsKey(typeName);
    }

    @Override
    public String getBaseClassName() {
        return this.baseClassName;
    }

    @Override
    public void setBaseClassName(String baseClassName) {
        this.baseClassName = baseClassName;
    }
}
