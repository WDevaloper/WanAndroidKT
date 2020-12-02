package com.github.wan.net

import android.util.Log
import com.github.wan.net.annotation.GET
import com.github.wan.net.annotation.POST
import retrofit2.Retrofit
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import java.util.*
import java.util.regex.Pattern

object NetWorkProxy {
    val TAG = NetWorkProxy::class.java.simpleName

    @JvmStatic
    fun <T> create(service: Class<T>): T {
        return Proxy.newProxyInstance(
            service.classLoader, arrayOf(service),
            object : InvocationHandler {
                override fun invoke(proxy: Any?, methods: Method?, args: Array<out Any>?): Any {
                    return dispatch(proxy, methods, args)
                }
            }) as T
    }

    private fun dispatch(proxy: Any?, methods: Method?, args: Array<out Any>?): Any {
        methods?.annotations?.forEach { parseMethodAnnotation(it) }
        Retrofit.Builder().build().create(Any::class.java)
        return "proxy"
    }

    private fun parseMethodAnnotation(annotation: Annotation) {
        if (annotation is GET) {
            parseHttpMethodAndPath("GET", annotation.value, false)
        } else if (annotation is POST) {
            parseHttpMethodAndPath("POST", annotation.value, true)
        }
    }

    private const val PARAM = "[a-zA-Z][a-zA-Z0-9_-]*"
    private val PARAM_URL_REGEX = Pattern.compile("\\{($PARAM)\\}")

    private fun parseHttpMethodAndPath(httpMethod: String, value: String, hasBody: Boolean) {
       println("parseHttpMethodAndPath: $httpMethod  $value $hasBody")

        // 获取相对URL路径和现有查询字符串（如果存在）。
        val question: Int = value.indexOf('?')
        if (question != -1 && question < value.length - 1) {
            // 确保查询字符串没有任何命名参数。
            val queryParams: String = value.substring(question + 1)
            val queryParamMatcher =
                PARAM_URL_REGEX.matcher(queryParams)
            if (queryParamMatcher.find()) {
                println("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.")
            }
        }

        println("parseHttpMethodAndPath:$value ${Utils.parsePathParameters(value)}")

    }
}