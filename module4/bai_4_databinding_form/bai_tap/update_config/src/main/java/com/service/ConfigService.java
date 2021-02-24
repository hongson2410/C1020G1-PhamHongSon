package com.service;

import com.model.Config;

import java.util.List;

public interface ConfigService {
    List<Config> showAllConfig();
    Config showConfigById(int id);
    void saveConfig(Config config);
}
