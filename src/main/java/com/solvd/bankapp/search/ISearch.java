package com.solvd.bankapp.search;

import java.util.List;
import java.util.Set;

public interface ISearch<T> {
    List<T> search(Set<T> valuesToSearch, String[] searchValues, String searchType);
}
