package com.mygdx.game.Managers

import com.mygdx.game.Area.Area
import com.mygdx.game.Area.AreaIdentifier
import com.mygdx.game.Collition.CollisionType
import com.mygdx.game.GameObject.GameObject

class AreaManager {
    companion object {
        val areas = mutableListOf<Area>()
        private var activeArea: Area? = null

        fun setActiveArea(areaIdentifier: AreaIdentifier){
            val areaWithIdentifier = areas.find { it.areaIdentifier == areaIdentifier }
            activeArea = areaWithIdentifier
        }
        fun getActiveArea(): Area?{
            return activeArea
        }

        fun getObjectsWithCollisionType(collisionType: CollisionType): List<GameObject>{
            val activeObjects = activeArea!!.gameObjects

            return activeObjects.filter { it.collision.collitionType == collisionType }
        }
    }
}