package com.sharmila.android.kotlin.githubprofileapp.ui.main

class MainPresenter: MainContract.Presenter  {

    private lateinit var view: MainContract.View


    override fun attach(view: MainContract.View) {
        this.view = view
        view.showProfileFragment()
    }
}