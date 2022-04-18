package sheridan.chelseac.harvestapplication

import android.app.Application
import androidx.databinding.library.baseAdapters.BuildConfig
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainActivity : Application(), Configuration.Provider {
    override fun getWorkManagerConfiguration(): Configuration =
        Configuration.Builder()
            .setMinimumLoggingLevel(if (BuildConfig.DEBUG) android.util.Log.DEBUG else android.util.Log.ERROR)
            .build()
}
