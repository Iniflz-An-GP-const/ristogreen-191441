package d7man.ristogreen.digital.di

import androidx.room.Room
import d7man.ristogreen.digital.data.database.DIRILAppDatabase
import d7man.ristogreen.digital.data.repository.GameRecordRepository
import d7man.ristogreen.digital.data.repository.PuzzleRepository
import org.koin.dsl.module

private const val DB_NAME = "diril_puzzle_db"

val dataModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = DIRILAppDatabase::class.java,
            name = DB_NAME
        )
            .fallbackToDestructiveMigration(dropAllTables = true)
            .build()
    }

    single { get<DIRILAppDatabase>().gameRecordDao() }

    single {
        GameRecordRepository(
            gameRecordDao = get(),
            ioDispatcher = get(DispatchersQualifiers.IO)
        )
    }

    single { PuzzleRepository() }

}