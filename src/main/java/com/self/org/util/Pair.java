package com.self.org.util;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 
 * @author Evan Savage <savage.evan@gmail.com>
 *
 * Utility class for creating immutable pairs of objects.  Supports equality checking, hashing,
 * and comparison, as well as static type-inferred creation via Pair.of().
 *
 * @param <T1>  type of first value
 * @param <T2>  type of second value
 */
public class Pair<T1 extends Comparable<T1>, T2 extends Comparable<T2>> implements Comparable<Pair<T1, T2>> {
    final T1 first;
    final T2 second;
    
    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object that) {
        if (that == this) {
            return true;
        }
        if (that == null || that.getClass() != this.getClass()) {
            return false;
        }
        Pair<T1, T2> thatPair = (Pair<T1, T2>) that;
        return new EqualsBuilder()
            .append(this.first, thatPair.first)
            .append(this.second, thatPair.second)
            .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(first)
            .append(second)
            .toHashCode();
    }
    
    @Override
    public int compareTo(Pair<T1, T2> that) {
        int cmp = first.compareTo(that.first);
        if (cmp != 0) {
            return cmp;
        }
        return second.compareTo(that.second);
    }
    
    public static <E1 extends Comparable<E1>, E2 extends Comparable<E2>> Pair<E1, E2> of(E1 first, E2 second) {
        return new Pair<E1, E2>(first, second);
    }
}
