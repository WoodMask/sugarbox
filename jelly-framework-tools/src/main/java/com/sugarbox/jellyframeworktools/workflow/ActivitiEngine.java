package com.sugarbox.jellyframeworktools.workflow;

import com.sugarbox.jellyframeworktools.workflow.exception.WorkFlowException;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public interface ActivitiEngine{

    Deployment deployDefinition(String resourceName, String processId, Integer version) throws WorkFlowException;

    Boolean removeDefinition();

    ProcessInstance fire();

    Task queryTask();

    Task nextStep();
}
