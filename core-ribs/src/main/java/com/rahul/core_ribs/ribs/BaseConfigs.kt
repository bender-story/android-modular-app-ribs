package com.rahul.core_ribs.ribs


/**
 * Base config that needs to be set during the creation of router
 */
class BaseConfigs(
    var serviceType: ServiceType = ServiceType.API,
    var apiBase: String = "",
    var apiTimeOut: Long = 100
)

/**
 * Enum class to declare if app is trying to use actual api or mock.
 */
enum class ServiceType {
    API,
    MOCK
}
