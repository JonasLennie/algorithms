package uk.jlennie.mapreduce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActiveWorkersTest {
    ActiveWorkers sut;
    Worker testWorker;
    Worker copyWorker;

    @BeforeEach
    void setUp() {
        sut = new ActiveWorkers();
        testWorker = new Worker(1);
        copyWorker = new Worker(1);
    }

    @Test
    void addWorkerThrowSameID() {
        assertDoesNotThrow(() -> sut.addWorker(testWorker));

        assertThrows(IDException.class, () -> sut.addWorker(copyWorker));
    }

    @Test
    void addWorkerSameIDListUnique() throws IDException {
        sut.addWorker(testWorker);

        try {
            sut.addWorker(copyWorker);
            fail();
        } catch (IDException e) {
            assertArrayEquals(sut.getWorkerList().toArray(new Worker[0]), new Worker[]{testWorker});
        }
    }

    @Test
    void addWorkerSameIDDeleteStillWorks() {
        try {
            sut.addWorker(testWorker);
        } catch (IDException e) {
            fail();
        }

        try {
            sut.addWorker(copyWorker);
            fail();
        } catch (IDException e) {
            assertDoesNotThrow(() -> sut.deleteWorker(copyWorker.getId()));
        }

    }

    @Test
    void getWorkerList() {
    }

    @Test
    void deleteWorker() {
    }
}