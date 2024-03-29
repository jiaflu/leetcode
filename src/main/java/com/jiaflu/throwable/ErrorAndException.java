package com.jiaflu.throwable;

import java.io.FileNotFoundException;

public class ErrorAndException {
    private void throwError() {
        throw new StackOverflowError();
    }

    private void throwRuntimeException() {
        throw new RuntimeException();
    }

    private void throwCheckedException() throws FileNotFoundException{
        throw new FileNotFoundException();
    }

    public static void main(String[] args) {
        ErrorAndException eae = new ErrorAndException();
        eae.throwError();
        eae.throwRuntimeException();
        try {
            eae.throwCheckedException();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
