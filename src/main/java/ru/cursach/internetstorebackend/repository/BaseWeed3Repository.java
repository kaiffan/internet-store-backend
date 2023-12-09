package ru.cursach.internetstorebackend.repository;

import org.noear.weed.DbContext;
import ru.cursach.internetstorebackend.annotation.Table;
import ru.cursach.internetstorebackend.domain.entity.Entity;

public abstract class BaseWeed3Repository<TEntity extends Entity> {
    protected DbContext db;
    protected String tableName;

    public BaseWeed3Repository(DbContext dbContext, Class<?> entityClass){
        db = dbContext;
        tableName = entityClass.getAnnotation(Table.class).name();
    }
}