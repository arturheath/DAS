package com.example.das.gof.structural;

import java.util.ArrayList;
import java.util.List;

public class Composite {
    interface Member {
        void performDuty();
    }

    static class Employee implements Member {
        public void performDuty() {
            System.out.println("Employee performing a duty.");
        }
    }

    static class Department implements Member {
        private List<Member> members = new ArrayList<>();

        public void addMember(Member member) {
            members.add(member);
        }

        public void performDuty() {
            members.forEach(Member::performDuty);
        }
    }

    public static void main(String[] args) {
        Department department = new Department();
        department.addMember(new Employee());
        department.addMember(new Employee());

        department.performDuty(); // Delegates duty to each member
    }
}
