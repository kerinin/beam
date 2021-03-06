/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.beam.sdk.extensions.sql.impl.interpreter.operator.reinterpret;

import com.google.common.base.Function;

import javax.annotation.Nonnull;

import org.apache.beam.sdk.extensions.sql.impl.interpreter.operator.BeamSqlPrimitive;
import org.apache.calcite.sql.type.SqlTypeName;

/**
 * Utility class to contain implementations of SQL integer type conversions.
 */
public abstract class IntegerReinterpretConversions {

  public static final ReinterpretConversion INTEGER_TYPES_TO_BIGINT =
      ReinterpretConversion.builder()
          .from(SqlTypeName.INT_TYPES)
          .to(SqlTypeName.BIGINT)
          .convert(new Function<BeamSqlPrimitive, BeamSqlPrimitive>() {
            @Override
            public BeamSqlPrimitive apply(@Nonnull BeamSqlPrimitive beamSqlPrimitive) {
              Long value = ((Number) beamSqlPrimitive.getValue()).longValue();
              return BeamSqlPrimitive.of(SqlTypeName.BIGINT, value);
            }
          }).build();
}
