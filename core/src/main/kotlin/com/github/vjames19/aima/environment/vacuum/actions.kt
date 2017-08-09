package com.github.vjames19.aima.environment.vacuum

import com.github.vjames19.aima.agent.Action

/**
 * Created by victor.reventos on 8/9/17.
 */
sealed class VacuumAction : Action
object MoveLeft : VacuumAction()
object MoveRight : VacuumAction()
object Suck : VacuumAction()