/*
 * Copyright 2014 Click Travel Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.clicktravel.cheddar.infrastructure.persistence.document.search.query;

import org.joda.time.DateTime;

public class TermQuery extends StructuredQuery {

    private final String fieldName;
    private final Object value; // can be String, Integer, Double or Date

    private TermQuery(final String fieldName, final Object value) {
        this.fieldName = fieldName;
        this.value = value;
    }

    public TermQuery(final String fieldName, final String value) {
        this(fieldName, (Object) value);
    }

    public TermQuery(final String fieldName, final Integer value) {
        this(fieldName, (Object) value);
    }

    public TermQuery(final String fieldName, final Double value) {
        this(fieldName, (Object) value);
    }

    public TermQuery(final String fieldName, final DateTime value) {
        this(fieldName, (Object) value);
    }

    /**
     * Describes the field referenced by the query
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * The value to compare for equality to
     */
    public Object getValue() {
        return value;
    }

    @Override
    public void accept(final QueryVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TermQuery other = (TermQuery) obj;
        if (fieldName == null) {
            if (other.fieldName != null) {
                return false;
            }
        } else if (!fieldName.equals(other.fieldName)) {
            return false;
        }
        if (value == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!value.equals(other.value)) {
            return false;
        }
        return true;
    }

}
