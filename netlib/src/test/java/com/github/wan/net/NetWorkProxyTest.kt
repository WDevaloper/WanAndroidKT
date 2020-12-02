package com.github.wan.net

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class NetWorkProxyTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun create() {
        NetWorkProxy.create(AIP::class.java).getBaiDu("88093251_56_hao_pg")
    }
}