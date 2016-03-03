package com.dmytro.mudrov.forum.server.dao.inmemmory;

import com.dmytro.mudrov.forum.server.dao.ThemeDao;
import com.dmytro.mudrov.forum.server.model.Theme;

import java.util.HashMap;
import java.util.Map;

public class ThemeDaoImpl implements ThemeDao {

    private static long id = 0;
    private Map<Long, Theme> themeMap = new HashMap<>();

    @Override
    public synchronized long save(Theme theme) {
        if (theme.getId() == 0) {
            theme.setId(++id);
        }
        themeMap.put(theme.getId(), theme);
        return theme.getId();
    }

    @Override
    public synchronized void remove(long id) {
        themeMap.remove(id);
    }

    @Override
    public Theme find(long id) {
        return themeMap.get(id);
    }
}
