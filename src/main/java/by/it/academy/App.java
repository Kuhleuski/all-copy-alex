package by.it.academy;


import by.it.academy.embed.Person;
import by.it.academy.entity.HomeTask;
import by.it.academy.entity.Task;
import by.it.academy.entity.WorkTask;
import by.it.academy.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        createTaskTable();
        HibernateUtil.close();
    }

    public static void createTaskTable(){
        EntityManager entityManager = HibernateUtil.getEntityManager();

        Person executorPerson = Person.builder()
                .name("Ivan")
                .surname("Ivanov")
                .build();

        Person lookingPerson = Person.builder()
                .name("Petr")
                .surname("Petrov")
                .build();

        HomeTask homeTask = HomeTask.builder()
                .name("Home task")
                .description("Some home task description")
                .executor(executorPerson)
                .looking(lookingPerson)
                .startDate(LocalDate.of(1999,9,20))
                .endDate(LocalDate.of(2000,2,25))
                .build();

        Task task = Task.builder()
                .name("Task")
                .description("Some task description")
                .build();

        WorkTask workTask = WorkTask.builder()
                .name("Work task")
                .description("Some work task description")
                .cost(2200.0).build();

        entityManager.getTransaction().begin();
        entityManager.persist(homeTask);
        entityManager.persist(task);
        entityManager.persist(workTask);
        entityManager.getTransaction().commit();
    }

}