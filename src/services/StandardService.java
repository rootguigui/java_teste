package services;

import models.Family;
import repositories.FamilyRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StandardService implements IStandardService {
    private static FamilyRepository repository;

    public StandardService() {
        repository = new FamilyRepository();
    }
    public ArrayList<Family> calculateAndOrderByPoints() {
        ArrayList<Family> families = repository.get();

        for (Family family: families) {
            if (family.getMembers().size() != 0) {
                this.salaryLessthenQuantity(900, 5, family);
                this.salaryBetweenRange(901, 1500, 3, family);
                this.checkNumberOfDepedent(family);
            }
        }

        families.sort(Comparator.comparingInt(Family::getPoints));
        Collections.reverse(families);

        return families;
    }

    private void salaryLessthenQuantity(double quantity, int points, Family family) {
        double salaryPerFamily = repository.getTotalSalary(family.getId());

        if (salaryPerFamily <= quantity) family.addPoints(points);
    }

    private void salaryBetweenRange(double min, double max, int points, Family family) {
        double salaryPerFamily = repository.getTotalSalary(family.getId());

        if (salaryPerFamily > min && salaryPerFamily <= max) family.addPoints(points);
    }

    private void checkNumberOfDepedent(Family family) {
        long dependentPerFamily = repository.getTotalDependent(family.getId());

        if (dependentPerFamily <= 2) family.addPoints(5);
        if (dependentPerFamily >= 3) family.addPoints(3);
    }
}
