package com.sharmila.android.kotlin.githubprofileapp.ui.main

class MainPresenter: MainContract.Presenter  {

    private lateinit var view: MainContract.View

    override fun subscribe() {
        TODO("Not yet implemented")
    }

    override fun unsubscribe() {
        TODO("Not yet implemented")
    }

    override fun attach(view: MainContract.View) {
        this.view = view
        view.showProfileFragment()
    }
}