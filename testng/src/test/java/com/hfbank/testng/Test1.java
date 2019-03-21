package com.hfbank.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class Test1 
{
    /**
     * Rigorous Test :-)
     */
	@Parameters({"include"})
    @Test(groups={"Test1","all"})
    public void shouldAnswerWithTrue(String  s)
    {
        System.out.println("$$$$$$:test-1"+s);
    }
}
