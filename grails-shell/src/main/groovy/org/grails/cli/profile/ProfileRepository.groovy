package org.grails.cli.profile

import org.grails.io.support.Resource

/*
 * Copyright 2014 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 *
 * A repository of {@link Profile} instances
 *
 * @author Graeme Rocher
 * @since 3.0
 */
interface ProfileRepository {

    String DEFAULT_PROFILE_NAME = 'web'

    /**
     * Obtains a named {@link Profile}
     * @param profileName The name of the profile
     * @return The {@link Profile} or null
     */
    Profile getProfile(String profileName)

    /**
     * The directory where the profile is located
     *
     * @param profile The name of the profile
     * @return The directory where the profile is located or null if it doesn't exist
     */
    Resource getProfileDirectory(String profile)

    /**
     * Returns the given profile with all dependencies in topological order where
     * given profile is last in the order.
     *
     * @param profile The {@link Profile} instance
     * @return The {@link Profile} and its dependencies
     */
    List<Profile> getProfileAndDependencies(Profile profile)

    /**
     * @return All the available profiles in the repository
     */
    List<Profile> getAllProfiles()
}