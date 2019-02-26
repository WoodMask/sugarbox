package com.mask;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "sayHello",defaultPhase = LifecyclePhase.NONE)
public class SayHelloMojo extends AbstractMojo{
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Hello, I'm MASK");
    }
}
