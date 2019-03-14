package com.example.cache

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class SysConfig(
        @Id
        var id: Long = 0,
        var key: String? = null,
        var value: String? = null,
        var remark: String? = null,
        var status: Int = 0
): Serializable