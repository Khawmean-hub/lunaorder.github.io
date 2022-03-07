package com.kosign.luna.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ApiMapperUtile {

    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
