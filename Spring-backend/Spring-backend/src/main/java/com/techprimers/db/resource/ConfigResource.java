package com.techprimers.db.resource;

import com.techprimers.db.entityManagerFactory.ConfigRepository;
import com.techprimers.db.model.Config;
import com.techprimers.db.model.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/config")
public class ConfigResource {

    @Autowired
    ConfigRepository configRepository;

    @RequestMapping(value = "/updateConfig", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultDTO updateConfig(@RequestBody Config dto) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setKey("SUCCESS");
        if (dto.getId() != null) {
            Config dtoConfig = configRepository.findOne(dto.getId());
            if (dto.getId() == null) {
                resultDTO.setKey("FAIL");
                return resultDTO;
            } else {
                dtoConfig.setConfig(dto.getConfig());
                configRepository.saveAndFlush(dtoConfig);
                resultDTO.setId(String.valueOf(dtoConfig.getId()));

            }
        }
        return resultDTO;
    }
}
