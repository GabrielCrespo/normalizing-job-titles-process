package br.com.gc.oop.service;

import java.util.List;
import java.util.Objects;

public class Normaliser {

    private final List<String> jobs = List.of(
            "Architect",
            "Software engineer",
            "Quantity surveyor",
            "Accountant"
    );

    public String normalise(String jt) {

        Objects.requireNonNull(jt, "Job title must no be null");

        if (jt.isBlank() || jt.isEmpty()) {
            throw new IllegalArgumentException("Job title must no be blank or empty");
        }

        String jobTitle = jobs.get(0);
        int matchDistance = jt.length() - distance(jt, jobTitle);

        for (int i = 1; i < jobs.size(); i++)  {

            int currentDistance = jt.length() - distance(jt, jobs.get(i));

            if (currentDistance > matchDistance) {
                jobTitle = jobs.get(i);
                matchDistance = currentDistance;
            }

        }

        return jobTitle;
    }

    private int distance(String a, String b) {

        a = a.toLowerCase();
        b = b.toLowerCase();

        int [] costs = new int [b.length() + 1];

        for (int i = 0; i < costs.length; i++) {
            costs[i] = i;
        }

        for (int i = 1; i <= a.length(); i++) {

            costs[0] = i;
            int nw = i - 1;

            for (int j = 1; j <= b.length(); j++) {

                char m = a.charAt(i - 1);
                char n = b.charAt(j - 1);

                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]),
                        m == n ? nw : nw + 1);

                nw = costs[j];
                costs[j] = cj;
            }
        }

        return costs[b.length()];
    }

}