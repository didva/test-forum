package com.dmytro.mudrov.forum.server.controller;

import com.dmytro.mudrov.forum.dto.general.BaseDTO;
import com.dmytro.mudrov.forum.dto.general.BaseResponseDTO;

public interface Controller<T extends BaseDTO> {

    BaseResponseDTO process(T data);

    Class<T> getDTOClass();

}
