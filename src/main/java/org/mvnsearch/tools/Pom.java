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

    public void addDeveloper(Developer developer) {
        if (this.developers == null) {
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

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("============GAV==========================").append(System.lineSeparator());
        buffer.append("groupId: ").append(groupId).append(System.lineSeparator());
        buffer.append("artifactId: ").append(artifactId).append(System.lineSeparator());
        buffer.append("version: ").append(version).append(System.lineSeparator());
        if (name != null && !name.isEmpty()) {
            buffer.append("============Basic========================").append(System.lineSeparator());
            buffer.append("name: ").append(name).append(System.lineSeparator());
            if (isNotEmpty(description)) {
                buffer.append("description: ").append(description).append(System.lineSeparator());
            }
            if (isNotEmpty(url)) {
                buffer.append("url: ").append(url).append(System.lineSeparator());
            }
        }
        if (organization != null) {
            buffer.append("============Organization=================").append(System.lineSeparator());
            buffer.append("name: ").append(organization.getName()).append(System.lineSeparator());
            buffer.append("url: ").append(url).append(System.lineSeparator());
        }
        if (developers != null && !developers.isEmpty()) {
            buffer.append("============Developers==================").append(System.lineSeparator());
            for (Developer developer : developers) {
                if (isNotEmpty(developer.getId())) {
                    buffer.append(developer.getId()).append(": ");
                }
                buffer.append(developer.getName());
                if (isNotEmpty(developer.getEmail())) {
                    buffer.append(" <").append(developer.getEmail()).append("> ");
                }
                if (isNotEmpty(developer.getRoles())) {
                    buffer.append(" ").append(developer.getRoles());
                }
                buffer.append(System.lineSeparator());
            }
        }
        if (vcsVendor != null) {
            buffer.append("============VCS===========================").append(System.lineSeparator());
            buffer.append("vendor: ").append(vcsVendor).append(System.lineSeparator());
            buffer.append("url: ").append(vcsUrl).append(System.lineSeparator());
        }
        return buffer.toString();
    }

    /**
     * validate text empty
     *
     * @param text text
     * @return empty mark
     */
    public static boolean isNotEmpty(String text) {
        return text != null && !text.isEmpty();
    }
}
