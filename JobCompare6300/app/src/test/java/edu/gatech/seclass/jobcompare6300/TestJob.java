package edu.gatech.seclass.jobcompare6300;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJob {
    @Test
    public void calScore01() {
        Weights weights = new Weights();
        Job job = new Job("Engineer", "Apple", "Atlanta", "GA",
                "100", "100000", "10000",
                "4", "20", "10", true, weights);
        assertEquals(22804.4, job.getJobRankScore(),1);
    }

    @Test
    public void calScore02() {
        Weights weights = new Weights("5", "4", "3",
                "2", "1");
        Job job = new Job("Engineer", "Apple", "Atlanta", "GA",
                "100", "100000", "10000",
                "4", "20", "10", false, weights);
        assertEquals(36537.46666666667, job.getJobRankScore(),1);
    }
}
