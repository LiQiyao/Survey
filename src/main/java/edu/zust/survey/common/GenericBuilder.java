package edu.zust.survey.common;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by Lee on 2017/11/13.
 */
public class GenericBuilder<T> {
    private final Supplier<T> instantiator;
    private List<Consumer<T>> instantiatorModifiers = Lists.newArrayList();

    private GenericBuilder(Supplier<T> instantiator) {
        this.instantiator = instantiator;
    }

    public static <T> GenericBuilder<T> of(Supplier<T> supplier){
        return new GenericBuilder<T>(supplier);
    }

    public <V> GenericBuilder<T> with(BiConsumer<T,V> consumer, V value){
        //一种实现
        Consumer<T> c = (instance) -> consumer.accept(instance, value);
        instantiatorModifiers.add(c);
        return this;
    }

    public T build(){
        T value = instantiator.get();
        instantiatorModifiers.forEach(modifier -> modifier.accept(value));
        instantiatorModifiers.clear();
        return value;
    }
}
