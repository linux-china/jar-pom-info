package org.mvnsearch.tools;

/**
 * organization
 *
 * @author linux_china
 */
public class Organization {
    /**
     * name
     */
    private String name;
    /**
     * url
     */
    private String url;

    public Organization() {

    }

    /**
     * construction method
     *
     * @param name org name
     * @param url  org url
     */
    public Organization(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
