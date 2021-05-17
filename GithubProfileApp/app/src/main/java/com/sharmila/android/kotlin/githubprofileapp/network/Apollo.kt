package com.sharmila.android.kotlin.githubprofileapp.network

import android.content.Context
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.cache.normalized.lru.EvictionPolicy
import com.apollographql.apollo.cache.normalized.lru.LruNormalizedCacheFactory

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import com.sharmila.android.kotlin.githubprofileapp.utils.Constants

private var instance: ApolloClient? = null

fun apolloClient(context: Context): ApolloClient {
    val cacheFactory = LruNormalizedCacheFactory(EvictionPolicy.builder().maxSizeBytes(10 * 1024 * 1024).build())

    if (instance != null) {
        return instance!!
    }

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            AuthorizationInterceptor(
                context
            )
        )
        .build()

    instance = ApolloClient.builder()
        .serverUrl(Constants.BASE_URL)
        .normalizedCache(cacheFactory)
        .okHttpClient(okHttpClient)
        .build()

    return instance!!
}


private class AuthorizationInterceptor(val context: Context) : Interceptor {

    val token="Bearer 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"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", token)
            .build()

        return chain.proceed(request)
    }
}
