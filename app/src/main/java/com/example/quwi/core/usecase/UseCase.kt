package com.example.quwi.core.usecase

abstract class UseCase<in P, R> {

    /** Executes the use case synchronously and returns a [R].
     *
     * @return a [R].
     *
     * @param parameters the input parameters to run the use case with
     */
    operator fun invoke(parameters: P): R {
        return execute(parameters)
    }

    /**
     * Override this to set the code to be executed.
     */
    @Throws(RuntimeException::class)
    protected abstract fun execute(parameters: P): R
}