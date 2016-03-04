package org.jenkinsci.plugins.workflow.demo;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

import sun.misc.IOUtils;

import java.net.URL;

/**
 * Integration test for webapp.
 */
public class AppTest {
    @Test
    public void testApp() throws Exception {
        URL app = getSUT();
        String contents = app.openStream().toString();
        assertTrue(contents.contains("Hello Jenkins!"));

        // this is supposed to be an integration test,
        // let's take some time. We want this to be longer than the build for sure.
        Thread.sleep(Integer.getInteger("duration", 30) * 1000);
    }

    private URL getSUT() throws Exception {
        String url = System.getProperty("url");
        assertTrue("Subject under test should be passed in via -Durl=...", url!=null);
        return new URL(url);
    }
}
