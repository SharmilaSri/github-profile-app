package com.sharmila.android.kotlin.githubprofileapp.ui.profile

import ProfileDetailsQuery
import android.content.Context
import android.widget.Toast
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.toDeferred
import com.apollographql.apollo.exception.ApolloException
import com.apollographql.apollo.fetcher.ApolloResponseFetchers
import com.sharmila.android.kotlin.githubprofileapp.network.apolloClient

class ProfileModel(): ProfileContract.Model {

    override suspend fun fetchData(context: Context): Response<ProfileDetailsQuery.Data>? {
        var res:Response<ProfileDetailsQuery.Data>?=null

        apolloClient(context)
            .query(ProfileDetailsQuery())
            .enqueue(object: ApolloCall.Callback<ProfileDetailsQuery.Data>() {
                override fun onResponse(response: Response<ProfileDetailsQuery.Data>) {
                    res=response
                }

                override fun onFailure(e: ApolloException) {

                }
            })

        return res

    }
}