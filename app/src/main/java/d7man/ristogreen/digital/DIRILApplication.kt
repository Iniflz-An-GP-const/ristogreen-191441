package d7man.ristogreen.digital

import android.app.Application
import d7man.ristogreen.digital.di.dataModule
import d7man.ristogreen.digital.di.dispatcherModule
import d7man.ristogreen.digital.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class DIRILApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val appModules = dispatcherModule + dataModule + viewModule

        startKoin {
            androidLogger()
            androidContext(this@DIRILApplication)
            modules(appModules)
        }
    }
}