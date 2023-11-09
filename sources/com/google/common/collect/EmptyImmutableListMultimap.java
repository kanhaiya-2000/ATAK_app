package com.google.common.collect;

class EmptyImmutableListMultimap extends ImmutableListMultimap<Object, Object> {
    static final EmptyImmutableListMultimap INSTANCE = new EmptyImmutableListMultimap();
    private static final long serialVersionUID = 0;

    private EmptyImmutableListMultimap() {
        super(ImmutableMap.m15152of(), 0);
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
