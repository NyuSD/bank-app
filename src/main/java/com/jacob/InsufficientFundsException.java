package com.jacob;

/** Thrown when a withdrawal would drive the balance below zero. */
public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String msg) { super(msg); }
}
