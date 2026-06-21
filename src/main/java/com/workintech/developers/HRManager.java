package com.workintech.developers;

public class HRManager extends Employee {
    private JuniorDeveloper[] juniorDevelopers;
    private MidDeveloper[] midDevelopers;
    private SeniorDeveloper[] seniorDevelopers;

    public HRManager(int id, String name, double salary) {
        super(id, name, salary);
        this.juniorDevelopers = new JuniorDeveloper[10];
        this.midDevelopers = new MidDeveloper[10];
        this.seniorDevelopers = new SeniorDeveloper[10];
    }

    public JuniorDeveloper[] getJuniorDevelopers() {
        return juniorDevelopers;
    }

    public MidDeveloper[] getMidDevelopers() {
        return midDevelopers;
    }

    public SeniorDeveloper[] getSeniorDevelopers() {
        return seniorDevelopers;
    }

    @Override
    public void work() {
        System.out.println("HRManager starts to working");
        setSalary(getSalary() + 1500);
    }

    public void addEmployee(JuniorDeveloper juniorDeveloper) {
        addEmployee(juniorDeveloper, firstAvailableIndex(juniorDevelopers));
    }

    public void addEmployee(MidDeveloper midDeveloper) {
        addEmployee(midDeveloper, firstAvailableIndex(midDevelopers));
    }

    public void addEmployee(SeniorDeveloper seniorDeveloper) {
        addEmployee(seniorDeveloper, firstAvailableIndex(seniorDevelopers));
    }

    public void addEmployee(JuniorDeveloper juniorDeveloper, int index) {
        addAtIndex(juniorDevelopers, juniorDeveloper, index);
    }

    public void addEmployee(MidDeveloper midDeveloper, int index) {
        addAtIndex(midDevelopers, midDeveloper, index);
    }

    public void addEmployee(SeniorDeveloper seniorDeveloper, int index) {
        addAtIndex(seniorDevelopers, seniorDeveloper, index);
    }

    private int firstAvailableIndex(Object[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private <T> void addAtIndex(T[] employees, T employee, int index) {
        if (index < 0 || index >= employees.length) {
            System.out.println("Invalid index");
            return;
        }
        if (employees[index] != null) {
            System.out.println("Index is already occupied");
            return;
        }
        employees[index] = employee;
    }
}
