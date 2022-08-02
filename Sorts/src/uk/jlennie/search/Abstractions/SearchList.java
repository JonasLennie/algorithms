package uk.jlennie.search.Abstractions;

import java.util.Optional;

public interface SearchList<T extends Comparable<T>> extends AbstractSearch<T, Optional<Integer>> {}
