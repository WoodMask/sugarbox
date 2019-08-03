package com.sugarbox.jellyframeworktools.workflow.impl;

import com.sugarbox.jellyframeworktools.workflow.ActivitiEngine;
import com.sugarbox.jellyframeworktools.workflow.exception.WorkFlowException;
import com.sugarbox.jellyframeworktools.workflow.exception.WorkFlowExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.Resource;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.bpmn.deployer.BpmnDeployer;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ValidationUtils;

import java.util.Collections;
import java.util.Optional;

@Slf4j
@Service("ActivitiEngine")
public class ActivitiEngineImpl implements ActivitiEngine{

    private final String DEFAULT_PATH_PREFIX = "processes/";

    private final String DEFAULT_SOURCE_SUFFIXES = ".bpmn";

    @Autowired
    RepositoryService repositoryService;

    @Override
    public Deployment deployDefinition(String resourceName, String processId, Integer version) throws WorkFlowException{

        if (Strings.isBlank(processId) || !Optional.ofNullable(version).isPresent()) {
            throw new WorkFlowException(WorkFlowExceptionEnum.PARAMETER_NOT_NULL);
        }

        if (!repositoryService
                        .createProcessDefinitionQuery()
                        .processDefinitionKey(processId)
                        .processDefinitionVersion(version)
                        .list().isEmpty()) {
            throw new WorkFlowException(WorkFlowExceptionEnum.RE_DEFINITION_EXISTS);
        }


        Deployment definition = null;
        try {

            definition = repositoryService
                    .createDeployment()
                    .addClasspathResource(DEFAULT_PATH_PREFIX + resourceName + DEFAULT_SOURCE_SUFFIXES)
                    .deploy();
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new WorkFlowException(WorkFlowExceptionEnum.RE_DEFINITION_CREATED_FAIL);
        }

        log.info(repositoryService
                .createProcessDefinitionQuery()
                .processDefinitionName(processId)
                .processDefinitionVersion(version)
                .list().toString());
        return definition;
    }

    @Override
    public Boolean removeDefinition() {
        return null;
    }

    @Override
    public ProcessInstance fire() {
        return null;
    }

    @Override
    public Task queryTask() {
        return null;
    }

    @Override
    public Task nextStep() {
        return null;
    }
}
