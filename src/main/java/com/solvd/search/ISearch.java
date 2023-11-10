package com.solvd.search;

import com.solvd.exception.SearchTypeException;
import com.solvd.profile.Profile;

public interface ISearch<T> {
    T[] search(T[] valuesToSearch, String[] searchValues, String searchType) throws SearchTypeException;
}
