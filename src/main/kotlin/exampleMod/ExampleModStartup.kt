package exampleMod

import core.events.EventListener
import system.startup.GameStartEvent

class ExampleModStartup : EventListener<GameStartEvent>() {
    override suspend fun complete(event: GameStartEvent) {
        println("Example Mod Started")
    }
}