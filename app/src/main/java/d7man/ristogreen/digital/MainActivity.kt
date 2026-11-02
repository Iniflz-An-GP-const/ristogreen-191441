package d7man.ristogreen.digital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import d7man.ristogreen.digital.ui.composable.app_root.AppRoot
import d7man.ristogreen.digital.ui.theme.DIRILAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DIRILAppTheme {
                AppRoot()
            }
        }
    }
}