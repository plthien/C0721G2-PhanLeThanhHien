package com.codegym.service;

import com.codegym.model.Declaration;

public interface IDeclarationService {
    void saveDeclaration(Declaration declaration);
    Declaration findByIdCard(String idCard);

}
