package com.mygdx.game.Collisions

import com.mygdx.game.Collition.MoveCollision
import com.mygdx.game.GameObject.GameObject

open class CanMoveCollision: MoveCollision() {
    override var canMoveAfterCollision = true

    override fun collisionHappened(collidedObject: GameObject) {

    }
}