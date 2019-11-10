package org.evosuite.rrt;

import org.evosuite.testcase.execution.ExecutionResult;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class TestResultZip {
    ExecutionResult orig;
    ExecutionResult buggy;

    public static List<TestResultZip> create(List<ExecutionResult> origs, List<ExecutionResult> buggys){
        throw new NotImplementedException();
    }

    private TestResultZip(ExecutionResult orig, ExecutionResult buggy) {
        this.orig = orig;
        this.buggy = buggy;
    }

    public boolean isBugProvern() {
        throw new NotImplementedException();
    }
}

