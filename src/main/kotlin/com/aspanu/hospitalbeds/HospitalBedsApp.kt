package com.aspanu.hospitalbeds

import com.aspanu.hospitalbeds.resources.BedRequests
import io.dropwizard.Application
import io.dropwizard.setup.Environment

/**
 * Created by aspanu on 2017-11-19.
 */
class HospitalBedsApp : Application<HospitalBedsConfiguration>() {

    override fun run(configuration: HospitalBedsConfiguration, environment: Environment) {
        println("Running ${configuration.name}!")
        val bedRequests = BedRequests()
        environment.jersey().register(bedRequests)
    }
}