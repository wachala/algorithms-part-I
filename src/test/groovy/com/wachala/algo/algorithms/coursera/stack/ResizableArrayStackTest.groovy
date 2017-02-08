package com.wachala.algo.algorithms.coursera.stack

import spock.lang.Specification


class ResizableArrayStackTest extends Specification {

    def "should throw an exception when stack is empty"() {
        given:
        ResizableArrayStack<Integer> stack = new ResizableArrayStack<>();

        when:
        stack.pop()

        then:
        thrown NoSuchElementException
    }

    def "should perform operation on stack correctly"() {
        given:
        ResizableArrayStack<Integer> stack = new ResizableArrayStack<>();

        when:
        def result = stack.isEmpty()
        then:
        result

        when:
        stack.push(10)
        stack.push(123)
        then:
        !stack.isEmpty()
        stack.peek() == 123
        stack.pop() == 123
        stack.pop() == 10
    }

    def "should resize stack when more than 10 element present"() {
        given:
        ResizableArrayStack<Integer> stack = new ResizableArrayStack<>();

        when:
        stack.push(10)
        stack.push(45)
        stack.push(534)
        stack.push(213)
        stack.push(7678)
        stack.push(12)
        stack.push(545)
        stack.push(213)
        stack.push(12)
        stack.push(27)
        stack.push(34)

        then:
        !stack.isEmpty()
        stack.size() == 11
        stack.peek() == 34
    }

    def "should resize correctly"() {
        given:
        ResizableArrayStack<Integer> stack = new ResizableArrayStack<>();

        when:
        def result = stack.array.length
        then:
        result == 10;

        when:
        int biggerSize = result * 2;
        stack.resizeArray(biggerSize)
        then:
        stack.array.length == 20

        when:
        int lowerSize = result / 2;
        stack.resizeArray(lowerSize)
        then:
        stack.array.length == 5
    }

}
