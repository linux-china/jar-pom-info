package org.mvnsearch.tools;

/**
 * developer object
 *
 * @author linux_china
 */
public class Developer {
    /**
     * id
     */
    private String id;
    /**
     * name
     */
    private String name;
    /**
     * email
     */
    private String email;
    /**
     * url
     */
    private String url;
    /**
     * roles
     */
    private String roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void addRole(String role) {
        if (roles == null) {
            roles = role;
        } else {
            roles = roles + "," + role;
        }
    }
}
