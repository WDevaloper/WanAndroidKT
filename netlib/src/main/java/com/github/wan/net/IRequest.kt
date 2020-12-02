package com.github.wan.net

interface IRequest {
    //GET请求
    fun get(url: String, params: Map<String, Any>?, callback: ICallBack)

    //POST请求
    fun post(url: String, params: Map<String, Any>?, callback: ICallBack)
}