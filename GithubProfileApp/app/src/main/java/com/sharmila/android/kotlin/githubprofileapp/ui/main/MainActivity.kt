package com.sharmila.android.kotlin.githubprofileapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sharmila.android.kotlin.githubprofileapp.R
import com.sharmila.android.kotlin.githubprofileapp.di.component.DaggerActivityComponent
import com.sharmila.android.kotlin.githubprofileapp.di.module.ActivityModule
import com.sharmila.android.kotlin.githubprofileapp.ui.profile.ProfileFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(),MainContract.View  {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectDependency()

        presenter.attach(this)
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    override fun showProfileFragment() {
        supportFragmentManager.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(AnimType.SLIDE.getAnimPair().first, AnimType.SLIDE.getAnimPair().second)
            .replace(R.id.frame, ProfileFragment().newInstance(), ProfileFragment.TAG)
            .commit()
    }

    enum class AnimType() {
        SLIDE,
        FADE;

        fun getAnimPair(): Pair<Int, Int> {
            when(this) {
                SLIDE -> return Pair(R.anim.slide_left, R.anim.slide_right)
                FADE -> return Pair(R.anim.fade_in, R.anim.fade_out)
            }

            return Pair(R.anim.slide_left, R.anim.slide_right)
        }
    }
}