package com.sky.unittest.unit;

import com.sky.test.unit.UnitDemo1;
import org.junit.Assert;
import org.junit.Test;

public class UnitDemo1Test {

    @Test
    public void addTest(){
        int i = UnitDemo1.Add(1, 2);
        Assert.assertEquals(3, i);
    }
}
