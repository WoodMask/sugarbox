package com.sugarbox.jellyframeworktools.comparator;

public abstract class AbstractComparator implements ComparingRules<ComparableDefinition, ComparingResultDefinition>{


    @Override
    public void loadRules(ComparableDefinition lhs, ComparableDefinition rhs) {

    }

    @Override
    public ComparingResultDefinition fire() {
        return null;
    }
}
