package com.example.diplom3.service.models;

import com.example.diplom3.dto.StudentDto;
import com.example.diplom3.model.Student;
import com.example.diplom3.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository rep;
    public StudentServiceImpl (StudentRepository rep) {
        this.rep = rep;
    }

    @Override
    @Transactional
    public void save(Student student) {
    rep.save(student);
    }

    @Override
    @Transactional
    public StudentDto findById(Long id) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(rep.findById(id).get(), StudentDto.class);
    }
}
