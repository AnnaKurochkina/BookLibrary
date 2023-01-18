package com.kurochkina.anna;

public interface Runnable<E extends Throwable> {
	void run() throws E;
}