package com.a9992099300.setting.di

import com.a9992099300.asteroidlocator.core_api.di.ProvidersFacade
import com.a9992099300.setting.SettingsFragment
import dagger.Component

@Component(modules = [SettingModule::class],
    dependencies = [ProvidersFacade::class]
)
interface SettingComponent {
    fun inject(settingsFragment: SettingsFragment)
}