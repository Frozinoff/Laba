import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class TVProgram {
    String name;
    String time;

    public TVProgram(String name, String time) {
        this.name = name;
        this.time = time;
    }
}

class ChildrenProgram extends TVProgram {
    int minAge;
    int maxAge;

    public ChildrenProgram(String name, String time, int minAge, int maxAge) {
        super(name, time);
        this.minAge = minAge;
        this.maxAge = maxAge;
    }
}

class Movie extends TVProgram {
    String description;
    int year;

    public Movie(String name, String time, String description, int year) {
        super(name, time);
        this.description = description;
        this.year = year;
    }
}

class TVProgramList {
    List<TVProgram> programs;

    public TVProgramList() {
        programs = new ArrayList<>();
    }

    public void addProgram(TVProgram program) {
        programs.add(program);
    }

    public void printPrograms() {
        for (TVProgram program : programs) {
            if (program instanceof ChildrenProgram) {
                ChildrenProgram childrenProgram = (ChildrenProgram) program;
                System.out.println(childrenProgram.name + " Время: " + childrenProgram.time +
                        " Минимальный возраст: " + childrenProgram.minAge + " Максимальный возраст: " + childrenProgram.maxAge);
            } else if (program instanceof Movie) {
                Movie movie = (Movie) program;
                System.out.println(movie.name + " Время: " + movie.time +
                        " Описание: " + movie.description + " Год выхода: " + movie.year);
            } else {
                System.out.println(program.name + " Время: " + program.time);
            }
        }
    }

    public void sortByName() {
        Collections.sort(programs, Comparator.comparing(p -> p.name));
    }

    public void sortByTime() {
        Collections.sort(programs, Comparator.comparing(p -> p.time));
    }
}

public class Main {
    public static void main(String[] args) {
        TVProgramList programList = new TVProgramList();

        ChildrenProgram childrenProgram = new ChildrenProgram("Час мультфильмов", "08:00", 3, 10);
        programList.addProgram(childrenProgram);

        Movie movie = new Movie("Боевик", "22:00", "Боевик с экшеном", 2023);
        programList.addProgram(movie);

        System.out.println("Неотсортированные программы:");
        programList.printPrograms();

        programList.sortByName();
        System.out.println("\nОтсортированные по наименованию:");
        programList.printPrograms();

        programList.sortByTime();
        System.out.println("\nОтсортированные по времени:");
        programList.printPrograms();
    }
}
