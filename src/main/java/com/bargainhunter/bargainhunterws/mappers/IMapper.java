package com.bargainhunter.bargainhunterws.mappers;

public interface IMapper<S, T> {
    T map(S source, T target);
}
