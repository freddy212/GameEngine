package com.mygdx.game
import com.mygdx.game.GameObjects.*
import com.mygdx.game.GameObjects.Hazards.Spike
import com.mygdx.game.GameObjects.Hazards.SpikeData
import com.mygdx.game.GameObjects.Memory.MemoryPad
import com.mygdx.game.GameObjects.Memory.MemoryPadData
import com.mygdx.game.GameObjects.Memory.MemoryStone
import com.mygdx.game.GameObjects.Memory.MemoryStoneData
import com.mygdx.game.GameObjects.MoveableObjects.ButlerActivationSensor
import com.mygdx.game.GameObjects.MoveableObjects.ButlerData
import com.mygdx.game.GameObjects.Sensors.SpeechActivationSensor
import com.mygdx.game.GameObjects.Sensors.SpeechData
import kotlinx.serialization.Serializable

@Serializable
data class Root(val entities: Entities, val width: Int, val height: Int, val uniqueIdentifer: String, val identifier: String)
@Serializable
data class Entities(
    val FloorButton: List<FloorButtonData> = listOf(),
    val LockedDoor: List<LockedDoorData> = listOf(),
    val Entrance: List<EntranceData> = listOf(),
    val Butler: List<ButlerData> = listOf(),
    val Spikes: List<SpikeData> = listOf(),
    val MemoryPad: List<MemoryPadData> = listOf(),
    val MemoryStone: List<MemoryStoneData> = listOf(),
    val DialogueSensor: List<SpeechData> = listOf(),
)
fun initMappings(){
    GameObjectFactory.register(FloorButtonData::class.java) {
        Button(it as FloorButtonData)
    }
    GameObjectFactory.register(LockedDoorData::class.java) {
        LockedDoor(it as LockedDoorData)
    }
    GameObjectFactory.register(EntranceData::class.java) {
        Entrance(it as EntranceData)
    }
    GameObjectFactory.register(ButlerData::class.java) {
        ButlerActivationSensor(it as ButlerData)
    }
    GameObjectFactory.register(SpikeData::class.java) {
        Spike(it as SpikeData)
    }
    GameObjectFactory.register(MemoryPadData::class.java) {
        MemoryPad(it as MemoryPadData)
    }
    GameObjectFactory.register(MemoryStoneData::class.java) {
        MemoryStone(it as MemoryStoneData)
    }
    GameObjectFactory.register(SpeechData::class.java) {
        SpeechActivationSensor(it as SpeechData)
    }
}
interface GameObjectData {
    val x: Int
    var y: Int
    val iid: String
    val width: Int
    val height: Int

}
@Serializable
data class EntityRefData(val entityIid: String, val layerIid: String, val levelIid: String, val worldIid: String)