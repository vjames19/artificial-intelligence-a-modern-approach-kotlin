package com.github.vjames19.aima.environment.vacuum

import com.github.vjames19.aima.agent.Agent
import com.github.vjames19.aima.agent.Percept
import com.github.vjames19.aima.agent.State

/**
 * Created by victor.reventos on 8/9/17.
 */
data class VacuumEnvironmentState(val locationDirtyStatus: MutableList<DirtyStatus>,
                                  val agentsLocation: MutableMap<Agent, VacuumEnvironmentLocation> = mutableMapOf<Agent, VacuumEnvironmentLocation>()) : State, Percept {
    fun agentLocation(agent: Agent): VacuumEnvironmentLocation = agentsLocation[agent]!!

    fun locationDirtyStatus(location: VacuumEnvironmentLocation) =
            locationDirtyStatus[if (location == VacuumEnvironmentLocation.Left) 0 else 1]
}