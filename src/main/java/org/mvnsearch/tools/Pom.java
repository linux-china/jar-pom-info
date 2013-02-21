package org.mvnsearch.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * pom object
 *
 * @author linux_china
 */
public class Pom {
    /**
     * group id
     */
    private String groupId;
    /**
     * artfiact id
     */
    private String artifactId;
    /**
     * version
     */
    private String version;
    /**
     * name
     */
    private String name;
    /**
     * description
     */
    private String description;
    /**
     * url
     */
    private String url;
    /**
     * organization
     */
    private Organization organization;
    /**
     * VCS Verndor
     */
    private String vcsVendor;
    /**
     * vcs url
     */
    private String vcsUrl;
    /**
     * developers
     */
    private List<Developer> developers;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVcsVendor() {
        return vcsVendor;
    }

    public void setVcsVendor(String vcsVendor) {
        this.vcsVendor = vcsVendor;
    }

    public String getVcsUrl() {
        return vcsUrl;
    }

    public void setVcsUrl(String vcsUrl) {
        this.vcsUrl = vcsUrl;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    @SuppressWarnings("ConstantConditions")
    public void addDeveloper(Developer developer) {
        if (this.developers != null) {
            developers = new ArrayList<Developer>();
        }
        developers.add(developer);
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
