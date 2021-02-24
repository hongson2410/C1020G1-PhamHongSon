package com.repository.impl;

import com.model.Config;
import com.repository.ConfigRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConfigRepositoryImpl implements ConfigRepository {
    private static List<Config> configList;

    static {
        configList = new ArrayList<>();
        Config config_1 = new Config();
        config_1.setIdConfig(1);
        config_1.setConfigName("config-1");
        config_1.setLanguages("English");
        config_1.setPageSize(5);
        config_1.setSpamsFilter(true);
        config_1.setSignature("Thor");
        configList.add(config_1);

        Config config_2 = new Config();
        config_2.setIdConfig(2);
        config_2.setConfigName("config-2");
        config_2.setLanguages("Japanese");
        config_2.setPageSize(10);
        config_2.setSpamsFilter(true);
        config_2.setSignature("Iron Man");
        configList.add(config_2);

        Config config_3 = new Config();
        config_3.setIdConfig(3);
        config_3.setConfigName("config-3");
        config_3.setLanguages("Vietnamese");
        config_3.setPageSize(100);
        config_3.setSpamsFilter(false);
        config_3.setSignature("Ninja Lead");
        configList.add(config_3);
    }

    @Override
    public List<Config> showAllConfig() {
        return configList;
    }

    @Override
    public Config showConfigById(int id) {
        Config config = null;
        for (Config config1 : configList) {
            if (id == config1.getIdConfig()) {
                config = config1;
            }
        }
        return config;
    }

    @Override
    public void saveConfig(Config config) {
        for (int index = 0; index < configList.size(); index++) {
            if (configList.get(index).getIdConfig() == config.getIdConfig()) {
                configList.set(index, config);
            }
        }
    }
}
