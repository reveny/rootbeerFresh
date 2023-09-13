package com.kimchangyoun.rootbeerFresh.sample

import android.app.Application
import android.os.Build
import android.os.StrictMode
import androidx.multidex.MultiDexApplication
import timber.log.Timber

class RootSampleApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        if (BuildConfig.DEBUG) {
            initStrictMode()
        }
    }

    private fun initStrictMode() {
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .penaltyDeathOnNetwork()
                .build()
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectNonSdkApiUsage()
                    .detectCleartextNetwork()
                    .penaltyLog()
                    .build()
            )
        }
    }
}
