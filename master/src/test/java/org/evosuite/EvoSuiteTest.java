package org.evosuite;

import org.junit.Test;

import static org.junit.Assert.*;

public class EvoSuiteTest {

    @Test
    public void main() {
        EvoSuite.main(
                new String[]{
                        "-projectCP","C:\\Code\\Lab\\BugMiner\\test\\tested_projects\\MavenProj\\MavenProj\\sub_mod_1\\target\\classes;C:\\Code\\Lab\\BugMiner\\test\\tested_projects\\MavenProj\\MavenProj\\sub_mod_1\\target\\dependency",
                        "-class", "p_1.Amit",
                        "-Dassertion_strategy=ALL",
                        "-criterion",
                        "BRANCH:EXCEPTION:METHOD",
                        "-Dtest_dir=C:\\Code\\Lab\\BugMiner\\test\\tested_projects\\MavenProj\\MavenProj\\sub_mod_1\\.evosuite\\best-tests",
                        "-regressionSuite",
                        "-Dregressioncp=C:\\Code\\Lab\\BugMiner\\test\\tested_projects\\MavenProj\\regression\\MavenProj\\sub_mod_1\\target\\classes;C:\\Code\\Lab\\BugMiner\\test\\tested_projects\\MavenProj\\regression\\MavenProj\\sub_mod_1\\target\\dependency",
                        "-Dregression_fitness=ALL_MEASURES",
                        "-seed=3333333",
                        "-Ddebug=true"
                }
        );
    }
}