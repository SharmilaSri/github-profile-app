package com.sharmila.android.kotlin.githubprofileapp.ui.profile

import android.content.Context
import android.util.Log
import com.apollographql.apollo.api.Response
import org.jetbrains.annotations.Contract

class ProfilePresenter(var mainView: ProfileContract.View?, var model:ProfileContract.Model) : ProfileContract.Presenter {

    var  response: Response<ProfileDetailsQuery.Data>? = null
    val repos = mutableListOf<ProfileDetailsQuery.Repositories?>()


    override suspend fun getDataFromNetwork(context: Context) {
        if (mainView != null) {
            mainView!!.showProgress()
            response =model.fetchData(context)
            Log.d("****",response.toString());
            val newLaunches = response?.data?.user?.repositories
            repos.add(newLaunches)
            mainView!!.displayData(response,repos)
            mainView!!.hideProgress()
        }
    }

    override fun onDestroy() {
        mainView = null
    }
}