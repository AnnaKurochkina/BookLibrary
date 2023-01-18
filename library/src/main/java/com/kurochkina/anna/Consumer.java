package com.kurochkina.anna;

public interface Consumer<T, E extends Throwable> {
	void accept(T argument) throws E;
}