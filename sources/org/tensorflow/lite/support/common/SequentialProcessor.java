package org.tensorflow.lite.support.common;

import atakplugin.UASTool.civ;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SequentialProcessor<T> implements Processor<T> {
    protected final Map<String, List<Integer>> operatorIndex;
    protected final List<Operator<T>> operatorList;

    protected SequentialProcessor(Builder<T> builder) {
        this.operatorList = builder.operatorList;
        this.operatorIndex = Collections.unmodifiableMap(builder.operatorIndex);
    }

    public T process(T t) {
        for (Operator<T> apply : this.operatorList) {
            t = apply.apply(t);
        }
        return t;
    }

    protected static class Builder<T> {
        /* access modifiers changed from: private */
        public final Map<String, List<Integer>> operatorIndex = new HashMap();
        /* access modifiers changed from: private */
        public final List<Operator<T>> operatorList = new ArrayList();

        protected Builder() {
        }

        public Builder<T> add(@civ Operator<T> operator) {
            SupportPreconditions.checkNotNull(operator, "Adding null Op is illegal.");
            this.operatorList.add(operator);
            String name = operator.getClass().getName();
            if (!this.operatorIndex.containsKey(name)) {
                this.operatorIndex.put(name, new ArrayList());
            }
            this.operatorIndex.get(name).add(Integer.valueOf(this.operatorList.size() - 1));
            return this;
        }

        public SequentialProcessor<T> build() {
            return new SequentialProcessor<>(this);
        }
    }
}
