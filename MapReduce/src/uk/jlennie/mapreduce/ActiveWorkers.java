package uk.jlennie.mapreduce;

import java.util.ArrayList;
import java.util.List;

public class ActiveWorkers {
    List<Worker> workers;

    public ActiveWorkers() {
        workers = new ArrayList<>();
    }

    public void addWorker(Worker newWorker) throws IDException {
        throwIfNewWorkerIDNotUnique(newWorker);

        workers.add(newWorker);
    }

    private void throwIfNewWorkerIDNotUnique(Worker newWorker) throws IDException {
        for (Worker worker : workers) {
            checkForIDConflictBetweenWorkers(newWorker, worker);
        }
    }

    private void checkForIDConflictBetweenWorkers(Worker newWorker, Worker worker) throws IDException {
        if (worker.getId() == newWorker.getId())
            ThrowIDException();
    }

    private void ThrowIDException() throws IDException {
        throw new IDException("Worker ID: tried to add two workers with the same ID");
    }

    public List<Worker> getWorkerList() {
        return new ArrayList<>(workers);
    }

    public void deleteWorker(int idToDelete) throws IDException {
        boolean removedWorker = attemptWorkerRemoval(idToDelete);

        throwExceptionIfNoWorkerRemoved(idToDelete, removedWorker);
    }

    private void throwExceptionIfNoWorkerRemoved(int idToDelete, boolean removedWorker) throws IDException {
        if (!removedWorker)
            throw new IDException("Worker ID: Failed to remove worker with ID " + idToDelete);
    }

    private boolean attemptWorkerRemoval(int idToDelete) {
        return workers.removeIf(w -> w.getId() == idToDelete);
    }

}
