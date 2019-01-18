package com.example.demo.service;

/**
 * Created by fangjing on 2019/1/16.
 */
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.example.demo.domain.NameEntity;

@Service
public class NameService {

    public List<NameEntity> findAll()
    {
        List<NameEntity> nameEntities = new ArrayList<>();
        nameEntities.add(new NameEntity("test1", "a", 12));
        nameEntities.add(new NameEntity("test2", "b", 12));
        nameEntities.add(new NameEntity("test3", "c", 12));
        return nameEntities;
    }

    public void findByname(String name)
    {
        List<NameEntity> nameEntities = new ArrayList<>();
        nameEntities.add(new NameEntity("test1", "a", 12));
        nameEntities.add(new NameEntity("test2", "b", 12));
        nameEntities.add(new NameEntity("test3", "c", 12));
    }

}
