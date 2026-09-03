package com.example.androidbasictoadvanced

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.androidbasictoadvanced.feature.viewmodel.PostListScreen
import com.example.androidbasictoadvanced.feature.viewmodel.PostVM
import com.example.androidbasictoadvanced.feature.viewmodel.TodosListScreen
import com.example.androidbasictoadvanced.feature.viewmodel.TodosVM
import com.example.androidbasictoadvanced.navigation.BaseNavigation
import com.example.androidbasictoadvanced.ui.theme.AndroidBasicToAdvancedTheme
import com.example.androidbasictoadvanced.util.Loading
import com.example.androidbasictoadvanced.util.LoadingUtil

class MainActivity : ComponentActivity() {

    /**
     * onCreate(): is called when the activity is created for the first time.
     * It is used to initialize the activity, set up the user interface, and
     * prepare resources needed by the activity.
     */
    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        println("=====> onCreate")
        enableEdgeToEdge()
        setContent {
            AndroidBasicToAdvancedTheme {

                if (LoadingUtil.isLoading.value) {
                    Loading()
                }
                BaseNavigation()
            }

        }
    }


    /**
     *onStart() is called when the activity becomes visible to the user but is not
     * yet ready for user interaction.
     */
    override fun onStart() {
        super.onStart()
//        println("=====> onStart")
    }

    /**
     * onResume() is called when the activity enters the foreground and is ready for
     * the user to interact with it.
     */
    override fun onResume() {
        super.onResume()
//        println("=====> onResume")
    }

    /**
     * onPause() is called when the activity loses focus because another activity or
     * system component is partially covering it. The activity is still visible but is
     * no longer the active one.
     */
    override fun onPause() {
        super.onPause()
//        println("=====> onPause")
    }

    /**
     * onStop() is called when the activity is no longer visible to the user.
     */
    override fun onStop() {
        super.onStop()
//        println("=====> onStop")
    }

    /**
     * onRestart() is called after the activity has been stopped and just before it
     * starts again. It prepares the activity to become visible once more.
     */
    override fun onRestart() {
        super.onRestart()
//        println("=====> onRestart")
    }

    /**
     * onDestroy() is called before the activity is destroyed. It is the final
     * lifecycle callback and is used to perform any remaining cleanup.
     */
    override fun onDestroy() {
        super.onDestroy()
//        println("=====> onDestroy")
    }

}












