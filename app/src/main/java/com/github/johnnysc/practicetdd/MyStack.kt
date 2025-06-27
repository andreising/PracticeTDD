package com.github.johnnysc.practicetdd

abstract class MyStack<T>() {


    protected val stack = mutableListOf<T>()

    abstract val maxCount: Int

    abstract fun pop() : T

    fun push(item: T) {
        if (stack.size >= maxCount) throw IllegalStateException("Stack overflow exception, maximum is $maxCount")
        stack.add(item)
    }

    class LIFO<T>(override val maxCount: Int) : MyStack<T>() {
        init {
            if (maxCount <= 0) throw IllegalStateException()
        }
        override fun pop(): T {
            if (stack.isEmpty()) throw IllegalStateException()
            val result = stack.last()
            stack.remove(stack.last())
            return result
        }
    }

    class FIFO<T>(override val maxCount: Int) : MyStack<T>() {
        init {
            if (maxCount <= 0) throw IllegalStateException()
        }
        override fun pop(): T {
            if (stack.isEmpty()) throw IllegalStateException()
            val result = stack.first()
            stack.removeAt(0)
            return result
        }
    }
}