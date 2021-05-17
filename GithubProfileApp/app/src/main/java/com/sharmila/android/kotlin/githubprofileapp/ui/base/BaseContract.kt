package com.sharmila.android.kotlin.githubprofileapp.ui.base

class BaseContract {

    interface Presenter<in T> {
        fun attach(view: T)
    }

    interface View {

    }
}