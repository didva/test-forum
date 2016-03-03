package com.dmytro.mudrov.forum.server.controller.theme;

import com.dmytro.mudrov.forum.dto.theme.CreateThemeDTO;
import com.dmytro.mudrov.forum.dto.theme.CreateThemeResponseDTO;
import com.dmytro.mudrov.forum.server.controller.Controller;
import com.dmytro.mudrov.forum.server.model.Theme;
import com.dmytro.mudrov.forum.server.service.ThemeService;

public class CreateThemeController implements Controller<CreateThemeDTO> {

    private ThemeService themeService;

    public CreateThemeResponseDTO process(CreateThemeDTO data) {
        Theme theme = themeService.create(data);
        return createThemeResponse(theme);
    }

    private CreateThemeResponseDTO createThemeResponse(Theme theme) {
        CreateThemeResponseDTO response = new CreateThemeResponseDTO();
        response.setId(theme.getId());
        response.setName(theme.getName());
        response.setDescription(theme.getDescription());
        response.setOwner(theme.getOwner());
        return response;
    }

    public Class<CreateThemeDTO> getDTOClass() {
        return CreateThemeDTO.class;
    }

    public void setThemeService(ThemeService themeService) {
        this.themeService = themeService;
    }
}
