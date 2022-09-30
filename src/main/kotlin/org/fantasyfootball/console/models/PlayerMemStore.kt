package org.fantasyfootball.console.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

class PlayerMemStore : PlayerStore {

    val players = ArrayList<PlayerModel>()

    override fun findAll(): List<PlayerModel> {
        TODO("Not yet implemented")
        return players
    }

    override fun findOne(id: Long): PlayerModel? {
        TODO("Not yet implemented")
//        var foundPlayer: PlayerModel? = players.find { p -> p.id == id }
//        return foundPlayer
    }

    override fun create() {
        val pl1 = PlayerModel("Cristiano Ronaldo","Striker",7)
        val pl2 = PlayerModel("Erling Haaland","Striker",9)
        val pl3 = PlayerModel("Harry Kane","Striker",9)
        val pl4 = PlayerModel("Ivan Toney","Striker",17)
        val pl5 = PlayerModel("Muhammad Salah","Winger",11)
        val pl6 = PlayerModel("Jadon Sancho","Winger",25)
        val pl7 = PlayerModel("Marcus Rashford","Winger",10)
        val pl8 = PlayerModel("Phil Foden","Winger",47)
        val pl9 = PlayerModel("Kevin De Bruyne","Mid",17)
        val pl10 = PlayerModel("Bruno Fernandes","Mid",8)
        val pl11 = PlayerModel("Ngolo Kante","Mid",7)
        val pl12 = PlayerModel("Christian Erikson","Mid",14)
        val pl13 = PlayerModel("Declan Rice","Mid",41)
        val pl14 = PlayerModel("Ruben Dias","Defender",3)
        val pl15 = PlayerModel("Harry Maguire","Defender",5)
        val pl16 = PlayerModel("Raphael Varane","Defender",19)
        val pl17 = PlayerModel("Reece James","Defender",24)
        val pl18 = PlayerModel("Trent Alexander Arnold","Defender",66)
        val pl19 = PlayerModel("Virgil Van Dijk","Defender",4)
        val pl20 = PlayerModel("Ivan Perisic","Defender",14)
        val pl21 = PlayerModel("Joao Cancelo","Defender",7)


        players.add(pl1)
        players.add(pl2)
        players.add(pl3)
        players.add(pl4)
        players.add(pl5)
        players.add(pl6)
        players.add(pl7)
        players.add(pl8)
        players.add(pl9)
        players.add(pl10)
        players.add(pl11)
        players.add(pl12)
        players.add(pl13)
        players.add(pl14)
        players.add(pl15)
        players.add(pl16)
        players.add(pl17)
        players.add(pl18)
        players.add(pl19)
        players.add(pl20)
        players.add(pl21)

    }

    internal fun logAll() {
        players.forEach { logger.info("${it.name}") }
    }

}