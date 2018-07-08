package com.one.demo.service.impl;

import com.one.demo.dao.ApplyDao;
import com.one.demo.dao.ApplyTaskDao;
import com.one.demo.entity.ApplyEntity;
import com.one.demo.entity.ApplyTaskEntity;
import com.one.demo.service.ApplyService;
import com.one.demo.service.finder.ApplyFinder;
import com.one.demo.utils.DefaultConfigure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyDao applyDao;
    @Autowired
    private ApplyTaskDao taskDao;

    /**
     * 查询申请列表
     *
     * @param finder
     * @return
     */
    @Override
    public List<ApplyEntity> findAll(ApplyFinder finder) {
        return applyDao.findAll();
    }

    /**
     * 借阅申请
     *
     * @param entity
     */
    @Override
    @Transactional
    public void borrowApply(ApplyEntity entity) {

        entity.borrowInit();
        entity = applyDao.saveAndFlush(entity);
        ApplyTaskEntity taskEntity = convert2TaskEntity(entity, DefaultConfigure.TASK_TYPE_APPLY);
        // 写入task中
        taskDao.save(taskEntity );
        //TODO 添加消息通知
    }

    /**
     * 延期申请
     *
     * @param entity
     */
    @Override
    @Transactional
    public void lazyApply(ApplyEntity entity) {
        //验证
        Optional<ApplyEntity> findEntity = applyDao.findById(entity.getId());
        if(!findEntity.isPresent()){
            throw new RuntimeException("未找到对应的申请信息");
        }
        if(!findEntity.get().finishPull()){
            throw new RuntimeException("数据状态不正确,刷新重试!");
        }
        entity.lazyInit();
        entity = applyDao.saveAndFlush(entity);
        ApplyTaskEntity taskEntity = convert2TaskEntity(entity, DefaultConfigure.TASK_TYPE_LAZY);
        // 写入task中
        taskDao.save(taskEntity );
        //TODO 添加消息通知

    }

    /**
     * 归还申请
     *
     * @param entity
     */
    @Override
    @Transactional
    public void backApply(ApplyEntity entity) {
        //验证
        Optional<ApplyEntity> findEntity = applyDao.findById(entity.getId());
        if(!findEntity.isPresent()){
            throw new RuntimeException("未找到对应的申请信息");
        } else if(!findEntity.get().finishPullOrLazyOrCancel()){
            throw new RuntimeException("数据状态不正确,刷新重试!");
        }
        entity.lazyInit();
        entity = applyDao.saveAndFlush(entity);
        ApplyTaskEntity taskEntity = convert2TaskEntity(entity, DefaultConfigure.TASK_TYPE_BACK);
        // 写入task中
        taskDao.save(taskEntity );
        //TODO 添加消息通知
    }

    private ApplyTaskEntity convert2TaskEntity(ApplyEntity entity, int type ){
        ApplyTaskEntity taskEntity = new ApplyTaskEntity();
        taskEntity.setApplyId(entity.getId());
        taskEntity.setApplyDate(entity.getCreateDate());
        taskEntity.setApplyUsername(entity.getApplyUsername());
        taskEntity.setType(type);
        taskEntity.setStatus(DefaultConfigure.TASK_STATUS_CHECK);
        return taskEntity;
    }
}
