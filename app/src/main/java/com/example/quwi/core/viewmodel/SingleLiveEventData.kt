package com.example.quwi.core.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

open class SingleLiveEventData<T> : MutableLiveData<T> {

    constructor() : super()

    constructor(value: T?) : super(value) {
        isPending.set(true)
    }

    private val isPending = AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner) { t ->
            if (isPending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        }
    }

    override fun setValue(value: T?) {
        isPending.set(true)
        super.setValue(value)
    }

    override fun postValue(value: T?) {
        isPending.set(true)
        super.postValue(value)
    }

    fun clearValue() {
        value = null
    }

}