package com.pengtan.aicollab.repository;

import com.pengtan.aicollab.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * ClassName: TaskRepository
 * Description:
 *
 * @Author Tanpeng
 * @Create 2026/3/11 22:50
 * @Version 1.0
 */
public interface TaskRepository  extends JpaRepository<Task,Long>{
}
