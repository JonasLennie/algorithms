package uk.jlennie.search.Abstractions;

import java.util.List;

public interface AbstractSearch<T extends Comparable<T>, R> {
    R search(T target, List<T> listToSearch);
}

