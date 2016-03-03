package com.dmytro.mudrov.forum.server.controller.theme;

import com.dmytro.mudrov.forum.dto.general.GeneralResponseDTO;
import com.dmytro.mudrov.forum.dto.theme.RemoveThemeDTO;
import com.dmytro.mudrov.forum.server.controller.Controller;
import com.dmytro.mudrov.forum.server.service.ThemeService;

public class RemoveThemeController implements Controller<RemoveThemeDTO> {

    private ThemeService themeService;

    @Override
    public GeneralResponseDTO process(RemoveThemeDTO data) {
        themeService.remove(data);
        return new GeneralResponseDTO(true);
    }

    @Override
    public Class<RemoveThemeDTO> getDTOClass() {
        return RemoveThemeDTO.class;
    }

    public void setThemeService(ThemeService themeService) {
        this.themeService = themeService;
    }
}
