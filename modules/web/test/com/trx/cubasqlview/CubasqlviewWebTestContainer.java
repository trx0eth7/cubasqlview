package com.trx.cubasqlview;

import com.haulmont.cuba.web.testsupport.TestContainer;

import java.util.Arrays;

public class CubasqlviewWebTestContainer extends TestContainer {

    public CubasqlviewWebTestContainer() {
        appComponents = Arrays.asList(
                "com.haulmont.cuba",
                "com.haulmont.addon.sdbmt");
        appPropertiesFiles = Arrays.asList(
                // List the files defined in your web.xml
                // in appPropertiesConfig context parameter of the web module
                "com/trx/cubasqlview/web-app.properties",
                // Add this file which is located in CUBA and defines some properties
                // specifically for test environment. You can replace it with your own
                // or add another one in the end.
                "com/haulmont/cuba/web/testsupport/test-web-app.properties"
        );
    }

    public static class Common extends CubasqlviewWebTestContainer {

        // A common singleton instance of the test container which is initialized once for all tests
        public static final CubasqlviewWebTestContainer.Common INSTANCE = new CubasqlviewWebTestContainer.Common();

        private static volatile boolean initialized;

        private Common() {
        }

        @Override
        public void before() throws Throwable {
            if (!initialized) {
                super.before();
                initialized = true;
            }
            setupContext();
        }

        @Override
        public void after() {
            cleanupContext();
            // never stops - do not call super
        }
    }
}