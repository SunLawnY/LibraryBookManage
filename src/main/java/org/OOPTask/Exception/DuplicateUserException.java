package org.OOPTask.Exception;

public class DuplicateUserException extends Exception{
    public DuplicateUserException(){
        super("User already exisit");
    }
}
