package com.wachala.algo.algorithms.coursera.stack

import com.wachala.algo.algorithms.coursera.stack.util.StackFullException
import spock.lang.Specification


class FixedSizeStackTest extends Specification {

    def "should perform operation on stack correctly"() {
        given:
        FixedSizeStack<Integer> stack;

        when:
        stack = new FixedSizeStack<>(3);

        then:
        stack.isEmpty()
        stack.size() == 0

        when:
        stack.push(10)
        !stack.isEmpty()

        then:
        stack.size() == 1

        when:
        stack.peek() == 1
        stack.pop()

        then:
        stack.size() == 0
        stack.isEmpty()
    }

    def "should throw an exception when no elements on stack"() {
        given:
        FixedSizeStack<Integer> stack = new FixedSizeStack<>(3);

        when:
        stack.pop()

        then:
        thrown NoSuchElementException
    }

    def "should throw an exception stack is full"() {
        given:
        FixedSizeStack<Integer> stack = new FixedSizeStack<>(3);

        when:
        stack.push(2)
        stack.push(12)
        stack.push(34)
        stack.push(77)

        then:
        thrown StackFullException
    }

}
