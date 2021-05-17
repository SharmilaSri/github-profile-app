package com.sharmila.android.kotlin.githubprofileapp.ui.main

import com.sharmila.android.kotlin.githubprofileapp.ui.base.BaseContract

class MainContract {

    interface View: BaseContract.View {
        fun showProfileFragment()
    }

    interface Presenter: BaseContract.Presenter<MainContract.View> {

    }
}