package sheridan.chelseac.harvestapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Main application class for the Botanist Application.
 * 
 * @HiltAndroidApp triggers Hilt's code generation, which acts as the
 * dependency container for the entire app.
 */
@HiltAndroidApp
class MainApplication : Application()
