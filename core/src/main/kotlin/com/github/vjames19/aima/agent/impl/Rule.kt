package com.github.vjames19.aima.agent.impl

import com.github.vjames19.aima.agent.Action

/**
 * Created by victor.reventos on 8/8/17.
 */
interface Rule {

    fun evaluate(): Boolean

    val action: Action
}