package com.example.quwi.core.timezone

import android.icu.util.TimeZone

class TimeZoneProviderImpl : TimeZoneProvider {

    override fun getTimeZone(): String = TimeZone.getDefault().displayName

}