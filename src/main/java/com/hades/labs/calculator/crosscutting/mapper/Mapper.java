package com.hades.labs.calculator.crosscutting.mapper;

@FunctionalInterface
public interface Mapper<I, O>{
    O map(final I input);
}
