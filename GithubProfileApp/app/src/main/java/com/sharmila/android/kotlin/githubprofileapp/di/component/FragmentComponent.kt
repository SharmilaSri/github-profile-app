package com.sharmila.android.kotlin.githubprofileapp.di.component


import com.sharmila.android.kotlin.githubprofileapp.di.module.FragmentModule
import com.sharmila.android.kotlin.githubprofileapp.ui.profile.ProfileFragment
import dagger.Component


@Component(modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(profileFragment: ProfileFragment)

}