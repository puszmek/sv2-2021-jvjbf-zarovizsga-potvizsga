package students;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TeacherNotebook {

    public static final int AVERAGE_OF_GRADES_LIMIT = 2;

    private List<Student> students = new ArrayList<>();

    public void readFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                Student s = parseLine(line);
                students.add(s);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot open file for read!", ioe);
        }
    }

    private Student parseLine(String line) {
        String[] parts = line.split(";");
        Student actualStudent = new Student(parts[0], parts[1]);
        for (int i = 2; i < parts.length; i++) {
            actualStudent.addGrade(Integer.parseInt(parts[i]));
        }
        return actualStudent;
    }

    public List<String> findFailingStudents() {
        return students.stream()
                .filter(student -> student.getAverageOfGrades() < AVERAGE_OF_GRADES_LIMIT)
                .map(Student::getName)
                .toList();
    }

    public List<Student> getStudents() {
        return students;
    }
}
