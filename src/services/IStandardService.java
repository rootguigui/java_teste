package services;

import models.Family;

import java.util.ArrayList;

public interface IStandardService {
    ArrayList<Family> calculateAndOrderByPoints();
}
