package com.wachala.algo.algorithms.coursera.stack

import spock.lang.Specification


class StackListBasedTest extends Specification {

    def "should throw an exception when stack is empty and peek performed"() {
        given:
        StackListBased<Integer> stack = new StackListBased<>();

        when:
        stack.peek()

        then:
        thrown NoSuchElementException
    }

    def "should throw an exception when stack is empty and pop performed"() {
        given:
        StackListBased<Integer> stack = new StackListBased<>();

        when:
        stack.pop()

        then:
        thrown NoSuchElementException
    }

    def "should return correct size"() {
        given:
        StackListBased<Integer> stack = new StackListBased<>();

        when:
        stack.push(10)

        then:
        stack.size() == 1

        when:
        stack.push(123)
        stack.push(34)

        then:
        stack.size() == 3

        when:
        stack.pop()
        stack.pop()

        then:
        stack.size() == 1
    }

    def "should return correct element when pop operation performed"() {
        given:
        StackListBased<Integer> stack = new StackListBased<>();

        when:
        stack.push(234)

        then:
        stack.peek() == 234
        stack.pop() == 234

        when:
        stack.push(5623)
        stack.push(12356)

        then:
        stack.peek() == 12356
        stack.pop() == 12356
        stack.peek() == 5623
        stack.pop() == 5623
    }

}
