package com.github.wan.net


interface ICallBack {
    fun onSuccess(response: String?)
    fun onFailed(throws: Throwable)
}