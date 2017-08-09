package com.github.vjames19.aima.environment.vacuum

import com.github.vjames19.aima.agent.Percept
import com.github.vjames19.aima.agent.State

data class VacuumState(val dirtyStatus: DirtyStatus,
                       val location: VacuumEnvironmentLocation) : Percept, State