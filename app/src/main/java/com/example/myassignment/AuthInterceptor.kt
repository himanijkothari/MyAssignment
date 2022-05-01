package com.example.myassignment

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class AuthInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        try{
            var request = chain.request()
            val url = request
                .url
                .newBuilder()
                .addQueryParameter("api_key","27cfec6c9eb8080cb7d8025ba420e2d7")
                .build()
            request = request.newBuilder().url(url).build()
            return chain.proceed(request)
        } catch (e: Exception) {
            return Response.Builder()
                .request(chain.request())
                .protocol(Protocol.HTTP_1_1)
                .code(400)
                .message("Client error")
                .body(e.stackTraceToString().toResponseBody("text/plain".toMediaType()))
                .build()
        }
    }
}