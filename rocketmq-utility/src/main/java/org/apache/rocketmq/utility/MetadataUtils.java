/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.utility;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MetadataUtils {
    private static final String METADATA_CONF_PATH = "metadata.properties";
    private static final Properties PROPERTIES = new Properties();

    private static final String VERSION_KEY = "rocketmq.version";
    private static final String WRAPPER_VERSION_KEY = "rocketmq.wrapper.version";

    private MetadataUtils() {
    }

    static {
        InputStream stream = MetadataUtils.class.getClassLoader().getResourceAsStream(METADATA_CONF_PATH);
        try {
            PROPERTIES.load(stream);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != stream) {
                    stream.close();
                }
            } catch (IOException ignore) {
                // ignore on purpose.
            }
        }
    }

    public static String getVersion() {
        return PROPERTIES.getProperty(VERSION_KEY);
    }

    public static String getWrapperVersion() {
        return PROPERTIES.getProperty(WRAPPER_VERSION_KEY);
    }
}
