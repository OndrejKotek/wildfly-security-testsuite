/*
 * Copyright The WildFly Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.wildfly.security.tests.common.authauthz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Provides basic definitions and tooling for identities used by tests.
 */
public class TestIdentities {

    public static final String USERNAME_PATTERN = "user%d";
    public static final String PASSWORD_PATTERN = "password%d";

    public static Stream<IdentityDefinition> obtainTestIdentities() {
        // Register a lot of identities so each test can use it's own without
        // state being contaminated from other tests.
        List<IdentityDefinition> identities = new ArrayList<>(250);
        for (int i = 1 ; i < 250 ; i++) {
            identities.add(new IdentityDefinition(String.format(USERNAME_PATTERN , i),
                    String.format(PASSWORD_PATTERN, i)));
        }

        return identities.stream();
    }

    public record IdentityDefinition(String username, String password) {}
}
