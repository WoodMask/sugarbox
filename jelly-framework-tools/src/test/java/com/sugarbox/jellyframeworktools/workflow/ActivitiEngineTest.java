package com.sugarbox.jellyframeworktools.workflow;
//
//import org.activiti.engine.repository.ProcessDefinition;
//import org.junit.Assert;
import com.sugarbox.jellyframeworktools.workflow.exception.WorkFlowException;
import com.sugarbox.jellyframeworktools.workflow.exception.WorkFlowExceptionEnum;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ActivitiEngineTest {

    private final String SAMPLE_NAME = "sample";

    private final String SAMPLE_RESOURCE_NAME = "sample";

    private final Integer SAMPLE_VERSION = 1;

    @Autowired
    ActivitiEngine activitiEngine;

    @Autowired
    RepositoryService repositoryService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @After
    public void removeAllDeployment() {
        repositoryService.createProcessDefinitionQuery().list()
                .stream()
                .forEach(e -> {
                    repositoryService.deleteDeployment(e.getDeploymentId(), true);
                    System.out.format("deployment had been remove -> " +
                            "key : {%s}, id : {%s}, ver : {%s}",e.getKey(),e.getId()
                            , e.getVersion());
                });
    }

    @Test
    @Rollback
    public void deployDefinitionTest() {

        Deployment definition = activitiEngine.deployDefinition(SAMPLE_RESOURCE_NAME, SAMPLE_NAME , SAMPLE_VERSION);
        System.out.println("the definition name is :" + definition.getName());
        Assert.assertNotNull(definition);
    }

    @Test
    @Rollback
    public void deployDefinitionIsExistExceptionTest() {

        thrown.expect(WorkFlowException.class);

        thrown.expectMessage(WorkFlowExceptionEnum.RE_DEFINITION_EXISTS.getMessage());
        activitiEngine.deployDefinition(SAMPLE_RESOURCE_NAME, SAMPLE_NAME , SAMPLE_VERSION);
        Deployment deploymentSecond = activitiEngine.deployDefinition(SAMPLE_RESOURCE_NAME, SAMPLE_NAME , SAMPLE_VERSION);
        System.out.println("the definition name is :" + deploymentSecond.getName());
    }



    @Test
    public void delDeployment() throws Exception {
        // 获取仓库服务对象
//        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 删除发布信息
        String deploymentId = "12501";
        // 普通删除，如果当前规则下有正在执行的流程，则抛异常
        repositoryService.deleteDeployment(deploymentId);
        // 级联删除,会删除和当前规则相关的所有信息，包括历史
        repositoryService.deleteDeployment(deploymentId, true);
    }



}
