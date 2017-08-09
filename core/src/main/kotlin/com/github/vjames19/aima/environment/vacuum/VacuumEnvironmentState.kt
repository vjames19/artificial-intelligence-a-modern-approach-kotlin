package com.github.vjames19.aima.environment.vacuum

import com.github.vjames19.aima.agent.Percept
import com.github.vjames19.aima.agent.State

/**
 * Created by victor.reventos on 8/9/17.
 */
enum class DirtyStatus {
    Clean, Dirty
}

enum class Location {
    Left, Right
}

data class VacuumEnvironmentState(val dirtyStatus: DirtyStatus, val location: Location): State, Percept