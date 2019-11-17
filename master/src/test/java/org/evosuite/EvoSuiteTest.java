package org.evosuite;

import org.junit.Test;

import static org.junit.Assert.*;

public class EvoSuiteTest {

    @Test
    public void main() {
        EvoSuite.main(
                new String[]{
                        "-projectCP","C:\\Users\\amirelm\\Code\\rotem\\BugMiner\\test\\tested_projects\\MavenProj\\MavenProj\\sub_mod_1\\target\\classes;C:\\Users\\amirelm\\Code\\rotem\\BugMiner\\test\\tested_projects\\MavenProj\\MavenProj\\sub_mod_1\\target\\dependency",
                        "-class", "p_1.Amit",
                        "-Dassertion_strategy=ALL",
                        "-criterion",
                        "BRANCH:EXCEPTION:METHOD",
                        "-Dtest_dir=C:\\Users\\amirelm\\Code\\rotem\\BugMiner\\test\\tested_projects\\MavenProj\\MavenProj\\sub_mod_1\\.evosuite\\best-tests",
                        "-regressionSuite",
                        "-Dregressioncp='..\\regression\\MavenProj\\sub_mod_1\\target\\classes;..\\regression\\MavenProj\\sub_mod_1\\target\\dependency'",
                        "-Dregression_fitness=ALL_MEASURES",
                        "-seed=3333333",
                        "-Ddebug=true"
                }
        );
    }
}