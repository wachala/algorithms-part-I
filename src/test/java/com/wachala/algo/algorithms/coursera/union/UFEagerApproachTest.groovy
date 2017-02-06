package com.wachala.algo.algorithms.coursera.union

import spock.lang.Specification


class UFEagerApproachTest extends Specification {

    def "should return correct results for connected operation after few unions"() {
        given:
        UFEagerApproach unionFind = new UFEagerApproach(10);

        when:
        unionFind.union(1, 2)
        unionFind.union(3, 4)
        unionFind.union(5, 6)
        unionFind.union(7, 8)
        unionFind.union(7, 9)
        unionFind.union(5, 0)
        unionFind.union(1, 9)

        then:
        unionFind.connected(0, 5)
        unionFind.connected(0, 6)
        unionFind.connected(1, 2)
        unionFind.connected(1, 7)
        unionFind.connected(3, 4)
        !unionFind.connected(6, 1)
        !unionFind.connected(4, 9)
        !unionFind.connected(2, 5)
    }

}
