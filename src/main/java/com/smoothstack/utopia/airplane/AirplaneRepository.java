package com.smoothstack.utopia.airplane;

import org.springframework.data.repository.CrudRepository;

public interface AirplaneRepository extends CrudRepository<Airplane, Integer> {
    Airplane findById(int id);
}