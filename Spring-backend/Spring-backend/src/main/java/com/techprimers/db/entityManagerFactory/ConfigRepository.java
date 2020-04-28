package com.techprimers.db.entityManagerFactory;

import com.techprimers.db.model.Config;
import com.techprimers.db.model.ResultDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<Config, Integer>{

//    ResultDTO updateConfig(Config config);
}
