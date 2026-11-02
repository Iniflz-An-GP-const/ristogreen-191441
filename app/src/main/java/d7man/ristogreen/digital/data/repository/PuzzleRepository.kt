package d7man.ristogreen.digital.data.repository

import d7man.ristogreen.digital.R
import d7man.ristogreen.digital.data.model.Puzzle

class PuzzleRepository {
    private val puzzles: List<Puzzle> = listOf(
        
    )

    fun getPuzzles(): List<Puzzle> = puzzles

    fun findById(id: Int): Puzzle? = puzzles.firstOrNull { it.id == id }
}