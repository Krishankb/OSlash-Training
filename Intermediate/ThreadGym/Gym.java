package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Gym {
    private final int totalGymMemebers;
    private Map<MachineType, Integer> availableMachines;

    public Gym(int totalGymMemebers, Map<MachineType, Integer> availableMachines) {
        this.totalGymMemebers = totalGymMemebers;
        this.availableMachines = availableMachines;
    }

    public static void main(String[] args) {
        Gym globalgym = new Gym(5,new HashMap<>() {
            {
                put(MachineType.LEGPRESSMACHINE,5);
                put(MachineType.BARBELL,5);
                put(MachineType.SQUATMACHINE,5);
                put(MachineType.LEGEXTENSIONMACHINE,5);
                put(MachineType.LEGCURLMACHINE,5);
                put(MachineType.LATPULLDOWNMACHINE,5);
                put(MachineType.CABLECROSSOVERMACHINE,5);
            }
        });
        globalgym.openForTheDay();
    }



    public void openForTheDay() {
        //List gymMembersRoutines;
        List <Thread> gymMembersRoutines = (List<Thread>) IntStream.rangeClosed(1,this.totalGymMemebers).mapToObj((id) -> {Member member = new Member(id); return new Thread(() -> {try {
            member.performRoutine();

        } catch (Exception e) {
            System.out.println("There was an error in the return thread");
        }});}).collect(Collectors.toList());
        //gymMembersRoutines.forEach((t) -> t.start());
        gymMembersRoutines.forEach(Thread::start);
        Thread supervisor = createSupervisor(gymMembersRoutines);
        supervisor.start();
    }

    private Thread createSupervisor(List<Thread> threads) {
        Thread supervisor = new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(1000);
                    List<String> runningThreads = threads.stream().filter(Thread::isAlive).map(Thread::getName).collect(Collectors.toList());
                    System.out.println(Thread.currentThread().getName()+"-" + runningThreads.size() + "members currently excersing" + runningThreads+ "\n");
                    if (runningThreads.isEmpty()) {
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
    }


}
