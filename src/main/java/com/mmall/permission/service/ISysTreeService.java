package com.mmall.permission.service;

import com.google.common.collect.Multimap;
import com.mmall.permission.dto.AclDto;
import com.mmall.permission.dto.AclModuleLevelDto;
import com.mmall.permission.dto.DeptLevelDto;

import java.util.List;

public interface ISysTreeService {

    List<AclModuleLevelDto> userAclTree(int userId);

    List<AclModuleLevelDto> roleTree(int roleId);

    List<AclModuleLevelDto> aclListToTree(List<AclDto> aclDtoList);

    void bindAclsWithOrder(List<AclModuleLevelDto> aclModuleLevelList, Multimap<Integer, AclDto> moduleIdAclMap);

    List<AclModuleLevelDto> aclModuleTree();

    List<AclModuleLevelDto> aclModuleListToTree(List<AclModuleLevelDto> dtoList);

    void transformAclModuleTree(List<AclModuleLevelDto> dtoList, String level, Multimap<String, AclModuleLevelDto> levelAclModuleMap);

    List<DeptLevelDto> deptTree();

    List<DeptLevelDto> deptListToTree(List<DeptLevelDto> deptLevelList);

    void transformDeptTree(List<DeptLevelDto> deptLevelList, String level, Multimap<String, DeptLevelDto> levelDeptMap);


}
