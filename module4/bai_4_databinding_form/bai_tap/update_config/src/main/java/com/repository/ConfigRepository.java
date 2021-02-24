package com.repository;

import com.model.Config;

import java.util.List;

public interface ConfigRepository {

    List<Config> showAllConfig();
    Config showConfigById(int id);
    void saveConfig(Config config);
}
