package com.mmall.permission.service;

import com.mmall.permission.param.DeptParam;

public interface ISysDeptService {

    void save(DeptParam param);

    void update(DeptParam param);

    void delete(int deptId);
}
