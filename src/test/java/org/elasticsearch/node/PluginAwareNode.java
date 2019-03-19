/*
 * Copyright 2015-2017 floragunn GmbH
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package org.elasticsearch.node;

import java.util.Arrays;

import org.elasticsearch.common.logging.LogConfigurator;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.plugins.Plugin;

public class PluginAwareNode extends Node {

    @SafeVarargs
    public PluginAwareNode(final Settings preparedSettings, final Class<? extends Plugin>... plugins) {
        super(InternalSettingsPreparer.prepareEnvironment(preparedSettings, null), Arrays.asList(plugins), true);
    }

    @Override
    protected void registerDerivedNodeNameWithLogger(String nodeName) {
        System.out.println("nn "+nodeName);
        LogConfigurator.setNodeName(nodeName);
    }
}
