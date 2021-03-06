/**
 * Copyright (c) 2017, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.action.util

import com.google.auto.service.AutoService
import com.powsybl.action.dsl.spi.DslTaskExtension
import com.powsybl.contingency.tasks.ModificationTask

/**
 * @author Mathieu Bague <mathieu.bague at rte-france.com>
 */
@AutoService(DslTaskExtension.class)
class CloseSwitchTaskExtension implements DslTaskExtension {
    @Override
    void addToSpec(MetaClass tasksSpecMetaClass, List<ModificationTask> tasks, Binding binding) {
        tasksSpecMetaClass.closeSwitch = { String id ->
            tasks.add(new CloseSwitchTask(id))
        }
    }
}
