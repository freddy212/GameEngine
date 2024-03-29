package com.mygdx.game.GameObjects.Memory

import com.badlogic.gdx.math.Vector2
import com.mygdx.game.DefaultTextureHandler
import com.mygdx.game.Enums.Layer
import com.mygdx.game.GameObject.GameObject
import com.mygdx.game.GameObjectData
import kotlinx.serialization.Serializable

class MemoryPad(val gameObjectData: MemoryPadData) : GameObject(gameObjectData, Vector2(32f,32f)) {
    override val texture = DefaultTextureHandler.getTexture("Box.png")
    override val layer = Layer.ONGROUND
    private val amountOfStone: Int = gameObjectData.customFields.AmountOfStones
    private var stonesActivateSoFar = 0

    fun activateStone(){
        stonesActivateSoFar += 1
        if(stonesActivateSoFar == amountOfStone){
            println("Memory pad activated")
        }
    }
}

@Serializable
data class MemoryPadData(
    override val iid: String,
    override val x: Int,
    override var y: Int,
    override val width: Int,
    override val height: Int,
    val customFields: MemoryPadCustomFields
): GameObjectData

@Serializable
data class MemoryPadCustomFields(val AmountOfStones: Int){

}
