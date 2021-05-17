package com.sharmila.android.kotlin.githubprofileapp.ui.profile

import android.content.Context
import com.apollographql.apollo.api.Response
import com.sharmila.android.kotlin.githubprofileapp.ui.base.BaseContract

class ProfileContract {

    interface View: BaseContract.View {
        fun showProgress()

        fun hideProgress()

        suspend fun getData(context: Context)

        fun displayData(response: Response<ProfileDetailsQuery.Data>?, list:MutableList<ProfileDetailsQuery.Repositories?>)

    }

    interface Model {

        suspend fun fetchData(context: Context) : Response<ProfileDetailsQuery.Data>?
    }

    interface Presenter {
        suspend fun getDataFromNetwork(context: Context)

        fun onDestroy()
    }


}