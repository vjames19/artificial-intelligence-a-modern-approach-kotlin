package com.github.vjames19.aima.agent.impl

import com.github.vjames19.aima.agent.Action
import com.github.vjames19.aima.agent.State

/**
 * Created by victor.reventos on 8/8/17.
 */
interface Rule<S: State> {

    fun evaluate(state: S): Boolean

    val action: Action
}