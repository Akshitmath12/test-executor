package com.bootproject5.testexecutor.controller;

import java.io.IOException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootproject5.testexecutor.model.SourceCode;

@RestController
@RequestMapping("/api")
public class Controller {
    @PostMapping()
    public void setEnvVars(@RequestBody SourceCode source) throws IOException, InterruptedException {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "setx GITHUB_REPO_URL "+ source.getGithubURL());
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
           if (exitCode == 0) {
                  System.out.println("Environment variable \"GITHUB_REPO_URL\" set successfully.");
          } else {
            throw new InterruptedException("Error setting environment variable -\"GITHUB_REPO_URL\"");
          }
        } catch (Exception exception) {
            System.out.println(" ------------>"+exception);
        }
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "setx BRANCH_NAME "+ source.getGithubURL());
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
           if (exitCode == 0) {
                  System.out.println("Environment variable set \"BRANCH_NAME\" successfully.");
          } else{
            throw new InterruptedException("Error setting environment variable \"BRANCH_NAME\"");
          }
        } catch (Exception exception) {
            System.out.println(" ------------->"+exception);
        }
        try {
        String command = "docker build -t runTests:v1 .";
        Runtime.getRuntime().exec(command);
        } catch (Exception exception) {
            System.out.println("Error building docker image ------------->"+exception);
        }
    }
    @PostMapping("/{GithubURL}")
    public void setGithubURL(@PathVariable String GithubURL)
    { 
        try{
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "setx GITHUB_REPO_URL "+GithubURL);
       Process process = processBuilder.start();
       int exitCode = process.waitFor();
      if (exitCode == 0) {
             System.out.println("Environment variable set successfully.");
     } else {
         System.out.println("Error setting environment variable.");
     }

    }catch(
        Exception exception
    ){ System.out.println("+++++++++++++++++++++"+exception);}
       // System.out.println(GithubURL);
    }
    // // @PostMapping("/{branchName}")
    // // public void setBranchName(@PathVariable String BranchName) throws IOException{
    // //     System.setProperty("BRANCH_NAME", BranchName);
    // //     System.out.println(System.getenv("BRANCH_NAME"));
    // //      String command = "docker build -t runTests:v1 .";
    // //      Runtime.getRuntime().exec(command);
    // // }
}
