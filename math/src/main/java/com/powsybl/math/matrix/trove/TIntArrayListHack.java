/**
 * Copyright (c) 2017, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.math.matrix.trove;

import gnu.trove.list.array.TIntArrayList;

/**
 * @author Geoffroy Jamgotchian <geoffroy.jamgotchian at rte-france.com>
 */
public class TIntArrayListHack extends TIntArrayList {

    public TIntArrayListHack() {
    }

    public TIntArrayListHack(int capacity) {
        super(capacity);
    }

    public TIntArrayListHack(int[] values) {
        super(values);
    }

    public int[] getData() {
        return _data;
    }
}
