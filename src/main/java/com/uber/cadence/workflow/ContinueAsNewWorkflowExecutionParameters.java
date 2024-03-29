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
package com.uber.cadence.workflow;

import com.uber.cadence.ChildPolicy;
import com.uber.cadence.internal.StartWorkflowOptions;

public final class ContinueAsNewWorkflowExecutionParameters {

    private int executionStartToCloseTimeoutSeconds;
    private byte[] input;
    private String taskList;
    private int taskStartToCloseTimeoutSeconds;
    private ChildPolicy childPolicy;

    public ContinueAsNewWorkflowExecutionParameters() {
    }
    
    public int getExecutionStartToCloseTimeoutSeconds() {
        return executionStartToCloseTimeoutSeconds;
    }
    
    public void setExecutionStartToCloseTimeoutSeconds(int executionStartToCloseTimeoutSeconds) {
        this.executionStartToCloseTimeoutSeconds = executionStartToCloseTimeoutSeconds;
    }
    
    public ContinueAsNewWorkflowExecutionParameters withExecutionStartToCloseTimeoutSeconds(int executionStartToCloseTimeoutSeconds) {
        this.executionStartToCloseTimeoutSeconds = executionStartToCloseTimeoutSeconds;
        return this;
    }

    public ContinueAsNewWorkflowExecutionParameters withInput(byte[] input) {
        this.input = input;
        return this;
    }

    public byte[] getInput() {
        return input;
    }

    public void setInput(byte[] input) {
        this.input = input;
    }

    public String getTaskList() {
        return taskList;
    }
    
    public void setTaskList(String taskList) {
        this.taskList = taskList;
    }
    
    public ContinueAsNewWorkflowExecutionParameters withTaskList(String taskList) {
        this.taskList = taskList;
        return this;
    }

    public int getTaskStartToCloseTimeoutSeconds() {
        return taskStartToCloseTimeoutSeconds;
    }
    
    public void setTaskStartToCloseTimeoutSeconds(int taskStartToCloseTimeoutSeconds) {
        this.taskStartToCloseTimeoutSeconds = taskStartToCloseTimeoutSeconds;
    }

    public ChildPolicy getChildPolicy() {
        return childPolicy;
    }

    public void setChildPolicy(ChildPolicy childPolicy) {
        this.childPolicy = childPolicy;
    }

    public ContinueAsNewWorkflowExecutionParameters withChildPolicy(ChildPolicy childPolicy) {
        this.childPolicy = childPolicy;
        return this;
    }

    public ContinueAsNewWorkflowExecutionParameters withTaskStartToCloseTimeoutSeconds(int taskStartToCloseTimeoutSeconds) {
        this.taskStartToCloseTimeoutSeconds = taskStartToCloseTimeoutSeconds;
        return this;
    }

    public ContinueAsNewWorkflowExecutionParameters createContinueAsNewParametersFromOptions(StartWorkflowOptions options,
            StartWorkflowOptions optionsOverride) {
        ContinueAsNewWorkflowExecutionParameters continueAsNewWorkflowExecutionParameters = this.clone();
        
        if (options != null) {
            Integer executionStartToCloseTimeoutSeconds = options.getExecutionStartToCloseTimeoutSeconds();
            if (executionStartToCloseTimeoutSeconds != null) {
                continueAsNewWorkflowExecutionParameters.setExecutionStartToCloseTimeoutSeconds(executionStartToCloseTimeoutSeconds);
            }
            
            Integer taskStartToCloseTimeoutSeconds = options.getTaskStartToCloseTimeoutSeconds();
            if (taskStartToCloseTimeoutSeconds != null) {
                continueAsNewWorkflowExecutionParameters.setTaskStartToCloseTimeoutSeconds(taskStartToCloseTimeoutSeconds);
            }

            String taskList = options.getTaskList();
            if (taskList != null && !taskList.isEmpty()) { 
                continueAsNewWorkflowExecutionParameters.setTaskList(taskList);
            }

            ChildPolicy childPolicy = options.getChildPolicy();
            if (childPolicy != null) {
                continueAsNewWorkflowExecutionParameters.setChildPolicy(childPolicy);
            }
        }
        
        if (optionsOverride != null) {    
            Integer executionStartToCloseTimeoutSeconds = optionsOverride.getExecutionStartToCloseTimeoutSeconds();
            if (executionStartToCloseTimeoutSeconds != null) {
                continueAsNewWorkflowExecutionParameters.setExecutionStartToCloseTimeoutSeconds(executionStartToCloseTimeoutSeconds);
            }
            
            Integer taskStartToCloseTimeoutSeconds = optionsOverride.getTaskStartToCloseTimeoutSeconds();
            if (taskStartToCloseTimeoutSeconds != null) {
                continueAsNewWorkflowExecutionParameters.setTaskStartToCloseTimeoutSeconds(taskStartToCloseTimeoutSeconds);
            }

            String taskList = optionsOverride.getTaskList();
            if (taskList != null && !taskList.isEmpty()) { 
                continueAsNewWorkflowExecutionParameters.setTaskList(taskList);
            }

            ChildPolicy childPolicy = optionsOverride.getChildPolicy();
            if (childPolicy != null) {
                continueAsNewWorkflowExecutionParameters.setChildPolicy(childPolicy);
            }

        }
        
        return continueAsNewWorkflowExecutionParameters;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("Input: " + input + ", ");
        sb.append("ExecutionStartToCloseTimeout: " + executionStartToCloseTimeoutSeconds + ", ");
        sb.append("TaskStartToCloseTimeout: " + taskStartToCloseTimeoutSeconds + ", ");
        sb.append("TaskList: " + taskList + ", ");
        sb.append("}");
        return sb.toString();
    }
    
    public ContinueAsNewWorkflowExecutionParameters clone() {
        ContinueAsNewWorkflowExecutionParameters result = new ContinueAsNewWorkflowExecutionParameters();
        result.setExecutionStartToCloseTimeoutSeconds(executionStartToCloseTimeoutSeconds);
        result.setInput(input);
        result.setTaskList(taskList);
        result.setTaskStartToCloseTimeoutSeconds(taskStartToCloseTimeoutSeconds);
        return result;
    }
}
