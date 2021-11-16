package com.codegym.service;

import com.codegym.model.Declaration;
import com.codegym.repository.IDeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "declarationServiceImpl")
public class DeclarationServiceImpl implements IDeclarationService {

    @Qualifier("declarationRepositoryImpl")
    @Autowired
    private IDeclarationRepository iDeclarationRepository;

    @Override
    public void saveDeclaration(Declaration declaration) {
        iDeclarationRepository.saveDeclaration(declaration);
    }

    @Override
    public Declaration findByIdCard(String idCard) {
        return iDeclarationRepository.findByIdCard(idCard);
    }
}
