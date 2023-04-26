package com.bootproject5.testexecutor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SourceCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String GithubURL;

    private String BranchName;

    public Long getId() {
        return id;
    }

    public String getGithubURL() {
        return GithubURL;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGithubURL(String githubURL) {
        GithubURL = githubURL;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public String getBranchName() {
        return BranchName;
    }

}
