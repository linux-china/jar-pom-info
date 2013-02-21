package org.mvnsearch.tools;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * jar pom viewer
 *
 * @author linux_china
 */
public class JarPomViewer {

    /**
     * jar pom viewer entrance
     *
     * @param args args
     */
    public static void main(String[] args) {
        // jar file suppiled?
        if (args.length == 0) {
            System.out.println("Please supply a jar file. pom.sh xxxx.jar");
            return;
        }
        File jarFile = new File(args[0]);
        //jar file exits?
        if (!jarFile.exists()) {
            System.out.println("Jar file not exits: " + args[0]);
        }
        //display pom info
        try {
            parseJarFile(jarFile);
        } catch (Exception e) {
            System.out.println("Error to parse pom.xml file");
        }
    }

    /**
     * parse jar file
     *
     * @param jarFile jar file
     */
    public static void parseJarFile(File jarFile) throws Exception {
        JarFile temp = new JarFile(jarFile);
        boolean pomFound = false;
        Enumeration<JarEntry> entries = temp.entries();
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = entries.nextElement();
            String name = jarEntry.getName();
            if (name.endsWith("/pom.xml")) {
                pomFound = true;
                InputStream is = temp.getInputStream(jarEntry);
                parsePomXml(is);
                break;
            }
        }
        if (!pomFound) {
            System.out.println("No pom.xml found in jar file!");
        }
    }

    /**
     * parse pom.xml
     *
     * @param is pom.xml input stream
     * @throws Exception exception
     */
    public static void parsePomXml(InputStream is) throws Exception {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document doc = saxBuilder.build(is);
        Element project = doc.getRootElement();
        Namespace namespace = project.getNamespace();
        Pom pom = new Pom();
        Element parent = project.getChild("parent", namespace);
        //group artifact and version
        pom.setGroupId(project.getChildTextTrim("groupId", namespace));
        pom.setArtifactId(project.getChildTextTrim("artifactId", namespace));
        pom.setVersion(project.getChildTextTrim("version", namespace));
        if (pom.getGroupId() == null && parent != null) {
            pom.setGroupId(parent.getChildTextTrim("groupId", namespace));
        }
        if (pom.getArtifactId() == null && parent != null) {
            pom.setArtifactId(parent.getChildTextTrim("artifactId", namespace));
        }
        if (pom.getVersion() == null && parent != null) {
            pom.setVersion(parent.getChildTextTrim("version", namespace));
        }
        //name, string and url
        pom.setName(project.getChildTextTrim("name", namespace));
        pom.setDescription(project.getChildTextTrim("description", namespace));
        pom.setUrl(project.getChildTextTrim("url", namespace));
        //organization
        Element organization = project.getChild("organization", namespace);
        if (organization != null) {
            String name = organization.getChildTextTrim("name", namespace);
            if (name != null && !name.isEmpty()) {
                pom.setOrganization(new Organization(name, organization.getChildTextTrim("url", namespace)));
            }
        }
        //scm
        Element scm = project.getChild("scm", namespace);
        if (scm != null) {
            String connectionUrl = scm.getChildTextTrim("connection", namespace);
            if (connectionUrl.startsWith("scm:")) {
                connectionUrl = connectionUrl.replace("scm:", "");
                String[] parts = connectionUrl.split(":", 2);
                if (parts.length > 1) {
                    pom.setVcsVendor(parts[0]);
                    pom.setVcsUrl(parts[1]);
                }
            }
        }
        //developer
        Element developers = project.getChild("developers", namespace);
        if (developers != null) {
            List<Element> developerElements = developers.getChildren("developer", namespace);
            for (Element developerElement : developerElements) {
                Developer developer = new Developer();
                developer.setId(developerElement.getChildTextTrim("id", namespace));
                developer.setName(developerElement.getChildTextTrim("name", namespace));
                developer.setEmail(developerElement.getChildTextTrim("email", namespace));
                Element roles = developerElement.getChild("roles", namespace);
                if (roles != null) {
                    List<Element> roleElements = roles.getChildren("role", namespace);
                    for (Element roleElement : roleElements) {
                        developer.addRole(roleElement.getTextTrim());
                    }
                }
                pom.addDeveloper(developer);
            }
        }
        System.out.println(pom.toString());
    }

}
