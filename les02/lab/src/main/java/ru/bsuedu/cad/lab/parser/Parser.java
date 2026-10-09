package ru.bsuedu.cad.lab.parser;

import java.util.List;

public interface Parser<T> {
    List<T> parse(List<String[]> rawData);
}