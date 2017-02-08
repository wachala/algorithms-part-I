package com.wachala.algo.algorithms.coursera.union

import spock.lang.Specification


class UFLazyApproachTest extends Specification {

    def "should return correct results for connected operation after few unions"() {
        given:
        UFLazyApproach unionFind = new UFLazyApproach(10)

        when:
        unionFind.union(0, 6)
        unionFind.union(1, 2)
        unionFind.union(3, 7)
        unionFind.union(5, 6)
        unionFind.union(8, 9)
        unionFind.union(4, 3)

        then:
        unionFind.connected(4, 7)
        unionFind.connected(9, 8)
        unionFind.connected(0, 5)
        unionFind.connected(2, 1)
        !unionFind.connected(5, 3)
        !unionFind.connected(5, 9)
        !unionFind.connected(2, 9)
    }

}
