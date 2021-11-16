package com.codegym.repository;

import com.codegym.model.Declaration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository(value = "declarationRepositoryImpl")
public class DeclarationRepositoryImpl implements IDeclarationRepository {

    private static List<Declaration> declarationList = new ArrayList<>();

    static {
        declarationList.add(new Declaration("Hien","1995-04-05","Male","Việt Nam","201710944","Tàu bay","VN123","B12",
                "2021-11-15","2021-11-20","Da Nang","Da Nang","Son Tra","Man Thai","Số 58 Nguyễn Trọng Nghĩa","0794197483",
                "plthienbkdn@gmail.com",false,false,false,false,false,false,false,false,false,false));
    }

    public void saveDeclaration(Declaration declaration){
        declarationList.add(declaration);
    }

    public Declaration findByIdCard(String idCard){
        for (int i = 0; i < declarationList.size() ; i++) {
            if (declarationList.get(i).getIdCard().equals(idCard)){
                return declarationList.get(i);
            }
        }
        return null;
    }

    
}
