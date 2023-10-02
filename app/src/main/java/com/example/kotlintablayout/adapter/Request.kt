package com.example.kotlintablayout.adapter

import com.example.kotlintablayout.model.Modelfood


data class Request (

    var  namereq: String? = null,
    var address: String? = null,
    var telephonereq: String? = null,
    var totalreq: String? = null,

    var timereq: String? = null,
    var statusreq: String? = null,

    var listreq: List<Modelfood>? = null
        )

