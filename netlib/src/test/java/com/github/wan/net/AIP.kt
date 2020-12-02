package com.github.wan.net

import com.github.wan.net.annotation.GET
import com.github.wan.net.annotation.Parameter

interface AIP {
    @GET("https://www.baidu.com/?tn=88093251_56_hao_pg")
    fun getBaiDu(@Parameter("tn") tn: String): String
}