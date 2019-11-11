package com.sample.cnb;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;
import com.sample.cnb.runner.Runner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunnerTest {
    private final static Logger logger = LoggerFactory.getLogger(RunnerTest.class);
    private Runner runner;
    @Before
    public void initialize(){
        runner = new Runner();
    }
    
    @Test
    public void Test1979_1000() {
        logger.info("Test 1979");
        runner.init("date_1000.txt");

        //IntStream.range(0, 10).forEach(o -> runner.extracted("cust", 1979, 2025));
        IntStream.range(0, 10).forEach(o -> runner.extracted("opti", 1979, 2025));
        //IntStream.range(0, 1).forEach(o -> runner.extracted("rdht", 1979, 2025));

    }

    /*
     * IntStream.range(0, nbExec).forEach(o -> extracted(inputData, kContainer,
     * "cust", 0)); IntStream.range(0, nbExec).forEach(o -> extracted(inputData,
     * kContainer, "rdht", 0)); IntStream.range(0, nbExec).forEach(o ->
     * extracted(inputData, kContainer, "opti", 0));
     * 
     * String inputData2 = Files.readString(new File("date_100000.txt").toPath());
     * 
     * IntStream.range(0, nbExec).forEach(o -> extracted(inputData2, kContainer,
     * "cust", 1979)); IntStream.range(0, nbExec).forEach(o -> extracted(inputData2,
     * kContainer, "rdht", 1979)); IntStream.range(0, nbExec).forEach(o ->
     * extracted(inputData2, kContainer, "opti", 1979));
     * 
     * IntStream.range(0, nbExec).forEach(o -> extracted(inputData2, kContainer,
     * "cust", 1300)); IntStream.range(0, nbExec).forEach(o -> extracted(inputData2,
     * kContainer, "rdht", 1300)); IntStream.range(0, nbExec).forEach(o ->
     * extracted(inputData2, kContainer, "opti", 1300));
     */
}
