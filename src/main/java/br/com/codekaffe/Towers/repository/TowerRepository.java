package br.com.codekaffe.Towers.repository;

import br.com.codekaffe.Towers.models.Tower;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TowerRepository extends MongoRepository<Tower,String> {
    Tower getTowerById(String id);
}
