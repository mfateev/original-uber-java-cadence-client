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
package com.uber.cadence.internal;

import com.uber.cadence.WorkflowExecution;
import com.uber.cadence.WorkflowType;

@SuppressWarnings("serial")
public class ChildWorkflowTimedOutException extends ChildWorkflowException {
    
    public ChildWorkflowTimedOutException(String message) {
        super(message);
    }

    public ChildWorkflowTimedOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChildWorkflowTimedOutException(long eventId, WorkflowExecution workflowExecution, WorkflowType workflowType) {
        super("Time Out", eventId, workflowExecution, workflowType);
    }

}
