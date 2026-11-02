package d7man.ristogreen.digital.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity("game_records")
data class GameRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    /** Id of the [d7man.ristogreen.digital.data.model.Puzzle] that was assembled. */
    @ColumnInfo(name = "puzzle_id") val puzzleId: Int,
    /** Name of the [d7man.ristogreen.digital.data.model.PuzzleLevel] constant. */
    val level: String,
    /** Time to assemble, in seconds. */
    @ColumnInfo(name = "completion_time") val completionTime: Long,
    val timestamp: LocalDateTime,
)