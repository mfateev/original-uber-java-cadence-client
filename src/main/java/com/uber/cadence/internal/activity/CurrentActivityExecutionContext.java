/*
 *  Copyright 2012-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 *  Modifications copyright (C) 2017 Uber Technologies, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"). You may not
 *  use this file except in compliance with the License. A copy of the License is
 *  located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 *  or in the "license" file accompanying this file. This file is distributed on
 *  an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 *  express or implied. See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package com.uber.cadence.internal.activity;

/**
 * Thread local store of the context object passed to an activity
 * implementation. Avoid using this class directly.
 *
 * @author fateev
 */
public class CurrentActivityExecutionContext {

    private final static ThreadLocal<ActivityExecutionContext> CURRENT = new ThreadLocal<ActivityExecutionContext>();

    /**
     * This is used by activity implementation to get access to the current
     * ActivityExecutionContext
     */
    public static ActivityExecutionContext get() {
        ActivityExecutionContext result = CURRENT.get();
        if (result == null) {
            throw new IllegalStateException("ActivityExecutionContext can be used only inside of acitivty implementation methods");
        }
        return result;
    };

    public static boolean isSet() {
        return CURRENT.get() != null;
    }

    public static void set(ActivityExecutionContext context) {
        if (context == null) {
            throw new IllegalArgumentException("null context");
        }
        if (CURRENT.get() !=  null) {
            throw new IllegalStateException("current already set");
        }
        CURRENT.set(context);
    }

    public static void unset() {
        CURRENT.set(null);
    }

    private CurrentActivityExecutionContext() {

    }
}
