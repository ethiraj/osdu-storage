// Copyright 2017-2019, Schlumberger
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.opengroup.osdu.storage;

import org.opengroup.osdu.storage.provider.interfaces.ILegalTagSubscriptionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"org.opengroup.osdu"})
public class StorageApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(StorageApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StorageApplication.class, args);
        try {
            ILegalTagSubscriptionManager legalTagSubscriptionManager = context.getBean(ILegalTagSubscriptionManager.class);
            legalTagSubscriptionManager.subscribeLegalTagsChangeEvent();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}