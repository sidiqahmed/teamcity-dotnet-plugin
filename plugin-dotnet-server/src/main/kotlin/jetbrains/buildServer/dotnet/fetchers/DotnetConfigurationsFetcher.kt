/*
 * Copyright 2000-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * See LICENSE in the project root for license information.
 */

package jetbrains.buildServer.dotnet.fetchers

import jetbrains.buildServer.dotnet.DotnetModelParser
import jetbrains.buildServer.dotnet.models.Project
import java.util.TreeSet

/**
 * Provides configurations fetcher for project model.
 */
class DotnetConfigurationsFetcher(modelParser: DotnetModelParser) : DotnetProjectsDataFetcher(modelParser) {

    override fun getDataItems(project: Project?): Collection<String> {
        val configurations = TreeSet(String.CASE_INSENSITIVE_ORDER)
        configurations.add("Release")
        configurations.add("Debug")
        configurations.addAll(project?.configurations?.keys ?: emptySet())

        return configurations
    }

    override fun getType(): String {
        return "DotnetConfigurations"
    }
}
