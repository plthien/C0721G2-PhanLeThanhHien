package com.codegym.repository;

import com.codegym.model.Declaration;

public interface IDeclarationRepository {

     void saveDeclaration(Declaration declaration);
     Declaration findByIdCard(String idCard);


}
