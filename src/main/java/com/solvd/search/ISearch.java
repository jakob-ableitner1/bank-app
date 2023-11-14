package com.solvd.search;

import com.solvd.exception.SearchTypeException;
import com.solvd.profile.Profile;

import java.util.Set;

public interface ISearch<T> {
    T[] search(Set<T> valuesToSearch, String[] searchValues, String searchType) throws SearchTypeException;
}
