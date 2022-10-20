package org.fantasyfootball.console.main

import mu.KotlinLogging
import org.fantasyfootball.console.models.TeamModel
import org.fantasyfootball.console.controllers.Controller

val controller = Controller()

private val logger = KotlinLogging.logger {}

val teams = ArrayList<TeamModel>()

fun main(args: Array<String>) {
    logger.info { "Launching Fantasy Football App" }
    println(" Fanstasy Football app ")
    controller.start()

}