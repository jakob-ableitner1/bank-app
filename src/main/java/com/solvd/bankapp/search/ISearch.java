package com.solvd.bankapp.search;

import java.util.List;
import java.util.Set;

public interface ISearch<T> {
    T search(Set<T> valuesToSearch, String searchValue, String searchType);
}
