package com.dmytro.mudrov.forum.server.dao;

import com.dmytro.mudrov.forum.server.model.Theme;

public interface ThemeDao {

    long save(Theme theme);

    void remove(long id);

    Theme find(long id);

}
