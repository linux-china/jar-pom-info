package org.mvnsearch.tools;

import junit.framework.TestCase;

import java.io.File;

/**
 * jar pom viewer test
 *
 * @author linux_china
 */
public class JarPomViewerTest extends TestCase {
    /**
     * display information
     *
     * @throws Exception
     */
    public void testDisplayInfo() throws Exception {
        String jarFile = "/Users/linux_china/.m2/repository/joda-time/joda-time/2.1/joda-time-2.1.jar";
        JarPomViewer.parseJarFile(new File(jarFile));

    }
}
