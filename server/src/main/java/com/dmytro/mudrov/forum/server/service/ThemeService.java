package com.dmytro.mudrov.forum.server.service;

import com.dmytro.mudrov.forum.dto.theme.CreateThemeDTO;
import com.dmytro.mudrov.forum.dto.theme.RemoveThemeDTO;
import com.dmytro.mudrov.forum.server.dao.ThemeDao;
import com.dmytro.mudrov.forum.server.model.Theme;

public class ThemeService {

    private ThemeDao themeDao;
    private UserService userService;

    public Theme create(CreateThemeDTO createThemeDTO) {
        if (userService.findUser(createThemeDTO.getOwner()) == null) {
            throw new IllegalArgumentException("Invalid user id!");
        }
        Theme theme = createTheme(createThemeDTO);
        themeDao.save(theme);
        return theme;
    }

    public void remove(RemoveThemeDTO removeThemeDTO) {
        if (userService.findUser(removeThemeDTO.getRemoverId()) == null) {
            throw new IllegalArgumentException("Invalid user id!");
        }
        themeDao.remove(removeThemeDTO.getId());
    }

    public Theme findTheme(long id) {
        return themeDao.find(id);
    }


    private Theme createTheme(CreateThemeDTO createThemeDTO) {
        Theme theme = new Theme();
        theme.setName(createThemeDTO.getName());
        theme.setDescription(createThemeDTO.getDescription());
        theme.setOwner(createThemeDTO.getOwner());
        return theme;
    }

    public void setThemeDao(ThemeDao themeDao) {
        this.themeDao = themeDao;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
