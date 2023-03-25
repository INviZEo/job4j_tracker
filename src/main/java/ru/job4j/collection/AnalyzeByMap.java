package ru.job4j.collection;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0D;
        int count = 0;
        for (Pupil i : pupils) {
            for (Subject j : i.subjects()) {
                rsl += j.score();
                count++;
            }
        }
        return rsl / (double) count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil i : pupils) {
            int count = 0;
            double sum = 0D;
            for (Subject j : i.subjects()) {
                if (j.name() != null) {
                    sum += j.score();
                    count++;
                }
            }
            Label label = new Label(i.name(), sum / (double) count);
            rsl.add(label);
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        for (Pupil subj : pupils)  {
            for (Subject j : subj.subjects()) {
                    linkedHashMap.put(j.name(), linkedHashMap.getOrDefault(j.name(), 0) + j.score());
            }
        }

        for (String i : linkedHashMap.keySet()) {
            rsl.add(new Label(i, linkedHashMap.get(i) / pupils.size()));
        }

        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil i : pupils) {
            double sum = 0D;
            for (Subject j : i.subjects()) {
                if (j.name() != null) {
                    sum += j.score();
                }
            }
            Label label = new Label(i.name(), sum);
            rsl.add(label);
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        for (Pupil subj : pupils)  {
            for (Subject j : subj.subjects()) {
                if (!linkedHashMap.containsKey(j.name())) {
                    linkedHashMap.put(j.name(), j.score());
                } else {
                    linkedHashMap.put(j.name(), linkedHashMap.get(j.name()) + j.score());
                }
            }
        }
        for (String i : linkedHashMap.keySet()) {
            rsl.add(new Label(i, linkedHashMap.get(i)));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }
}