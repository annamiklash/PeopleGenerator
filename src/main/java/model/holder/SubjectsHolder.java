package model.holder;

import lombok.Getter;
import model.Subject;

import java.util.HashSet;
import java.util.Set;

@Getter
public class SubjectsHolder {

    private static Set<Subject> subjectSet = new HashSet<>();

    public static void addSubject(Subject subject) {
        subjectSet.add(subject);
    }

}
