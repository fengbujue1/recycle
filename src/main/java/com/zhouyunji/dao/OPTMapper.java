package com.zhouyunji.dao;

import com.zhouyunji.bean.FormData;
import com.zhouyunji.bean.LoginData;
import com.zhouyunji.bean.MappingRelation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OPTMapper {
    LoginData selectUser(String userName);
    FormData selectFormData(String fileName);
    void insertData(FormData formData);
    void insertMappingRelation(MappingRelation mappingRelation);
}
