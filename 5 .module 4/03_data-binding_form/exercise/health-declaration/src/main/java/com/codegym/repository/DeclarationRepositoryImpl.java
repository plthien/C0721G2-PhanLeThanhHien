package com.codegym.repository;

import com.codegym.model.Declaration;

import java.util.HashMap;
import java.util.Map;

public class DeclarationRepositoryImpl implements IDeclarationRepository {

    private static Map<Integer, Declaration> declarationMap = new HashMap<>();

    static {
        declarationMap.put(1,new Declaration(1,"Hien","1995-04-05","Male","Việt Nam","201710944","Tàu bay","VN123","B12",
                "2021-11-15","2021-11-20","Da Nang","Da Nang","Son Tra","Man Thai","Số 58 Nguyễn Trọng Nghĩa","0794197483",
                "plthienbkdn@gmail.com",false,false,false,false,false,false,false,false,false,false));
    }

    
}
