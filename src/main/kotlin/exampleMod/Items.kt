package exampleMod

import core.thing.item.ItemResource
import core.thing.things

class Items : ItemResource {
    override suspend fun values() = things {
        thing("Modded Tinder Box") {
            println("Adding Modded Tinder Box")
            material("Cloth")
            description("This item is added from a mod.")
            props {
                value("weight", 1)
                tag("Fire Starter")
            }
        }
    }
}