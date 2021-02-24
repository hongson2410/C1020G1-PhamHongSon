package com.service.impl;

import com.model.Config;
import com.repository.ConfigRepository;
import com.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    ConfigRepository configRepository;

    @Override
    public List<Config> showAllConfig() {
        return configRepository.showAllConfig();
    }

    @Override
    public Config showConfigById(int id) {
        return configRepository.showConfigById(id);
    }

    @Override
    public void saveConfig(Config config) {
        configRepository.saveConfig(config);
    }
}
