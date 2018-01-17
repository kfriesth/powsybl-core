/**
 * Copyright (c) 2017, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.security.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.powsybl.commons.extensions.Extension;
import com.powsybl.commons.extensions.ExtensionSupplier;
import com.powsybl.commons.json.JsonUtil;
import com.powsybl.iidm.network.Branch;
import com.powsybl.security.LimitViolation;
import com.powsybl.security.LimitViolationType;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author Mathieu Bague <mathieu.bague at rte-france.com>
 */
class LimitViolationDeserializer extends StdDeserializer<LimitViolation> {

    LimitViolationDeserializer() {
        super(LimitViolation.class);
    }

    @Override
    public LimitViolation deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {
        String subjectId = null;
        LimitViolationType limitType = null;
        String limitName = null;
        int acceptableDuration = Integer.MAX_VALUE;
        float limit = Float.NaN;
        float limitReduction = Float.NaN;
        float value = Float.NaN;
        Branch.Side side = null;

        List<Extension<LimitViolation>> extensions = Collections.emptyList();

        while (parser.nextToken() != JsonToken.END_OBJECT) {
            switch (parser.getCurrentName()) {
                case "subjectId":
                    subjectId = parser.nextTextValue();
                    break;

                case "limitType":
                    parser.nextToken();
                    limitType = parser.readValueAs(LimitViolationType.class);
                    break;

                case "limitName":
                    limitName = parser.nextTextValue();
                    break;

                case "acceptableDuration":
                    parser.nextToken();
                    acceptableDuration = parser.readValueAs(Integer.class);
                    break;

                case "limit":
                    parser.nextToken();
                    limit = parser.readValueAs(Float.class);
                    break;

                case "limitReduction":
                    parser.nextToken();
                    limitReduction = parser.readValueAs(Float.class);
                    break;

                case "value":
                    parser.nextToken();
                    value = parser.readValueAs(Float.class);
                    break;

                case "side":
                    parser.nextToken();
                    side = parser.readValueAs(Branch.Side.class);
                    break;

                case "extensions":
                    parser.nextToken();
                    extensions = JsonUtil.readExtensions(parser, deserializationContext);
                    break;

                default:
                    throw new AssertionError("Unexpected field: " + parser.getCurrentName());
            }
        }

        LimitViolation violation = new LimitViolation(subjectId, limitType, limitName, acceptableDuration, limit, limitReduction, value, side);
        ExtensionSupplier.addExtensions(violation, extensions);

        return violation;
    }
}
