/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.racetracker

import com.example.racetracker.ui.RaceParticipant
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Test

class RaceParticipantTest {

    private val raceParticipant = RaceParticipant(
        name = "Test",
        maxProgress = 100,
        progressDelayMillis = 500L,
        initialProgress = 0,
        progressIncrement = 1
    )

    // -------------------------------------------------------
    // SUCCESS PATH TESTS
    // -------------------------------------------------------

    @Test
    fun raceParticipant_RaceStarted_ProgressUpdated() = runTest {
        val expectedProgress = 1
        launch { raceParticipant.run() }

        // Move the virtual clock forward by one delay interval
        advanceTimeBy(raceParticipant.progressDelayMillis)
        runCurrent()

        assertEquals(expectedProgress, raceParticipant.currentProgress)
    }

    @Test
    fun raceParticipant_RaceFinished_ProgressUpdated() = runTest {
        launch { raceParticipant.run() }

        // Advance virtual time until the race should be complete
        advanceTimeBy(raceParticipant.maxProgress * raceParticipant.progressDelayMillis)
        runCurrent()

        assertEquals(100, raceParticipant.currentProgress)
    }

    // ERROR PATH TESTS
    @Test
    fun raceParticipant_InvalidDelay_NoProgressUpdate() = runTest {
        val invalidParticipant = RaceParticipant(
            name = "Invalid",
            maxProgress = 100,
            progressDelayMillis = -100L, // invalid delay
            initialProgress = 0,
            progressIncrement = 1
        )

        launch { invalidParticipant.run() }

        // Advance time arbitrarily — progress should not change
        advanceTimeBy(2000L)
        runCurrent()

        assertEquals(
            "Progress should not change with an invalid (negative) delay",
            0,
            invalidParticipant.currentProgress
        )
    }

    @Test
    fun raceParticipant_InvalidMaxProgress_NoProgressUpdate() = runTest {
        val invalidParticipant = RaceParticipant(
            name = "InvalidMax",
            maxProgress = 0, // invalid max progress
            progressDelayMillis = 100L,
            initialProgress = 0,
            progressIncrement = 1
        )

        launch { invalidParticipant.run() }
        advanceTimeBy(1000L)
        runCurrent()

        assertEquals(
            "Progress should remain 0 if maxProgress is zero",
            0,
            invalidParticipant.currentProgress
        )
    }

    // BOUNDARY CASE TESTS
    @Test
    fun raceParticipant_InitialState_ProgressIsZero() {
        assertEquals(
            "Initial progress should be zero before the race starts",
            0,
            raceParticipant.currentProgress
        )
    }

    @Test
    fun raceParticipant_OneStepRace_CompletesAfterOneDelay() = runTest {
        val oneStepParticipant = RaceParticipant(
            name = "ShortRace",
            maxProgress = 1,
            progressDelayMillis = 100L,
            initialProgress = 0,
            progressIncrement = 1
        )

        launch { oneStepParticipant.run() }

        advanceTimeBy(oneStepParticipant.progressDelayMillis)
        runCurrent()

        assertEquals(
            "Progress should be complete after one step",
            1,
            oneStepParticipant.currentProgress
        )
    }

    @Test
    fun raceParticipant_NearCompletion_OnlyFinishesToMax() = runTest {
        val nearFinishParticipant = RaceParticipant(
            name = "AlmostDone",
            maxProgress = 100,
            progressDelayMillis = 100L,
            initialProgress = 99,
            progressIncrement = 2 // would overshoot if not capped
        )

        launch { nearFinishParticipant.run() }

        advanceTimeBy(nearFinishParticipant.progressDelayMillis)
        runCurrent()

        assertEquals(
            "Progress should not exceed maxProgress",
            100,
            nearFinishParticipant.currentProgress
        )
    }
}
