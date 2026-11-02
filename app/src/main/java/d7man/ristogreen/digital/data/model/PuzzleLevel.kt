package d7man.ristogreen.digital.data.model

import androidx.annotation.StringRes
import d7man.ristogreen.digital.R

enum class PuzzleLevel(
    @param:StringRes val titleRes: Int,
    @param:StringRes val gridRes: Int,
    val gridSize: Int,
) {
    EASY(
        titleRes = R.string.easy_puzzle_level_title,
        gridRes = R.string.easy_puzzle_level_grid,
        gridSize = 3,
    ),

    MEDIUM(
        titleRes = R.string.medium_puzzle_level_title,
        gridRes = R.string.medium_puzzle_level_grid,
        gridSize = 4,
    ),

    HARD(
        titleRes = R.string.hard_puzzle_level_title,
        gridRes = R.string.hard_puzzle_level_grid,
        gridSize = 5,
    ),

    EXPERT(
        titleRes = R.string.expert_puzzle_level_title,
        gridRes = R.string.expert_puzzle_level_grid,
        gridSize = 6,
    ),
}