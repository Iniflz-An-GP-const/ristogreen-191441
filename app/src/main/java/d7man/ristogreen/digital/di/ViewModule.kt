package d7man.ristogreen.digital.di

import android.content.Context
import d7man.ristogreen.digital.ui.viewmodel.GameRecordViewModel
import d7man.ristogreen.digital.ui.viewmodel.GameViewModel
import d7man.ristogreen.digital.ui.viewmodel.PuzzleSetupViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        PuzzleSetupViewModel(
            puzzleRepository = get(),
            gameRecordRepository = get(),
        )
    }

    viewModel {
        GameViewModel(
            puzzleRepository = get(),
            gameRecordRepository = get(),
            resources = get<Context>().resources,
            ioDispatcher = get(DispatchersQualifiers.IO),
        )
    }

    viewModel {
        GameRecordViewModel(
            puzzleRepository = get(),
            gameRecordRepository = get(),
        )
    }
}