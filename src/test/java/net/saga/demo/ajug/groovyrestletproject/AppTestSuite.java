package net.saga.demo.ajug.groovyrestletproject;

import com.google.inject.Guice;
import com.google.inject.Injector;
import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import java.io.IOException;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Unit test for simple BuggieApplication.
 *
 * @author summers
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BuildTest.class})
public class AppTestSuite {

    public static final Injector INJECTOR;
    private final static Logger TEST_LOGGER = Logger.getLogger("GroovyLoadingTestSuite");
    private final static String[] roots = new String[]{"src/test/groovy/net/saga/demo/ajug/groobyrestleproject/setup"};
    private final static GroovyScriptEngine gse;

    static {
        System.setProperty("database_address", "127.0.0.1");
        System.setProperty("database_name", "Moo");
        INJECTOR = Guice.createInjector(new TestModule());
        try {
            gse = new GroovyScriptEngine(roots);
        } catch (IOException ex) {
            throw new RuntimeException("failed to start tests", ex);
        }
    }

    @BeforeClass
    public static void setUpSuite() throws Exception {
        TEST_LOGGER.finest("Before class");

        Binding binding = new Binding();

        gse.run("TestSetup.groovy", binding);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        TEST_LOGGER.finest("After class");
        Binding binding = new Binding();
        gse.run("TestTeardown.groovy", binding);
    }

    @Before
    public void setUp() throws Exception {
        TEST_LOGGER.finest("Before ");
    }

    @After
    public void tearDown() throws Exception {
        TEST_LOGGER.finest("After");


    }
}