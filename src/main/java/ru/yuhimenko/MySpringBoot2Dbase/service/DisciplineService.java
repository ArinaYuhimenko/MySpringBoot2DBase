package ru.yuhimenko.MySpringBoot2Dbase.service;

import org.springframework.stereotype.Service;
import ru.yuhimenko.MySpringBoot2Dbase.entity.Discipline;

import java.util.List;

@Service
public interface DisciplineService {
    List<Discipline> getAllDiscipline();

    Discipline saveDiscipline(Discipline discipline);

    Discipline getDiscipline(int id);

    void deleteDiscipline(int id);
}
