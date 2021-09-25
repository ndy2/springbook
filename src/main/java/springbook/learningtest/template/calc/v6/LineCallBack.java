package springbook.learningtest.template.calc.v6;

public interface LineCallBack<T> {
    T doSomethingWithLine(String line, T value);
}
