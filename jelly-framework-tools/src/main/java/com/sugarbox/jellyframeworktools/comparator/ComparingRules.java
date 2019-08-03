package com.sugarbox.jellyframeworktools.comparator;

public interface ComparingRules<T, V> {

    void loadRules(T lhs, T rhs);

    V fire();
}
