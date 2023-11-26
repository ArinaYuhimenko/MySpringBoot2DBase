package ru.yuhimenko.MySpringBoot2Dbase.dao;

import org.springframework.stereotype.Repository;
import ru.yuhimenko.MySpringBoot2Dbase.entity.Discipline;

import java.util.List;

@Repository
public interface DisciplineDAO {
    List<Discipline> getAllDisciplines();

    Discipline saveDiscipline(Discipline discipline);

    Discipline getDiscipline(int id);

    void deleteDiscipline(int id);
}
