package ru.job4j.collection;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    public void jobAscByName() {
        Job job0 = new Job("Slesar", 0);
        Job job1 = new Job("Mechanic", 1);
        Job job2 = new Job("Programmist", 2);
        List<Job> jobs = Arrays.asList(job0, job1, job2);
        Collections.sort(jobs, new JobAscByName());
        List<Job> expected = Arrays.asList(job1, job2, job0);
        Assert.assertEquals(jobs, expected);
    }

    @Test
    public void jobDescByName() {
        Job job0 = new Job("Slesar", 0);
        Job job1 = new Job("Mechanic", 1);
        Job job2 = new Job("Programmist", 2);
        List<Job> jobs = Arrays.asList(job0, job1, job2);
        Collections.sort(jobs, new JobDescByName());
        List<Job> expected = Arrays.asList(job0, job2, job1);
        Assert.assertEquals(jobs, expected);
    }

    @Test
    public void jobAscByPriority() {
        Job job0 = new Job("Slesar", 0);
        Job job1 = new Job("Mechanic", 1);
        Job job2 = new Job("Programmist", 2);
        List<Job> jobs = Arrays.asList(job0, job1, job2);
        Collections.sort(jobs, new JobAscByPriority());
        List<Job> expected = Arrays.asList(job0, job1, job2);
        Assert.assertEquals(jobs, expected);
    }

    @Test
    public void jobDescByPriority() {
        Job job0 = new Job("Slesar", 0);
        Job job1 = new Job("Mechanic", 1);
        Job job2 = new Job("Programmist", 2);
        List<Job> jobs = Arrays.asList(job0, job1, job2);
        Collections.sort(jobs, new JobDescByPriority());
        List<Job> expected = Arrays.asList(job2, job1, job0);
        Assert.assertEquals(jobs, expected);
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 0)

        );
        assertThat(rsl).isLessThan(0);
    }
}