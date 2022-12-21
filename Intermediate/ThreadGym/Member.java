package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Member {
    private final int id;

    public Member(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public List<Exercise> generateRoutine() {
        return IntStream.range(0, 6).mapToObj(_i -> new Exercise()).collect(Collectors.toList());
    }

    public void performRoutine() throws InterruptedException {
        List<Exercise> routine = generateRoutine();

        routine.forEach(exercise -> {
            System.out.println("Gym Member " + this.getId() + " performing exercise: " + exercise);
            try {
                Thread.sleep(exercise.getDuration());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        });
    }

    /*private Thread createSupervisor(List<Thread> threads) {
        Thread supervisor = new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(1000);
                    List<String> runningThreads = threads.stream().filter(Thread::isAlive).map(Thread::getName).collect(Collectors.toList());
                    System.out.println(Thread.currentThread().getName()+"-" + runningThreads.size() + "members currently excersing" + runningThreads+ "\n");
                    if (runningThreads == null) {
                        break;
                    }
                }catch(InterruptedException e) {
                    System.out.println("There is an error ");
                }
            }
            System.out.println(Thread.currentThread().getName() + " - All members are finished exercising!");

        });
        supervisor.setName("Gym Staff");
        return supervisor;
    }*/
}