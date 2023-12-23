package com.globant.utils.dataProviders;

import org.testng.annotations.DataProvider;
import com.globant.utils.CredentialsGenerator;

public class CredentialsProvider {
    @DataProvider(name = "credentialsData")
    public Object[][] provideTestData() {
        Object[][] testData = new Object[1][2];

        String email = CredentialsGenerator.generateEmail();
        String password = CredentialsGenerator.generatePassword();
        testData[0] = new String[]{email, password};

        return testData;
    }
}