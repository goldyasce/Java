package ru.rzn.sbt.javaschool.exceptions;

import ru.rzn.sbt.javaschool.exceptions.utils.SomeService;

import java.io.FileNotFoundException;

public class SubClass extends SuperClass {
    @Override
    public String callService(SomeService service) throws FileNotFoundException {
        try{
            service.doSomething();
            return "DONE";
        }catch (FileNotFoundException fnfe){
            throw fnfe;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
